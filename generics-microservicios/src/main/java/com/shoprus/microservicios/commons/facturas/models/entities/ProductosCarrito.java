package com.shoprus.microservicios.commons.facturas.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shoprus.microservicios.generics.models.entities.GenericTable;

@Entity
@Table(name = "productos_carrito", schema = "facturas",
    uniqueConstraints = @UniqueConstraint(
        columnNames={"factura_id", "producto_id"})
)
public class ProductosCarrito extends GenericTable {
 
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "producto_id")
    private Long idProducto;

    public ProductosCarrito(){}

    public ProductosCarrito(Factura factura, Long idProducto, Integer cantidad) {
        this.factura = factura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
}