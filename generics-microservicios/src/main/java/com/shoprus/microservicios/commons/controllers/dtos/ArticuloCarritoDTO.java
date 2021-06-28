package com.shoprus.microservicios.commons.controllers.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;

public class ArticuloCarritoDTO {

    @NotNull
    private Long idProducto;

    @NotNull
    private Integer cantidad;

    @NotNull
    @JsonIgnore
    private Producto producto;

    public ArticuloCarritoDTO () {}

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArticuloCarritoDTO(Long idProducto, Integer cantidad, Producto producto) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}