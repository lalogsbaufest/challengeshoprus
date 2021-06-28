package com.shoprus.microservicios.descuentos.services.impl;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoAcumulacionDescuento;
import com.shoprus.microservicios.descuentos.respositories.ITipoAcumulacionDescuentoRepository;
import com.shoprus.microservicios.descuentos.services.ITipoAcumulacionDescuentoService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class TipoAcumulacionDescuentoServiceImpl extends GenericServiceImpl<TipoAcumulacionDescuento, ITipoAcumulacionDescuentoRepository> implements ITipoAcumulacionDescuentoService{
    
}
