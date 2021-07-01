package com.shoprus.microservicios.services.impl;

import java.util.List;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.DescuentoPorTipoProducto;
import com.shoprus.microservicios.models.repositories.IDescuentoPorTipoProductoRepository;
import com.shoprus.microservicios.services.IDescuentoPorTipoProductoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescuentoPorTipoProductoServiceImpl extends GenericServiceImpl<DescuentoPorTipoProducto, IDescuentoPorTipoProductoRepository> implements IDescuentoPorTipoProductoService {

    @Transactional(readOnly = false)
    public List<DescuentoPorTipoProducto> saveAlls(List<DescuentoPorTipoProducto> descuentosPorProducto) {
        return (List<DescuentoPorTipoProducto>)repository.saveAll(descuentosPorProducto);
    }
}
