package com.shoprus.microservicios.services;

import com.shoprus.microservicios.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.Factura;
import com.shoprus.microservicios.models.entities.Usuario;

public interface IFacturasService extends IGenericService<Factura> {

    public ResumenOrdenDTO validarSolicitudComprarCrearResumen(SolicitudCompraDTO solicitudCompra);

    public Usuario obtenerDetallesCliente(Long idCliente);
}
