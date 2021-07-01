package com.shoprus.microservicios.services.impl;

import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.TipoUsuario;
import com.shoprus.microservicios.models.repositories.ITipoUsuarioRepository;
import com.shoprus.microservicios.services.ITipoUsuarioService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TipoUsuarioServiceImpl extends GenericServiceImpl<TipoUsuario, ITipoUsuarioRepository> implements ITipoUsuarioService{
    
}