package com.shoprus.microservicios.controllers.dtos;

import java.util.List;

import com.shoprus.microservicios.models.entities.Descuento;

public class ResumenOrdenDTO {
    private Float totalSinDescuento;

    private Float totalDescuento;

    private Float totalConDescuento;

    private Float porcentajeDescuento;

    private List<Descuento> descuentoAplicados;

    public Float getTotalSinDescuento() {
        return totalSinDescuento;
    }

    public Float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(Float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public void setTotalSinDescuento(Float totalSinDescuento) {
        this.totalSinDescuento = totalSinDescuento;
    }

    public Float getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(Float totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    public Float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public List<Descuento> getDescuentoAplicados() {
        return descuentoAplicados;
    }

    public void setDescuentoAplicados(List<Descuento> descuentoAplicados) {
        this.descuentoAplicados = descuentoAplicados;
    }
}