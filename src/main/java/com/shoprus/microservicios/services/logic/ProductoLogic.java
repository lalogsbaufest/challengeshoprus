package com.shoprus.microservicios.services.logic;

import java.util.ArrayList;
import java.util.List;

import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.models.entities.Producto;
import com.shoprus.microservicios.models.entities.TipoProducto;
import com.shoprus.microservicios.services.IProductoService;
import com.shoprus.microservicios.services.ITipoProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class ProductoLogic {

    @Autowired 
    IProductoService productoService;

    @Autowired
    ITipoProductoService tipoProductoService;
 
    public List<Long> extraerListaIdsProductos (List<ArticuloCarritoDTO> carrito) {
        List<Long> idsProducto = new ArrayList<>();

        carrito.forEach(itemCarrito -> {
            idsProducto.add(itemCarrito.getIdProducto());
        });

        return idsProducto;
    }

    public List<Producto> traerYValidarProductosExistentes (List<Long> idsProducto) throws DataIntegrityViolationException{
        List<Producto> productosExistentes = productoService.findAllById(idsProducto);

        if (idsProducto.size() > productosExistentes.size()) {

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

    public List<TipoProducto> traerYValidarTipoProducto (List<Long> idsTipoProducto) {
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

    public List<ArticuloCarritoDTO> llenarCarritoConEntidadesProducto (List<ArticuloCarritoDTO> carrito, List<Producto> productosExistentes) {
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