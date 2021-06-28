package com.shoprus.microservicios.commons.descuentos.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shoprus.microservicios.generics.models.entities.GenericCatalog;

@Entity
@Table(name = "catalog_tipo_producto", schema = "descuentos")
public class TipoProducto extends GenericCatalog {
    
    @JsonIgnoreProperties(value = {"tipoProducto", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoProducto")
    private List<Producto> productos;
}