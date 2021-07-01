package com.shoprus.microservicios.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shoprus.microservicios.generics.models.entities.GenericTable;

@Entity
@Table(name = "descuento_por_tipo_producto", schema = "descuentos",
        uniqueConstraints = @UniqueConstraint(
        columnNames={"descuento_id", "cat_tipo_producto_id"}
)
)
public class DescuentoPorTipoProducto extends GenericTable {
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_tipo_producto_id")
    private TipoProducto tipoProducto;

    public DescuentoPorTipoProducto() {
    }

    public DescuentoPorTipoProducto(Descuento descuento, TipoProducto tipoProducto) {
        this.descuento = descuento;
        this.tipoProducto = tipoProducto;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}