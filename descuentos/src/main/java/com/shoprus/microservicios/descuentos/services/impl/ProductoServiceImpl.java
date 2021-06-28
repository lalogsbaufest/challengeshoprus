package com.shoprus.microservicios.descuentos.services.impl;

import java.util.List;

import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;
import com.shoprus.microservicios.descuentos.respositories.IProductoRepository;
import com.shoprus.microservicios.descuentos.services.IProductoService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, IProductoRepository> implements IProductoService {
    
    public List<Producto> findAllById (List<Long> ids) {
        return (List<Producto>)repository.findAllById(ids);
    }
}
