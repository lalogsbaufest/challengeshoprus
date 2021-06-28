package com.shoprus.microservicios.clientes.services;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.generics.services.IGenericService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService extends IGenericService<Usuario> {

    public Page<Usuario> findByNombreCompleto(String valor, Pageable pageable);
}