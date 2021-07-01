package com.shoprus.microservicios.utils.enums;

public enum CondicionDescuentoUsuario {
    
    TODOS("todos"),
    TIPO_USUARIO("tipoUsuario"),
    ANTIGUEDAD("antiguedad");

    public final String etiqueta;

    private CondicionDescuentoUsuario(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}