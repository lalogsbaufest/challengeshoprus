package com.shoprus.microservicios.clientes.services.impl;

import com.shoprus.microservicios.clientes.models.repositories.IUsuarioRepository;
import com.shoprus.microservicios.clientes.services.IUsuarioService;
import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, IUsuarioRepository> implements IUsuarioService {

    @Override
    public Page<Usuario> findByNombreCompleto(String valor, Pageable pageable) {
        return repository.findByNombreAndApellidoPaternoAndApellidoMaternoContains(valor, pageable);
    }   
}