package com.shoprus.microservicios.services.impl;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.TipoDescuento;
import com.shoprus.microservicios.models.repositories.ITipoDescuentoRepository;
import com.shoprus.microservicios.services.ITipoDescuentoService;

import org.springframework.stereotype.Service;

@Service
public class TipoDescuentoServiceImpl extends GenericServiceImpl<TipoDescuento, ITipoDescuentoRepository> implements ITipoDescuentoService{
    
}
