package com.shoprus.microservicios.services.impl;

import java.util.List;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.DescuentosPorFactura;
import com.shoprus.microservicios.models.repositories.IDescuentosPorFacturaRepository;
import com.shoprus.microservicios.services.IDescuentosPorFacturaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescuentoPorFacturaServiceImpl extends GenericServiceImpl<DescuentosPorFactura, IDescuentosPorFacturaRepository> implements IDescuentosPorFacturaService {

    @Override
    @Transactional(readOnly = false)
    public List<DescuentosPorFactura> saveAlls(List<DescuentosPorFactura> descuentosPorFactura) {
        return (List<DescuentosPorFactura>)repository.saveAll(descuentosPorFactura);
    }
    
}
