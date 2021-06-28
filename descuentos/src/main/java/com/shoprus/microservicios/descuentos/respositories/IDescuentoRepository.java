package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.Descuento;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDescuentoRepository extends PagingAndSortingRepository<Descuento, Long>{
}