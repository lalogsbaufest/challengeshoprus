package com.shoprus.microservicios.commons.controllers.dtos;

import java.util.List;

public class SolicitudCompraDTO {
    
    private List<ArticuloCarritoDTO> carrito;

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
