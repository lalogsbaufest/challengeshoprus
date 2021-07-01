package com.shoprus.microservicios.models.repositories;

import com.shoprus.microservicios.models.entities.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
 
    @Query(
        value = "SELECT * FROM clientes.usuarios u WHERE u.nombre ILIKE %:valor% OR u.apellido_paterno ILIKE %:valor% OR u.apellido_materno ILIKE %:valor%", 
        countQuery = "SELECT count(*) FROM clientes.usuarios u WHERE u.nombre ILIKE %:valor% OR u.apellido_paterno ILIKE %:valor% OR u.apellido_materno ILIKE %:valor%",
    nativeQuery = true)
    public Page<Usuario> findByNombreAndApellidoPaternoAndApellidoMaternoContains(
        @Param("valor") String valor, Pageable pageable
    );
}