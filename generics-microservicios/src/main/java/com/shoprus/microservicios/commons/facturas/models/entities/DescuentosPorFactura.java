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
@Table(name = "descuentos_por_factura", schema = "facturas",
        uniqueConstraints = @UniqueConstraint(
            columnNames={"factura_id", "descuento_id"})
)
public class DescuentosPorFactura extends GenericTable {
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Column(name = "descuento_id")
    private Long idDescuento;

    public DescuentosPorFactura() {
    }

    public DescuentosPorFactura(Factura factura, Long idDescuento) {
        this.factura = factura;
        this.idDescuento = idDescuento;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Long idDescuento) {
        this.idDescuento = idDescuento;
    }
}