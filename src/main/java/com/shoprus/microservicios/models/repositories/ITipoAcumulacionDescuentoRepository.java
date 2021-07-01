package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.TipoAcumulacionDescuento;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoAcumulacionDescuentoRepository extends PagingAndSortingRepository<TipoAcumulacionDescuento, Long>{
    
}