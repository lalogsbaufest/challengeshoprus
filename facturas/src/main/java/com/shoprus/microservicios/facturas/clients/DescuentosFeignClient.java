package com.shoprus.microservicios.facturas.clients;

import java.util.List;

import com.shoprus.microservicios.commons.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservicio-descuentos")
public interface DescuentosFeignClient {
 
    @PostMapping("/carrito")
    public ResumenOrdenDTO descuentosCarrito (@RequestBody SolicitudCompraDTO compra);

    @GetMapping
    public List<Producto> listaDescuentos();

    @PostMapping("/listaProductos")
    public List<Producto> obtenerProductosPorId (@RequestBody List<Long> idsProducto);
}