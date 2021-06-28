package com.shoprus.microservicios.facturas.services;

import java.util.List;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.commons.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;
import com.shoprus.microservicios.commons.facturas.models.entities.Factura;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface IFacturasService extends IGenericService<Factura> {

    public ResumenOrdenDTO validarSolicitudComprarCrearResumen(SolicitudCompraDTO solicitudCompra);

    public Usuario obtenerDetallesCliente(Long idCliente);

    public List<Producto> obtenerYValidarProductos (List<Long> idsProducto);
}
