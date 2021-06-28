package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoDescuento;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoDescuentoRepository extends PagingAndSortingRepository <TipoDescuento, Long>{
    
}
