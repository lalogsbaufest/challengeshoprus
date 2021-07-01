package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.TipoDescuento;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoDescuentoRepository extends PagingAndSortingRepository <TipoDescuento, Long>{
    
}
