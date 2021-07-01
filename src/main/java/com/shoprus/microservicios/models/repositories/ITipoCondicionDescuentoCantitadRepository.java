package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.TipoCondicionDescuentoCantidad;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoCondicionDescuentoCantitadRepository extends PagingAndSortingRepository<TipoCondicionDescuentoCantidad, Long>{
    
}