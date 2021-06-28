package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IProductoRepository extends PagingAndSortingRepository<Producto, Long> {
    
    @Query("SELECT p FROM Producto p WHERE p.tipoProducto.id = :idTipoProducto")
    public Iterable<Producto> findByIdTipoProducto(@Param("idTipoProducto") Long idTipoProducto);
}
