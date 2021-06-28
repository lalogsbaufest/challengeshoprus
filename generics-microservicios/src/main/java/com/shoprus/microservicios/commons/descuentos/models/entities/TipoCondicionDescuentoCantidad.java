package com.shoprus.microservicios.commons.descuentos.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shoprus.microservicios.generics.models.entities.GenericCatalog;

@Entity
@Table(name = "catalog_tipo_condicion_descuento_cantidad", schema = "descuentos")
public class TipoCondicionDescuentoCantidad extends GenericCatalog{
    
}