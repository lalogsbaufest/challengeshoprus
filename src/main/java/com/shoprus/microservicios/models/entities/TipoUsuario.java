package com.shoprus.microservicios.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shoprus.microservicios.generics.models.entities.GenericCatalog;

@Entity
@Table(name = "catalog_tipos_usuario", schema = "clientes")
public class TipoUsuario extends GenericCatalog {

}