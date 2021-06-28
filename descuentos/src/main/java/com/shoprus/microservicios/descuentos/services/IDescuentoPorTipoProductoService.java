package com.shoprus.microservicios.descuentos.services;

import java.util.List;

import com.shoprus.microservicios.commons.descuentos.models.entities.DescuentoPorTipoProducto;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface IDescuentoPorTipoProductoService extends IGenericService<DescuentoPorTipoProducto>{
    public List<DescuentoPorTipoProducto> saveAlls(List<DescuentoPorTipoProducto> descuentosPorProducto);
}
