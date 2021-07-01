package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.DescuentosPorFactura;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDescuentosPorFacturaRepository extends PagingAndSortingRepository<DescuentosPorFactura, Long>{
    
}
