package com.shoprus.microservicios.descuentos.services.impl;

import java.util.List;

import com.shoprus.microservicios.commons.descuentos.models.entities.DescuentoPorTipoProducto;
import com.shoprus.microservicios.descuentos.respositories.IDescuentoPorTipoProductoRepository;
import com.shoprus.microservicios.descuentos.services.IDescuentoPorTipoProductoService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescuentoPorTipoProductoServiceImpl extends GenericServiceImpl<DescuentoPorTipoProducto, IDescuentoPorTipoProductoRepository> implements IDescuentoPorTipoProductoService {

    @Transactional(readOnly = false)
    public List<DescuentoPorTipoProducto> saveAlls(List<DescuentoPorTipoProducto> descuentosPorProducto) {
        return (List<DescuentoPorTipoProducto>)repository.saveAll(descuentosPorProducto);
    }
}
