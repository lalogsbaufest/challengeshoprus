package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.TipoCondicionDescuentoUsuario;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoCondicionDescuentoUsuarioRepository extends PagingAndSortingRepository<TipoCondicionDescuentoUsuario, Long>{
    
}
