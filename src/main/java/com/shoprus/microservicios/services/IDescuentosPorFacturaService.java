package com.shoprus.microservicios.services;

import java.util.List;

import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.DescuentosPorFactura;

public interface IDescuentosPorFacturaService extends IGenericService<DescuentosPorFactura>{
    
    public List<DescuentosPorFactura> saveAlls(List<DescuentosPorFactura> descuentosPorFactura);
}