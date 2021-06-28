package com.shoprus.microservicios.facturas.repositories;

import com.shoprus.microservicios.commons.facturas.models.entities.Factura;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFacturaRepository extends PagingAndSortingRepository<Factura, Long>{
    
}