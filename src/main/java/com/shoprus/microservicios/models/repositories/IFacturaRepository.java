package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.Factura;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFacturaRepository extends PagingAndSortingRepository<Factura, Long>{
    
}