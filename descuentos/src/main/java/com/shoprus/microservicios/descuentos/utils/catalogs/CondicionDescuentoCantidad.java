package com.shoprus.microservicios.descuentos.utils.catalogs;

public enum CondicionDescuentoCantidad {
    
    TOTAL_COMPRA("totalCompra"),
    CANTIDAD_ALCANZADA("cantidadAlcanzada");

    public final String etiqueta;

    private CondicionDescuentoCantidad(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
