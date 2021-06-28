package com.shoprus.microservicios.descuentos.services;

import java.util.List;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoProducto;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface ITipoProductoService extends IGenericService<TipoProducto>{
 
    List<TipoProducto> findAllById(List<Long> idsTipoProducto);
}
