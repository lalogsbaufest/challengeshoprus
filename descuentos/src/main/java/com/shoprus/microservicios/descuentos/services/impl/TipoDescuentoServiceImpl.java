package com.shoprus.microservicios.descuentos.services.impl;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoDescuento;
import com.shoprus.microservicios.descuentos.respositories.ITipoDescuentoRepository;
import com.shoprus.microservicios.descuentos.services.ITipoDescuentoService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class TipoDescuentoServiceImpl extends GenericServiceImpl<TipoDescuento, ITipoDescuentoRepository> implements ITipoDescuentoService{
    
}
