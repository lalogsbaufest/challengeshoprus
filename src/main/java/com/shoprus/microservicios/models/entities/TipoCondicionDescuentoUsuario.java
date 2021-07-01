package com.shoprus.microservicios.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shoprus.microservicios.generics.models.entities.GenericCatalog;

@Entity
@Table(name = "catalog_tipo_condicion_descuento_usuario", schema = "descuentos")
public class TipoCondicionDescuentoUsuario extends GenericCatalog {
    
}