package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoProducto;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoProductoRepository extends PagingAndSortingRepository<TipoProducto, Long>{
    
}
