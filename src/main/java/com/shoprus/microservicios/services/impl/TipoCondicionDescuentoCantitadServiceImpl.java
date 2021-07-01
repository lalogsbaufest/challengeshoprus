package com.shoprus.microservicios.services.impl;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.TipoCondicionDescuentoCantidad;
import com.shoprus.microservicios.models.repositories.ITipoCondicionDescuentoCantitadRepository;
import com.shoprus.microservicios.services.ITipoCondicionDescuentoCantitadService;

import org.springframework.stereotype.Service;

@Service
public class TipoCondicionDescuentoCantitadServiceImpl extends GenericServiceImpl<TipoCondicionDescuentoCantidad, ITipoCondicionDescuentoCantitadRepository> implements ITipoCondicionDescuentoCantitadService{
    
}
