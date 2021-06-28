package com.shoprus.microservicios.commons.controllers.dtos;

public class ProductoDTO {
    
    private Long idProducto;

    private Integer cantidad;

    public Integer getCantidad() {
        return cantidad;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}