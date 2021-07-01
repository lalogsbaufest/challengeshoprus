package com.shoprus.microservicios.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DescuentoDTO {

    @NotBlank(message = "Valor de la condición (ID Tipo Usuario, Meses de antigüedad, etc)")
    private String valorCondicion;

    @NotBlank(message = "Valor de descuento (Porcentual o de cantidad)")
    private String valorDescuento;

    @NotBlank(message = "ID Tipo Descuento (1 Neto - 2 Porcentual)")
    @Size(min = 1)
    private Long tipoDescuentoId;

    @NotBlank(message = "ID Tipo (1 Por antigüedad - 2 Por Tipo Usuario - 3 Todos los usuarios)")
    @Size(min = 1)
    private Long tipoCondicionDescuentoUsuarioId;

    @NotBlank(message = "ID Tipo Condición Descuento (1 Total de Comprar - 2 Cantidad Alcanzada)")
    @Size(min = 1)
    private Long tipoCondicionDescuentoCantidadId;

    @NotBlank(message = "ID Tipo Acumulación (1 Se acumula con otros descuentos - 2 No aplica otros descuentos)")
    @Size(min = 1)
    private Long tipoAcumulacionDescuentoId;

    @NotBlank(message = "Arreglo con los IDs de los productos y la cantidad a comprar")
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
