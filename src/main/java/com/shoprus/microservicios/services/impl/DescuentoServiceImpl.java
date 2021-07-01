package com.shoprus.microservicios.services.impl;

import java.util.List;

import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;
import com.shoprus.microservicios.models.entities.Descuento;
import com.shoprus.microservicios.models.entities.Usuario;
import com.shoprus.microservicios.models.repositories.IDescuentoRepository;
import com.shoprus.microservicios.services.IDescuentoService;
import com.shoprus.microservicios.services.logic.DescuentoLogic;
import com.shoprus.microservicios.services.logic.UsuarioLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescuentoServiceImpl extends GenericServiceImpl<Descuento, IDescuentoRepository> implements IDescuentoService {

    @Autowired
    UsuarioLogic clienteLogic;

    @Autowired
    DescuentoLogic descuentosLogic;

    public ResumenOrdenDTO findDescuentoPorCarrito (List<ArticuloCarritoDTO> carrito, Usuario usuario) {

        var resumen = new ResumenOrdenDTO();

        List<Descuento> descuentos = (List<Descuento>)repository.findAll();

        descuentos = descuentosLogic.filtarDescuentosAplicablesPorUsuario(usuario, descuentos);

        descuentos = descuentosLogic.filtarDescuentosNoAcumulables(descuentos);

        resumen.setTotalSinDescuento(descuentosLogic.calcularTotalSinDescuentos(carrito));

        resumen.setTotalDescuento(descuentosLogic.calcularDescuentosPorcentualesSobreTotalCompra(carrito, descuentos));

        resumen.setTotalDescuento(resumen.getTotalDescuento() + descuentosLogic.calcularDescuentosSobreCantidadAlcanzada(resumen, descuentos));

        resumen.setTotalConDescuento(resumen.getTotalSinDescuento() - resumen.getTotalDescuento());

        resumen.setDescuentoAplicados(descuentos);

        return resumen;
    }
}