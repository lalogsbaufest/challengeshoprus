package com.shoprus.microservicios.descuentos.utils.catalogs;

public enum CondicionDescuentoAcumulacion {
 
    ACUMULABLE("acumulable"),
    UNICO("unico");

    public final String etiqueta;

    private CondicionDescuentoAcumulacion(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}