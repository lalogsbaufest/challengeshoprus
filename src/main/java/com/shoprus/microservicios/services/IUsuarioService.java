package com.shoprus.microservicios.services;

import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService extends IGenericService<Usuario> {

    public Page<Usuario> findByNombreCompleto(String valor, Pageable pageable);
}