package com.shoprus.microservicios.services.impl;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.TipoAcumulacionDescuento;
import com.shoprus.microservicios.models.repositories.ITipoAcumulacionDescuentoRepository;
import com.shoprus.microservicios.services.ITipoAcumulacionDescuentoService;

import org.springframework.stereotype.Service;

@Service
public class TipoAcumulacionDescuentoServiceImpl extends GenericServiceImpl<TipoAcumulacionDescuento, ITipoAcumulacionDescuentoRepository> implements ITipoAcumulacionDescuentoService{
    
}
