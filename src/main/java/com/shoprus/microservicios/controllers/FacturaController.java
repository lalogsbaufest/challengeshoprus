package com.shoprus.microservicios.controllers;

import java.util.List;

import com.shoprus.microservicios.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.generics.controllers.GenericController;
import com.shoprus.microservicios.models.entities.Factura;
import com.shoprus.microservicios.models.entities.Producto;
import com.shoprus.microservicios.services.IDescuentosPorFacturaService;
import com.shoprus.microservicios.services.IProductosCarritoService;
import com.shoprus.microservicios.services.impl.FacturasServicesImpl;
import com.shoprus.microservicios.services.logic.FacturaLogic;
import com.shoprus.microservicios.services.logic.ProductoLogic;
import com.shoprus.microservicios.utils.IConstantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/facturas")
public class FacturaController extends GenericController<Factura, FacturasServicesImpl> {

    @Autowired
    IDescuentosPorFacturaService descuentosPorFacturaService;

    @Autowired
    IProductosCarritoService productosCarritoService;

    @Autowired
    ProductoLogic productoLogic;

    @Autowired
    FacturaLogic facturaLogic;
 
    @Operation(summary = "Registrar de una Factura")
    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody SolicitudCompraDTO solicitudCompra) {

        var requestPrint = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(solicitudCompra));
        logger.info(requestPrint);

        Long idCliente = solicitudCompra.getIdCliente();
        try {
            service.obtenerDetallesCliente(idCliente);
        } catch (Exception e) {
            throw new DataIntegrityViolationException(
                "No existe el cliente con ID: [" + idCliente + "]"
            );
        }

        List<Long> idsProducto = productoLogic.extraerListaIdsProductos(solicitudCompra.getCarrito());
        List<Producto> productosEntidades = productoLogic.traerYValidarProductosExistentes(idsProducto);

        var resumenOrdenDTO = service.validarSolicitudComprarCrearResumen(solicitudCompra);

        var facturaDB = new Factura();
        facturaDB.setIdUsuario(idCliente);
        facturaDB.setTotalDescuento(resumenOrdenDTO.getTotalDescuento());
        facturaDB.setTotalSinDescuento(resumenOrdenDTO.getTotalSinDescuento());
        facturaDB = service.save(facturaDB);

        facturaLogic.guardarDescuentosPorFactura(facturaDB, resumenOrdenDTO.getDescuentoAplicados());

        facturaLogic.guardarProductosCarrito(facturaDB, solicitudCompra.getCarrito(), productosEntidades);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(facturaDB));
        logger.info(responseString);

        return ResponseEntity.ok(facturaDB);
    }
}