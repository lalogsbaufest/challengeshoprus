package com.shoprus.microservicios.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.controllers.dtos.DescuentoDTO;
import com.shoprus.microservicios.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.generics.controllers.GenericController;
import com.shoprus.microservicios.models.entities.Descuento;
import com.shoprus.microservicios.models.entities.DescuentoPorTipoProducto;
import com.shoprus.microservicios.models.entities.Producto;
import com.shoprus.microservicios.models.entities.TipoAcumulacionDescuento;
import com.shoprus.microservicios.models.entities.TipoCondicionDescuentoCantidad;
import com.shoprus.microservicios.models.entities.TipoCondicionDescuentoUsuario;
import com.shoprus.microservicios.models.entities.TipoDescuento;
import com.shoprus.microservicios.models.entities.TipoProducto;
import com.shoprus.microservicios.models.entities.Usuario;
import com.shoprus.microservicios.services.IProductoService;
import com.shoprus.microservicios.services.ITipoAcumulacionDescuentoService;
import com.shoprus.microservicios.services.ITipoCondicionDescuentoCantitadService;
import com.shoprus.microservicios.services.ITipoCondicionDescuentoUsuarioService;
import com.shoprus.microservicios.services.ITipoDescuentoService;
import com.shoprus.microservicios.services.impl.DescuentoServiceImpl;
import com.shoprus.microservicios.services.logic.DescuentoLogic;
import com.shoprus.microservicios.services.logic.ProductoLogic;
import com.shoprus.microservicios.services.logic.UsuarioLogic;
import com.shoprus.microservicios.utils.IConstantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController extends GenericController<Descuento, DescuentoServiceImpl> {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ITipoAcumulacionDescuentoService tipoAcumulacionDescuentoService;

    @Autowired
    private ITipoCondicionDescuentoUsuarioService tipoCondicionDescuentoUsuarioService;

    @Autowired
    private ITipoCondicionDescuentoCantitadService tipoCondicionDescuentoCantitadService;

    @Autowired
    private ITipoDescuentoService tipoDescuentoService;

    @Autowired
    private ProductoLogic productoLogic;

    @Autowired
    private DescuentoLogic descuentoLogic;

    @Autowired
    private UsuarioLogic usuarioLogic;

    @Operation(summary = "Búsqueda de descuentos por idProducto y idCliente")
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<ResumenOrdenDTO> descuentosPorProducto (@RequestParam(defaultValue = "0") Long idCliente, @PathVariable Long idProducto) {

        var requestString = String.format(IConstantes.LOG_REQUEST, ("idCliente:" + idCliente + "- idProducto: " + idProducto));
        logger.info(requestString);

        Optional<Producto> producto = productoService.findById(idProducto);
        if (producto.isEmpty()) {
            throw new DataIntegrityViolationException("El ID del producto no existe");
        }

        Usuario usuario = null;
        if (idCliente != 0) {

            usuario = usuarioLogic.obtenerYValidarUsuario(idCliente);

            if (usuario == null) {
                throw new DataIntegrityViolationException("El ID del cliente no existe");
            }
        }
        
        List<ArticuloCarritoDTO> carrito = new ArrayList<>();
        carrito.add(new ArticuloCarritoDTO(idProducto, 1, producto.get()));

        ResumenOrdenDTO resumenOrden = service.findDescuentoPorCarrito(carrito, usuario);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(resumenOrden));
        logger.info(responseString);

        return ResponseEntity.ok(resumenOrden);
    }

    @Operation(summary = "Búsqueda de descuentos por un conjunto de productos y para un cliente")
    @PostMapping("/carrito")
    public ResponseEntity<ResumenOrdenDTO> descuentosCarrito (@RequestBody SolicitudCompraDTO compra) {

        var requestString = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(compra));
        logger.info(requestString);

        ResumenOrdenDTO resumenOrden = descuentoLogic.aplicarDescuentoSobreSolicitudCompra(compra);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(resumenOrden));
        logger.info(responseString);

        return ResponseEntity.ok(resumenOrden);
    }

    @Operation(summary = "Registro de un nuevo Descuento")
    @PostMapping
    public ResponseEntity<Descuento> crear (@RequestBody DescuentoDTO descuento) {

        var requestString = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(descuento));
        logger.info(requestString);

        Optional<TipoAcumulacionDescuento> tipoAcumulacionDescuento = tipoAcumulacionDescuentoService.findById(descuento.getTipoAcumulacionDescuentoId());
        if (tipoAcumulacionDescuento.isEmpty()) {
            throw new DataIntegrityViolationException("El ID del TipoAcumulacionDescuento no existe");
        }

        Optional<TipoDescuento> tipoDescuento = tipoDescuentoService.findById(descuento.getTipoDescuentoId());
        if (tipoDescuento.isEmpty()) {
            throw new DataIntegrityViolationException("El ID del TipoDescuento no existe");
        }

        Optional<TipoCondicionDescuentoCantidad> tipoCondicionDescuentoCantidad = tipoCondicionDescuentoCantitadService.findById(descuento.getTipoCondicionDescuentoCantidadId());
        if (tipoCondicionDescuentoCantidad.isEmpty()) {
            throw new DataIntegrityViolationException("El ID del TipoDescuentoCantidad no existe");
        }

        Optional<TipoCondicionDescuentoUsuario> tipoCondicionDescuentoUsuario = tipoCondicionDescuentoUsuarioService.findById(descuento.getTipoCondicionDescuentoUsuarioId());
        if (tipoCondicionDescuentoUsuario.isEmpty()) {
            throw new DataIntegrityViolationException("El ID del TipoDescuentoUsuario no existe");
        }

        List<TipoProducto> listaEntidadesProducto = productoLogic.traerYValidarTipoProducto(descuento.getIdsProductosQueAplica());

        var descuentoDB = new Descuento();
        descuentoDB.setTipoAcumulacionDescuento(tipoAcumulacionDescuento.get());
        descuentoDB.setTipoDescuento(tipoDescuento.get());
        descuentoDB.setTipoCondicionDescuentoCantidad(tipoCondicionDescuentoCantidad.get());
        descuentoDB.setTipoCondicionDescuentoUsuario(tipoCondicionDescuentoUsuario.get());
        descuentoDB.setValorCondicion(descuento.getValorCondicion());
        descuentoDB.setValorDescuento(descuento.getValorDescuento());

        descuentoDB = service.save(descuentoDB);

        List<DescuentoPorTipoProducto> descuentosPorTipoProducto = descuentoLogic.guardarDescuentosPorTipoProducto(descuentoDB, listaEntidadesProducto);
        descuentoDB.setDescuentosPorProducto(descuentosPorTipoProducto);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(descuentoDB));
        logger.info(responseString);

        return ResponseEntity.ok(descuentoDB);
    }

    @PostMapping("/listaProductos")
    public ResponseEntity<List<Producto>> obtenerProductosPorId (@RequestBody List<Long> idsProducto) {

        var requestString = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(idsProducto));
        logger.info(requestString);

        List<Producto> productosExistentes = productoLogic.traerYValidarProductosExistentes(idsProducto);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(productosExistentes));
        logger.info(responseString);

        return ResponseEntity.ok(productosExistentes);
    }
}