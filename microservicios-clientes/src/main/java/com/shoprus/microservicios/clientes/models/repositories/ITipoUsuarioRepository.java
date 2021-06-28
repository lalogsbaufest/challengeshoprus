package com.shoprus.microservicios.clientes.models.repositories;

import com.shoprus.microservicios.commons.clientes.models.entities.TipoUsuario;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoUsuarioRepository extends PagingAndSortingRepository<TipoUsuario, Long> {
    
}