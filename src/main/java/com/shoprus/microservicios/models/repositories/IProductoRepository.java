package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IProductoRepository extends PagingAndSortingRepository<Producto, Long> {
    
    @Query("SELECT p FROM Producto p WHERE p.tipoProducto.id = :idTipoProducto")
    public Iterable<Producto> findByIdTipoProducto(@Param("idTipoProducto") Long idTipoProducto);
}
