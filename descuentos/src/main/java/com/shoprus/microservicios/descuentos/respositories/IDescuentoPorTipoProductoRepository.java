package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.DescuentoPorTipoProducto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IDescuentoPorTipoProductoRepository extends PagingAndSortingRepository<DescuentoPorTipoProducto, Long>{
    
    @Query("SELECT d FROM DescuentoPorTipoProducto d WHERE d.descuento.id = :idTipoDescuento")
    public Iterable<DescuentoPorTipoProducto>  findByIdTipoProducto(@Param("idTipoDescuento") Long idTipoDescuento);
}