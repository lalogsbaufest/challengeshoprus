package com.shoprus.microservicios.facturas.repositories;

import com.shoprus.microservicios.commons.facturas.models.entities.ProductosCarrito;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductosCarritoRepository extends PagingAndSortingRepository<ProductosCarrito, Long>{
    
}
