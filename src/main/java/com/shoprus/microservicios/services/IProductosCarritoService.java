package com.shoprus.microservicios.services;

import java.util.List;

import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.ProductosCarrito;

public interface IProductosCarritoService extends IGenericService<ProductosCarrito>{
    
    public List<ProductosCarrito> saveAlls(List<ProductosCarrito> descuentosPorFactura);
    
}
