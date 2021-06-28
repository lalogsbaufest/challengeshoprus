package com.shoprus.microservicios.descuentos.services.impl;

import java.util.List;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoProducto;
import com.shoprus.microservicios.descuentos.respositories.ITipoProductoRepository;
import com.shoprus.microservicios.descuentos.services.ITipoProductoService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class TipoProductoServiceImpl extends GenericServiceImpl<TipoProducto, ITipoProductoRepository> implements ITipoProductoService{

    @Override
    public List<TipoProducto> findAllById(List<Long> idsTipoProducto) {
        return (List<TipoProducto>)repository.findAllById(idsTipoProducto);
    }
    
}
