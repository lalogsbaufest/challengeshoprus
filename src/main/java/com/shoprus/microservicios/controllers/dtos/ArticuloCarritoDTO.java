package com.shoprus.microservicios.controllers.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoprus.microservicios.models.entities.Producto;

public class ArticuloCarritoDTO {

    @NotBlank(message = "ID del Producto")
    @Size(min = 1)
    private Long idProducto;

    @NotBlank(message = "Cantidad a comprar del producto")
    @Size(min = 1)
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