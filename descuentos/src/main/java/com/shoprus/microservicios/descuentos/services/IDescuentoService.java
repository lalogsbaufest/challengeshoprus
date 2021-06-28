package com.shoprus.microservicios.descuentos.services;

import java.util.List;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.commons.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Descuento;
import com.shoprus.microservicios.generics.services.IGenericService;

public interface IDescuentoService extends IGenericService<Descuento>{
       
    public Usuario obtenerDetallesCliente(Long idCliente);

    public ResumenOrdenDTO findDescuentoPorCarrito (List<ArticuloCarritoDTO> carrito, Usuario usuario);
}