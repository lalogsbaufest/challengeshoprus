package com.shoprus.microservicios.facturas.services;

import java.util.List;

import com.shoprus.microservicios.commons.facturas.models.entities.DescuentosPorFactura;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface IDescuentosPorFacturaService extends IGenericService<DescuentosPorFactura>{
    
    public List<DescuentosPorFactura> saveAlls(List<DescuentosPorFactura> descuentosPorFactura);
}