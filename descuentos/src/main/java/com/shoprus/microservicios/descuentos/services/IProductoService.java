package com.shoprus.microservicios.descuentos.services;

import java.util.List;

import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface IProductoService extends IGenericService<Producto> {
    
    public List<Producto> findAllById (List<Long> ids);
}
