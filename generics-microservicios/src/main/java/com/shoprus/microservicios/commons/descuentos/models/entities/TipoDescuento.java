package com.shoprus.microservicios.commons.descuentos.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shoprus.microservicios.generics.models.entities.GenericCatalog;

@Entity
@Table(name = "catalog_tipo_descuento", schema = "descuentos")
public class TipoDescuento extends GenericCatalog {
    
}