package com.shoprus.microservicios.descuentos.respositories;

import com.shoprus.microservicios.commons.descuentos.models.entities.TipoCondicionDescuentoUsuario;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoCondicionDescuentoUsuarioRepository extends PagingAndSortingRepository<TipoCondicionDescuentoUsuario, Long>{
    
}
