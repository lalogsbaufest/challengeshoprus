package com.shoprus.microservicios.services;

import java.util.List;

import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.Producto;

public interface IProductoService extends IGenericService<Producto> {
    
    public List<Producto> findAllById (List<Long> ids);
}
