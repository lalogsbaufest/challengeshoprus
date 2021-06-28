package com.shoprus.microservicios.descuentos.utils.catalogs;

public enum CondicionDescuentoUsuario {
    
    TODOS("todos"),
    TIPO_USUARIO("tipoUsuario"),
    ANTIGUEDAD("antiguedad");

    public final String etiqueta;

    private CondicionDescuentoUsuario(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}