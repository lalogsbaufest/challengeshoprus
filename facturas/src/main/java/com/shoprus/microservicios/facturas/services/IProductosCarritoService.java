package com.shoprus.microservicios.facturas.services;

import java.util.List;

import com.shoprus.microservicios.commons.facturas.models.entities.ProductosCarrito;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface IProductosCarritoService extends IGenericService<ProductosCarrito>{
    
    public List<ProductosCarrito> saveAlls(List<ProductosCarrito> descuentosPorFactura);
}
