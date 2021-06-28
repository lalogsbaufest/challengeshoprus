package com.shoprus.microservicios.descuentos.clients;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-clientes")
public interface ClientesFeignClient {
    
    @GetMapping("/{idEntidad}")
    public Usuario detalles(@PathVariable(name = "idEntidad") Long id);
}