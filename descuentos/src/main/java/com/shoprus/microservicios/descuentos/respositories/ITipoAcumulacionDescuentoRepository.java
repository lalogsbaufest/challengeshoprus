package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoAcumulacionDescuento;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoAcumulacionDescuentoRepository extends PagingAndSortingRepository<TipoAcumulacionDescuento, Long>{
    
}