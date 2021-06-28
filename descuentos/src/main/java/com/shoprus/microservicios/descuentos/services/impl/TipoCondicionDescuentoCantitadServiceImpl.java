package com.shoprus.microservicios.descuentos.services.impl;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoCondicionDescuentoCantidad;
import com.shoprus.microservicios.descuentos.respositories.ITipoCondicionDescuentoCantitadRepository;
import com.shoprus.microservicios.descuentos.services.ITipoCondicionDescuentoCantitadService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class TipoCondicionDescuentoCantitadServiceImpl extends GenericServiceImpl<TipoCondicionDescuentoCantidad, ITipoCondicionDescuentoCantitadRepository> implements ITipoCondicionDescuentoCantitadService{
    
}
