package com.shoprus.microservicios.clientes.services.impl;

import com.shoprus.microservicios.clientes.models.repositories.ITipoUsuarioRepository;
import com.shoprus.microservicios.clientes.services.ITipoUsuarioService;
import com.shoprus.microservicios.commons.clientes.models.entities.TipoUsuario;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TipoUsuarioServiceImpl extends GenericServiceImpl<TipoUsuario, ITipoUsuarioRepository> implements ITipoUsuarioService{
    
}