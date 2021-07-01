package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.ProductosCarrito;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductosCarritoRepository extends PagingAndSortingRepository<ProductosCarrito, Long>{
    
}
