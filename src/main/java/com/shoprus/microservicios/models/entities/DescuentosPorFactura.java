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
@Table(name = "descuentos_por_factura", schema = "facturas",
        uniqueConstraints = @UniqueConstraint(
            columnNames={"factura_id", "descuento_id"})
)
public class DescuentosPorFactura extends GenericTable {
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    public DescuentosPorFactura() {    }

    public DescuentosPorFactura(Factura factura, Descuento descuento) {
        this.factura = factura;
        this.descuento = descuento;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}