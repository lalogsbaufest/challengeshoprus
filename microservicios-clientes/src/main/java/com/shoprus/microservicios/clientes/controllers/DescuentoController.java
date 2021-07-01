package com.shoprus.microservicios.clientes.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.commons.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.DescuentoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Descuento;
import com.shoprus.microservicios.commons.descuentos.models.entities.DescuentoPorTipoProducto;
import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;
import com.shoprus.microservicios.commons.descuentos.models.entities.TipoAcumulacionDescuento;
import com.shoprus.microservicios.commons.descuentos.models.entities.TipoCondicionDescuentoCantidad;
import com.shoprus.microservicios.commons.descuentos.models.entities.TipoCondicionDescuentoUsuario;
import com.shoprus.microservicios.commons.descuentos.models.entities.TipoDescuento;
import com.shoprus.microservicios.commons.descuentos.models.entities.TipoProducto;
import com.shoprus.microservicios.commons.utils.IConstantes;
import com.shoprus.microservicios.descuentos.services.IDescuentoPorTipoProductoService;
import com.shoprus.microservicios.descuentos.services.IProductoService;
import com.shoprus.microservicios.descuentos.services.ITipoAcumulacionDescuentoService;
import com.shoprus.microservicios.descuentos.services.ITipoCondicionDescuentoCantitadService;
import com.shoprus.microservicios.descuentos.services.ITipoCondicionDescuentoUsuarioService;
import com.shoprus.microservicios.descuentos.services.ITipoDescuentoService;
import com.shoprus.microservicios.descuentos.services.ITipoProductoService;
import com.shoprus.microservicios.descuentos.services.impl.DescuentoServiceImpl;
import com.shoprus.microservicios.generics.controllers.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    private IDescuentoPorTipoProductoService descuentoPorTipoProductoService;

    @Autowired
    private ITipoProductoService tipoProductoService;
    
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

            usuario = service.obtenerDetallesCliente(idCliente);

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

    @PostMapping("/carrito")
    public ResponseEntity<ResumenOrdenDTO> descuentosCarrito (@RequestBody SolicitudCompraDTO compra) {

        var requestString = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(compra));
        logger.info(requestString);

        var usuario = obtenerYValidarUsuario(compra.getIdCliente());

        List<Long> idsProducto = extraerAListaIdsProductos(compra.getCarrito());

        List<Producto> listaEntidadesProducto = obtenerYValidarProductos(idsProducto); 

        compra.setCarrito(llenarCarritoConEntidadesProducto(compra.getCarrito(), listaEntidadesProducto));

        ResumenOrdenDTO resumenOrden = service.findDescuentoPorCarrito(compra.getCarrito(), usuario);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(resumenOrden));
        logger.info(responseString);

        return ResponseEntity.ok(resumenOrden);
    }

    @PostMapping("/crear")
    public ResponseEntity<Descuento> crear (DescuentoDTO descuento) {

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

        List<TipoProducto> listaEntidadesProducto = obtenerYValidarTipoProducto(descuento.getIdsProductosQueAplica());

        var descuentoDB = new Descuento();
        descuentoDB.setTipoAcumulacionDescuento(tipoAcumulacionDescuento.get());
        descuentoDB.setTipoDescuento(tipoDescuento.get());
        descuentoDB.setTipoCondicionDescuentoCantidad(tipoCondicionDescuentoCantidad.get());
        descuentoDB.setTipoCondicionDescuentoUsuario(tipoCondicionDescuentoUsuario.get());
        descuentoDB.setValorCondicion(descuento.getValorCondicion());
        descuentoDB.setValorDescuento(descuento.getValorDescuento());

        descuentoDB = service.save(descuentoDB);

        List<DescuentoPorTipoProducto> descuentosPorTipoProducto = guardarDescuentosPorTipoProducto(descuentoDB, listaEntidadesProducto);
        descuentoDB.setDescuentosPorProducto(descuentosPorTipoProducto);

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(descuentoDB));
        logger.info(responseString);

        return ResponseEntity.ok(descuentoDB);
    }

    @PostMapping("/listaProductos")
    public List<Producto> obtenerProductosPorId (@RequestBody List<Long> idsProducto) {

        var requestString = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(idsProducto));
        logger.info(requestString);

        List<Long> idsProductosRequest = new ArrayList<>();
        
        idsProducto.forEach(
            idsProductosRequest::add
        );

        List<Producto> productosExistentes = productoService.findAllById(idsProductosRequest);

        if (idsProductosRequest.size() > productosExistentes.size()) {

            var idsProductosString = new StringBuilder();
            var guion = " - ";
            
            productosExistentes.forEach(producto -> {
                idsProductosString.append(producto.getId() + guion);
            });

            throw new DataIntegrityViolationException(
                "La lista de Productos no es correcta, solo existen los Productos con los siguientes IDs: [" + idsProductosString + "]"
            );
        } else {

            var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(productosExistentes));
            logger.info(responseString);

            return productosExistentes;
        }
    }

    private List<DescuentoPorTipoProducto> guardarDescuentosPorTipoProducto (Descuento descuentoDB, List<TipoProducto> tiposProductos) {

        List<DescuentoPorTipoProducto> descuentosPorTipoProductos = new ArrayList<>();

        tiposProductos.forEach(tipoProducto -> descuentosPorTipoProductos.add(new DescuentoPorTipoProducto(descuentoDB, tipoProducto)));

        return descuentoPorTipoProductoService.saveAlls(descuentosPorTipoProductos);
    }

    private Usuario obtenerYValidarUsuario (Long idCliente) {
        var usuario = service.obtenerDetallesCliente(idCliente);

        if (usuario == null) {
            throw new DataIntegrityViolationException("El ID del cliente no existe");
        } else {
            return usuario;
        }
    }

    private List<Long> extraerAListaIdsProductos (List<ArticuloCarritoDTO> carrito) {
        List<Long> idsProducto = new ArrayList<>();

        carrito.forEach(itemCarrito -> {
            idsProducto.add(itemCarrito.getIdProducto());
        });

        return idsProducto;
    }

    private List<Producto> obtenerYValidarProductos (List<Long> idsProducto) {
        List<Long> idsProductosRequest = new ArrayList<>();
        
        idsProducto.forEach(
            idsProductosRequest::add
        );

        List<Producto> productosExistentes = productoService.findAllById(idsProductosRequest);

        if (idsProductosRequest.size() > productosExistentes.size()) {

            var idsProductosString = new StringBuilder();
            var guion = " - ";
            
            productosExistentes.forEach(producto -> {
                idsProductosString.append(producto.getId() + guion);
            });

            throw new DataIntegrityViolationException(
                "La lista de Productos no es correcta, solo existen los Productos con los siguientes IDs: [" + idsProductosString + "]"
            );
        } else {
            return productosExistentes;
        }
    }

    private List<TipoProducto> obtenerYValidarTipoProducto (List<Long> idsTipoProducto) {
        List<Long> idsTipoProductoRequest = new ArrayList<>();
        
        idsTipoProducto.forEach(
            idsTipoProductoRequest::add
        );

        List<TipoProducto> tiposProductosExistentes = tipoProductoService.findAllById(idsTipoProductoRequest);

        if (idsTipoProductoRequest.size() > tiposProductosExistentes.size()) {

            var idsProductosString = new StringBuilder();
            var guion = " - ";
            
            tiposProductosExistentes.forEach(producto -> {
                idsProductosString.append(producto.getId() + guion);
            });

            throw new DataIntegrityViolationException(
                "La lista de Tipos Productos no es correcta, solo existen los TiposProductos con los siguientes IDs: [" + idsProductosString + "]"
            );
        } else {
            return tiposProductosExistentes;
        }
    }

    private List<ArticuloCarritoDTO> llenarCarritoConEntidadesProducto (List<ArticuloCarritoDTO> carrito, List<Producto> productosExistentes) {
        carrito.forEach(articulo -> {

            for (Producto producto : productosExistentes) {
                if (articulo.getIdProducto().equals(producto.getId())) {
                    articulo.setProducto(producto);
                    break;
                }
            }
        });

        return carrito;
    }
}