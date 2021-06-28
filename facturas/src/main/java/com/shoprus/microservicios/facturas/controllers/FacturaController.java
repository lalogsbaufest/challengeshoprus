package com.shoprus.microservicios.facturas.controllers;

import java.util.ArrayList;
import java.util.List;

import com.shoprus.microservicios.commons.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Descuento;
import com.shoprus.microservicios.commons.facturas.models.entities.DescuentosPorFactura;
import com.shoprus.microservicios.commons.facturas.models.entities.Factura;
import com.shoprus.microservicios.commons.facturas.models.entities.ProductosCarrito;
import com.shoprus.microservicios.commons.utils.IConstantes;
import com.shoprus.microservicios.facturas.services.IDescuentosPorFacturaService;
import com.shoprus.microservicios.facturas.services.IProductosCarritoService;
import com.shoprus.microservicios.facturas.services.impl.FacturasServicesImpl;
import com.shoprus.microservicios.generics.controllers.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturaController extends GenericController<Factura, FacturasServicesImpl> {

    @Autowired
    IDescuentosPorFacturaService descuentosPorFacturaService;

    @Autowired
    IProductosCarritoService productosCarritoService;
 
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

        List<Long> idsProducto = extraerAListaIdsProductos(solicitudCompra.getCarrito());
        try {
            service.obtenerYValidarProductos(idsProducto);
        } catch (Exception e) {
            throw new DataIntegrityViolationException(
                "Uno o mas IDs de Producto no existen"
            );
        }

        var resumenOrdenDTO = service.validarSolicitudComprarCrearResumen(solicitudCompra);

        var facturaDB = new Factura();
        facturaDB.setIdUsuario(idCliente);
        facturaDB.setTotalDescuento(resumenOrdenDTO.getTotalDescuento());
        facturaDB.setTotalSinDescuento(resumenOrdenDTO.getTotalSinDescuento());
        facturaDB = service.save(facturaDB);

        guardarDescuentosPorFactura(facturaDB, resumenOrdenDTO.getDescuentoAplicados());

        guardarProductosCarrito(facturaDB, solicitudCompra.getCarrito());

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(facturaDB));
        logger.info(responseString);

        return ResponseEntity.ok(facturaDB);
    }

    private List<DescuentosPorFactura> guardarDescuentosPorFactura (Factura facturaDB, List<Descuento> idsDescuentos) {

        List<DescuentosPorFactura> descuentosPorFactura = new ArrayList<>();

        idsDescuentos.forEach(descuento -> descuentosPorFactura.add(new DescuentosPorFactura(facturaDB, descuento.getId())));

        facturaDB.setDescuentos(descuentosPorFactura);

        return descuentosPorFacturaService.saveAlls(descuentosPorFactura);
    } 

    private List<ProductosCarrito> guardarProductosCarrito (Factura facturaDB, List<ArticuloCarritoDTO> carrito) {

        List<ProductosCarrito> productosCarrito = new ArrayList<>();

        carrito.forEach(articulo -> productosCarrito.add(new ProductosCarrito(facturaDB, articulo.getIdProducto(), articulo.getCantidad())));

        facturaDB.setProductosCarrito(productosCarrito);

        return productosCarritoService.saveAlls(productosCarrito);
    } 

    private List<Long> extraerAListaIdsProductos (List<ArticuloCarritoDTO> carrito) {
        List<Long> idsProducto = new ArrayList<>();

        carrito.forEach(itemCarrito -> {
            idsProducto.add(itemCarrito.getIdProducto());
        });

        return idsProducto;
    }
}