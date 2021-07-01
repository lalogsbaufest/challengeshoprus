package com.shoprus.microservicios.services;

import java.util.List;

import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.generics.services.IGenericService;
import com.shoprus.microservicios.models.entities.Descuento;
import com.shoprus.microservicios.models.entities.Usuario;

public interface IDescuentoService extends IGenericService<Descuento>{

    public ResumenOrdenDTO findDescuentoPorCarrito (List<ArticuloCarritoDTO> carrito, Usuario usuario);
}