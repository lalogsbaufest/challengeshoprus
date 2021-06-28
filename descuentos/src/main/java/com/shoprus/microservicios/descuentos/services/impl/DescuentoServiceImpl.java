package com.shoprus.microservicios.descuentos.services.impl;

import java.util.List;

import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;
import com.shoprus.microservicios.commons.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.commons.descuentos.models.entities.Descuento;
import com.shoprus.microservicios.descuentos.clients.ClientesFeignClient;
import com.shoprus.microservicios.descuentos.respositories.IDescuentoRepository;
import com.shoprus.microservicios.descuentos.services.IDescuentoService;
import com.shoprus.microservicios.descuentos.services.impl.logic.DescuentoLogic;
import com.shoprus.microservicios.generics.services.impl.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescuentoServiceImpl extends GenericServiceImpl<Descuento, IDescuentoRepository> implements IDescuentoService {

    @Autowired
    ClientesFeignClient clienteClient;

    @Autowired
    DescuentoLogic logicaDescuentos;

    public ResumenOrdenDTO findDescuentoPorCarrito (List<ArticuloCarritoDTO> carrito, Usuario usuario) {

        var resumen = new ResumenOrdenDTO();

        List<Descuento> descuentos = (List<Descuento>)repository.findAll();

        descuentos = logicaDescuentos.filtarDescuentosAplicablesPorUsuario(usuario, descuentos);

        descuentos = logicaDescuentos.filtarDescuentosNoAcumulables(descuentos);

        resumen.setTotalSinDescuento(logicaDescuentos.calcularTotalSinDescuentos(carrito));

        resumen.setTotalDescuento(logicaDescuentos.calcularDescuentosPorcentualesSobreTotalCompra(carrito, descuentos));

        resumen.setTotalDescuento(resumen.getTotalDescuento() + logicaDescuentos.calcularDescuentosSobreCantidadAlcanzada(resumen, descuentos));

        resumen.setTotalConDescuento(resumen.getTotalSinDescuento() - resumen.getTotalDescuento());

        resumen.setDescuentoAplicados(descuentos);

        return resumen;
    }

    @Override
    public Usuario obtenerDetallesCliente(Long idCliente) {
        return clienteClient.detalles(idCliente);
    }
}