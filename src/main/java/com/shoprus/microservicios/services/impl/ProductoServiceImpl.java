package com.shoprus.microservicios.services.impl;

import java.util.List;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.Producto;
import com.shoprus.microservicios.models.repositories.IProductoRepository;
import com.shoprus.microservicios.services.IProductoService;

import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, IProductoRepository> implements IProductoService {
    
    public List<Producto> findAllById (List<Long> ids) {
        return (List<Producto>)repository.findAllById(ids);
    }
}
