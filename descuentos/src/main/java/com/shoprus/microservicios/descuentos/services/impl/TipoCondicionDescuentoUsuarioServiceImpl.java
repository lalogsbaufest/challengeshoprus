package com.shoprus.microservicios.descuentos.services.impl;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoCondicionDescuentoUsuario;
import com.shoprus.microservicios.descuentos.respositories.ITipoCondicionDescuentoUsuarioRepository;
import com.shoprus.microservicios.descuentos.services.ITipoCondicionDescuentoUsuarioService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class TipoCondicionDescuentoUsuarioServiceImpl extends GenericServiceImpl<TipoCondicionDescuentoUsuario, ITipoCondicionDescuentoUsuarioRepository> implements ITipoCondicionDescuentoUsuarioService{
    
}