package com.shoprus.microservicios.facturas.clients;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-clientes")
public interface ClientesFeignClient {
    
    @GetMapping("/{id}")
    public Usuario obtenerDetallesCliente(@PathVariable(name = "id") Long idCliente);
}
