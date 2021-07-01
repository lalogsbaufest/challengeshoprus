package com.shoprus.microservicios.services;

import java.util.List;

import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.DescuentoPorTipoProducto;

public interface IDescuentoPorTipoProductoService extends IGenericService<DescuentoPorTipoProducto>{
    public List<DescuentoPorTipoProducto> saveAlls(List<DescuentoPorTipoProducto> descuentosPorProducto);
}
