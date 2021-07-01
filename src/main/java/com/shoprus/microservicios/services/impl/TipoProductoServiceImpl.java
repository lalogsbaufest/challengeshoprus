package com.shoprus.microservicios.services.impl;

import java.util.List;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.TipoProducto;
import com.shoprus.microservicios.models.repositories.ITipoProductoRepository;
import com.shoprus.microservicios.services.ITipoProductoService;

import org.springframework.stereotype.Service;

@Service
public class TipoProductoServiceImpl extends GenericServiceImpl<TipoProducto, ITipoProductoRepository> implements ITipoProductoService{

    @Override
    public List<TipoProducto> findAllById(List<Long> idsTipoProducto) {
        return (List<TipoProducto>)repository.findAllById(idsTipoProducto);
    }
    
}
