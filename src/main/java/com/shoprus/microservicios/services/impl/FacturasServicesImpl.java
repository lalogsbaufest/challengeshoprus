package com.shoprus.microservicios.services.impl;

import com.shoprus.microservicios.controllers.DescuentoController;
import com.shoprus.microservicios.controllers.UsuarioController;
import com.shoprus.microservicios.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.Factura;
import com.shoprus.microservicios.models.entities.Usuario;
import com.shoprus.microservicios.models.repositories.IFacturaRepository;
import com.shoprus.microservicios.services.IFacturasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturasServicesImpl extends GenericServiceImpl<Factura, IFacturaRepository> implements IFacturasService{

    @Autowired
    DescuentoController descuentosController;

    @Autowired
    UsuarioController clientesController;

    @Override
    public ResumenOrdenDTO validarSolicitudComprarCrearResumen(SolicitudCompraDTO solicitudCompra) {
        return descuentosController.descuentosCarrito(solicitudCompra).getBody();
    }

    @Override
    public Usuario obtenerDetallesCliente(Long idCliente) {
        return clientesController.detalles(idCliente).getBody();
    }
}
