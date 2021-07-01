package com.shoprus.microservicios.generics.models.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericCatalog extends GenericTable {
    
    @Column(length = 250)
    protected String descripcion;

    @Column(length = 100, unique = true)
    protected String valor;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }   
}