package com.shoprus.microservicios.services.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.models.entities.Descuento;
import com.shoprus.microservicios.models.entities.DescuentosPorFactura;
import com.shoprus.microservicios.models.entities.Factura;
import com.shoprus.microservicios.models.entities.Producto;
import com.shoprus.microservicios.models.entities.ProductosCarrito;
import com.shoprus.microservicios.services.IDescuentosPorFacturaService;
import com.shoprus.microservicios.services.IProductosCarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacturaLogic {

    @Autowired
    IDescuentosPorFacturaService descuentosPorFacturaService;

    @Autowired
    IProductosCarritoService productosCarritoService;

    public List<DescuentosPorFactura> guardarDescuentosPorFactura (Factura facturaDB, List<Descuento> idsDescuentos) {

        List<DescuentosPorFactura> descuentosPorFactura = new ArrayList<>();

        idsDescuentos.forEach(descuento -> descuentosPorFactura.add(new DescuentosPorFactura(facturaDB, descuento)));

        facturaDB.setDescuentos(descuentosPorFactura);

        return descuentosPorFacturaService.saveAlls(descuentosPorFactura);
    } 

    public List<ProductosCarrito> guardarProductosCarrito (Factura facturaDB, List<ArticuloCarritoDTO> carrito, List<Producto> listaEntidadesProducto) {

        List<ProductosCarrito> productosCarrito = new ArrayList<>();

        Map<Long, Producto> mapEntidadesProducto = listaAMapaProductos(listaEntidadesProducto);

        carrito.forEach(articulo -> productosCarrito.add(new ProductosCarrito(facturaDB, articulo.getCantidad(), mapEntidadesProducto.get(articulo.getIdProducto()))));

        facturaDB.setProductosCarrito(productosCarrito);

        return productosCarritoService.saveAlls(productosCarrito);
    } 

    private Map<Long, Producto> listaAMapaProductos(List<Producto> list) {
        return list.stream()
          .collect(Collectors.toMap(Producto::getId, Function.identity()));
    }  
}