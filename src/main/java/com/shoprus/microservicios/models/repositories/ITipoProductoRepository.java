package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.TipoProducto;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoProductoRepository extends PagingAndSortingRepository<TipoProducto, Long>{
    
}
