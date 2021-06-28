package com.shoprus.microservicios.facturas.services.impl;

import java.util.List;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.commons.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Producto;
import com.shoprus.microservicios.commons.facturas.models.entities.Factura;
import com.shoprus.microservicios.facturas.clients.ClientesFeignClient;
import com.shoprus.microservicios.facturas.clients.DescuentosFeignClient;
import com.shoprus.microservicios.facturas.repositories.IFacturaRepository;
import com.shoprus.microservicios.facturas.services.IFacturasService;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturasServicesImpl extends GenericServiceImpl<Factura, IFacturaRepository> implements IFacturasService{
    
    @Autowired
    ClientesFeignClient clientesFeignClient;

    @Autowired
    DescuentosFeignClient descuentosFeignClient;  

    @Override
    public ResumenOrdenDTO validarSolicitudComprarCrearResumen(SolicitudCompraDTO solicitudCompra) {
        return descuentosFeignClient.descuentosCarrito(solicitudCompra);
    }

    @Override
    public Usuario obtenerDetallesCliente(Long idCliente) {
        return clientesFeignClient.obtenerDetallesCliente(idCliente);
    }

    @Override
    public List<Producto> obtenerYValidarProductos(List<Long> idsProducto) {
    
        return descuentosFeignClient.obtenerProductosPorId(idsProducto);
    }
}
