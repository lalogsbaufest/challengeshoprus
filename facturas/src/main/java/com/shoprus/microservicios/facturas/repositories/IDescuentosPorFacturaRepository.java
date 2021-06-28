package com.shoprus.microservicios.facturas.repositories;

import com.shoprus.microservicios.commons.facturas.models.entities.DescuentosPorFactura;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDescuentosPorFacturaRepository extends PagingAndSortingRepository<DescuentosPorFactura, Long>{
    
}
