package com.shoprus.microservicios.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shoprus.microservicios.generics.models.entities.GenericTable;

@Entity
@Table(name = "facturas", schema = "facturas")
public class Factura extends GenericTable {
    
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "total_descuento", precision = 2)
    private Float totalDescuento;

    @Column(name = "total_sin_descuento", precision = 2)
    private Float totalSinDescuento;

    @JsonIgnoreProperties(value = {"factura", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
    private List<DescuentosPorFactura> descuentos;

    @JsonIgnoreProperties(value = {"factura", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
    private List<ProductosCarrito> productosCarrito;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(Float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public Float getTotalSinDescuento() {
        return totalSinDescuento;
    }

    public void setTotalSinDescuento(Float totalSinDescuento) {
        this.totalSinDescuento = totalSinDescuento;
    }

    public List<DescuentosPorFactura> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<DescuentosPorFactura> descuentos) {
        this.descuentos = descuentos;
    }

    public List<ProductosCarrito> getProductosCarrito() {
        return productosCarrito;
    }

    public void setProductosCarrito(List<ProductosCarrito> productosCarrito) {
        this.productosCarrito = productosCarrito;
    }
}