package com.shoprus.microservicios.controllers.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SolicitudCompraDTO {
    
    @NotBlank(message = "Arreglo con los IDs de los productos y la cantidad a comprar")
    private List<ArticuloCarritoDTO> carrito;

    @NotBlank(message = "Identificador del cliente")
    @Size(min = 1)
    private Long idCliente;

    public List<ArticuloCarritoDTO> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<ArticuloCarritoDTO> carrito) {
        this.carrito = carrito;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
