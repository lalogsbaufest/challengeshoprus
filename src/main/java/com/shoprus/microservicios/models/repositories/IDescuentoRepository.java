package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.Descuento;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDescuentoRepository extends PagingAndSortingRepository<Descuento, Long>{
}