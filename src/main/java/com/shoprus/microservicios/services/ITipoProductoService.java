package com.shoprus.microservicios.services;

import java.util.List;

import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.TipoProducto;

public interface ITipoProductoService extends IGenericService<TipoProducto>{
 
    List<TipoProducto> findAllById(List<Long> idsTipoProducto);
}
