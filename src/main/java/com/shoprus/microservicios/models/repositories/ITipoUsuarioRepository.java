package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.TipoUsuario;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoUsuarioRepository extends PagingAndSortingRepository<TipoUsuario, Long> {
    
}