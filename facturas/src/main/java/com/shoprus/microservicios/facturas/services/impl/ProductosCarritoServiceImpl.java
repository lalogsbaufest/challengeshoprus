package com.shoprus.microservicios.facturas.services.impl;

import java.util.List;

import com.shoprus.microservicios.commons.facturas.models.entities.ProductosCarrito;
import com.shoprus.microservicios.facturas.repositories.IProductosCarritoRepository;
import com.shoprus.microservicios.facturas.services.IProductosCarritoService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductosCarritoServiceImpl extends GenericServiceImpl<ProductosCarrito, IProductosCarritoRepository> implements IProductosCarritoService{

    @Override
    @Transactional(readOnly = false)
    public List<ProductosCarrito> saveAlls(List<ProductosCarrito> descuentosPorFactura) {
        return (List<ProductosCarrito>)repository.saveAll(descuentosPorFactura);
    }
    
}
