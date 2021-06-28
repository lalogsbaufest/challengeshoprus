package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoCondicionDescuentoCantidad;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoCondicionDescuentoCantitadRepository extends PagingAndSortingRepository<TipoCondicionDescuentoCantidad, Long>{
    
}