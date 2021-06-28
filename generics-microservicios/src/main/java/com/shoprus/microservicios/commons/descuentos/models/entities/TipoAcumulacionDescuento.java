package com.shoprus.microservicios.commons.descuentos.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shoprus.microservicios.generics.models.entities.GenericCatalog;

@Entity
@Table(name = "catalog_tipo_acumulacion_descuento", schema = "descuentos")
public class TipoAcumulacionDescuento extends GenericCatalog {
    
}