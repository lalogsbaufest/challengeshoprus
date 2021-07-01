package com.shoprus.microservicios.services.impl;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.TipoCondicionDescuentoUsuario;
import com.shoprus.microservicios.models.repositories.ITipoCondicionDescuentoUsuarioRepository;
import com.shoprus.microservicios.services.ITipoCondicionDescuentoUsuarioService;

import org.springframework.stereotype.Service;

@Service
public class TipoCondicionDescuentoUsuarioServiceImpl extends GenericServiceImpl<TipoCondicionDescuentoUsuario, ITipoCondicionDescuentoUsuarioRepository> implements ITipoCondicionDescuentoUsuarioService{
    
}