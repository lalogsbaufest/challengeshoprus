package com.shoprus.microservicios.commons.descuentos.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shoprus.microservicios.generics.models.entities.GenericTable;

@Entity
@Table(name = "descuentos", schema = "descuentos")
public class Descuento extends GenericTable {
    
    @Column(name = "valor_condicion")
    private String valorCondicion;

    @Column(name = "valor_descuento")
    private String valorDescuento;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_tipo_descuento_id")
    private TipoDescuento tipoDescuento;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_tipo_condicion_descuento_usuario_id")
    private TipoCondicionDescuentoUsuario tipoCondicionDescuentoUsuario;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_tipo_condicion_descuento_cantidad_id")
    private TipoCondicionDescuentoCantidad tipoCondicionDescuentoCantidad;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_tipo_acumulacion_descuento_id")
    private TipoAcumulacionDescuento tipoAcumulacionDescuento;

    @JsonIgnoreProperties(value = {"descuento", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "descuento")
    private List<DescuentoPorTipoProducto> descuentosPorProducto;

    public String getValorCondicion() {
        return valorCondicion;
    }

    public void setValorCondicion(String valorCondicion) {
        this.valorCondicion = valorCondicion;
    }

    public String getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(String valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public TipoDescuento getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(TipoDescuento tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public TipoAcumulacionDescuento getTipoAcumulacionDescuento() {
        return tipoAcumulacionDescuento;
    }

    public void setTipoAcumulacionDescuento(TipoAcumulacionDescuento tipoAcumulacionDescuento) {
        this.tipoAcumulacionDescuento = tipoAcumulacionDescuento;
    }

    public List<DescuentoPorTipoProducto> getDescuentosPorProducto() {
        return descuentosPorProducto;
    }

    public void setDescuentosPorProducto(List<DescuentoPorTipoProducto> descuentosPorProducto) {
        this.descuentosPorProducto = descuentosPorProducto;
    }

    public TipoCondicionDescuentoCantidad getTipoCondicionDescuentoCantidad() {
        return tipoCondicionDescuentoCantidad;
    }

    public void setTipoCondicionDescuentoCantidad(TipoCondicionDescuentoCantidad tipoCondicionDescuentoCantidad) {
        this.tipoCondicionDescuentoCantidad = tipoCondicionDescuentoCantidad;
    }

    public TipoCondicionDescuentoUsuario getTipoCondicionDescuentoUsuario() {
        return tipoCondicionDescuentoUsuario;
    }

    public void setTipoCondicionDescuentoUsuario(TipoCondicionDescuentoUsuario tipoCondicionDescuentoUsuario) {
        this.tipoCondicionDescuentoUsuario = tipoCondicionDescuentoUsuario;
    }   
}