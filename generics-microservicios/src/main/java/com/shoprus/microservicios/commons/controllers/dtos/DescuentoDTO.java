package com.shoprus.microservicios.commons.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

public class DescuentoDTO {

    private String valorCondicion;

    private String valorDescuento;

    private Long tipoDescuentoId;

    private Long tipoCondicionDescuentoUsuarioId;

    private Long tipoCondicionDescuentoCantidadId;

    private Long tipoAcumulacionDescuentoId;

    private List<Long> idsProductosQueAplica;

    public DescuentoDTO () {
        setIdsProductosQueAplica(new ArrayList<>());
    }

    public List<Long> getIdsProductosQueAplica() {
        return idsProductosQueAplica;
    }

    public void setIdsProductosQueAplica(List<Long> idsProductosQueAplica) {
        this.idsProductosQueAplica = idsProductosQueAplica;
    }

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

    public Long getTipoDescuentoId() {
        return tipoDescuentoId;
    }

    public void setTipoDescuentoId(Long tipoDescuentoId) {
        this.tipoDescuentoId = tipoDescuentoId;
    }

    public Long getTipoCondicionDescuentoUsuarioId() {
        return tipoCondicionDescuentoUsuarioId;
    }

    public void setTipoCondicionDescuentoUsuarioId(Long tipoCondicionDescuentoUsuarioId) {
        this.tipoCondicionDescuentoUsuarioId = tipoCondicionDescuentoUsuarioId;
    }

    public Long getTipoCondicionDescuentoCantidadId() {
        return tipoCondicionDescuentoCantidadId;
    }

    public void setTipoCondicionDescuentoCantidadId(Long tipoCondicionDescuentoCantidadId) {
        this.tipoCondicionDescuentoCantidadId = tipoCondicionDescuentoCantidadId;
    }

    public Long getTipoAcumulacionDescuentoId() {
        return tipoAcumulacionDescuentoId;
    }

    public void setTipoAcumulacionDescuentoId(Long tipoAcumulacionDescuentoId) {
        this.tipoAcumulacionDescuentoId = tipoAcumulacionDescuentoId;
    }
}
