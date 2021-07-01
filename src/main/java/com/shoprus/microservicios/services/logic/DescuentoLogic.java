package com.shoprus.microservicios.services.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.controllers.dtos.ResumenOrdenDTO;
import com.shoprus.microservicios.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.models.entities.Descuento;
import com.shoprus.microservicios.models.entities.DescuentoPorTipoProducto;
import com.shoprus.microservicios.models.entities.Producto;
import com.shoprus.microservicios.models.entities.TipoProducto;
import com.shoprus.microservicios.models.entities.Usuario;
import com.shoprus.microservicios.services.IDescuentoPorTipoProductoService;
import com.shoprus.microservicios.services.IDescuentoService;
import com.shoprus.microservicios.utils.enums.CondicionDescuentoAcumulacion;
import com.shoprus.microservicios.utils.enums.CondicionDescuentoCantidad;
import com.shoprus.microservicios.utils.enums.CondicionDescuentoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DescuentoLogic {

    @Autowired
    UsuarioLogic usuarioLogic;

    @Autowired
    ProductoLogic productoLogic;

    @Autowired
    IDescuentoPorTipoProductoService descuentoPorTipoProductoService;

    @Autowired
    IDescuentoService descuentoService;

    public ResumenOrdenDTO aplicarDescuentoSobreSolicitudCompra (SolicitudCompraDTO compra) {
        var usuario = usuarioLogic.obtenerYValidarUsuario(compra.getIdCliente());

        List<Long> idsProducto = productoLogic.extraerListaIdsProductos(compra.getCarrito());

        List<Producto> listaEntidadesProducto = productoLogic.traerYValidarProductosExistentes(idsProducto); 

        compra.setCarrito(productoLogic.llenarCarritoConEntidadesProducto(compra.getCarrito(), listaEntidadesProducto));

        return descuentoService.findDescuentoPorCarrito(compra.getCarrito(), usuario);
    }
    
    public List<Descuento> filtarDescuentosNoAcumulables (List<Descuento> descuentos) {

        List<Descuento> descuentosAcumulables = descuentos.stream().filter(
            descuento -> descuento.getTipoAcumulacionDescuento().getValor().equals(CondicionDescuentoAcumulacion.ACUMULABLE.etiqueta)
        ).collect(Collectors.toList());

        Descuento descuentoMayor = null;
        
        for (Descuento descuento : descuentos) {
            if (descuento.getTipoAcumulacionDescuento().getValor().equals(CondicionDescuentoAcumulacion.UNICO.etiqueta)) {
                if (descuentoMayor == null) {
                    descuentoMayor = descuento;
                } else {

                    Long descuentoMayorNumeric = Long.parseLong(descuentoMayor.getValorDescuento());

                    Long descuentoIteracionNumeric = Long.parseLong(descuento.getValorDescuento());

                    if (descuentoIteracionNumeric > descuentoMayorNumeric) {
                        descuentoMayor = descuento;
                    }
                }
            }
        }

        List<Descuento> descuentosAcumulablesYUnicoConMayorDescuento = descuentosAcumulables;
        if (descuentoMayor != null)  {descuentosAcumulablesYUnicoConMayorDescuento.add(descuentoMayor);}

        return descuentosAcumulablesYUnicoConMayorDescuento;
    }

    /**
     * 
     * @param usuario En caso de ser nulo solo se aplicarán descuentos con criterio CondicionDescuentoUsuario.TODOS
     * @param descuentos
     * @return
     */
    public List<Descuento> filtarDescuentosAplicablesPorUsuario (Usuario usuario, List<Descuento> descuentos) {

        Long mesEnMilisegundos = 2629800000l;

        return descuentos.stream().filter(descuento -> {
            
            if (descuento.getTipoCondicionDescuentoUsuario().getValor().equals(CondicionDescuentoUsuario.TODOS.etiqueta)) {

                return true;

            } else if (usuario != null && descuento.getTipoCondicionDescuentoUsuario().getValor().equals(CondicionDescuentoUsuario.ANTIGUEDAD.etiqueta)) {

                Long mesesDeAntiguedadParaAplicarDescuento = Long.parseLong(descuento.getValorCondicion());
                Long mesesDeAntiguedadParaAplicarDescuentoEnMilisegundos = mesesDeAntiguedadParaAplicarDescuento * mesEnMilisegundos;

                Date mesesDeAntiguedadParaAplicarDescuentoEnDate = new Date(new Date().getTime() - mesesDeAntiguedadParaAplicarDescuentoEnMilisegundos);

                return usuario.getFecCrea().getTime() < mesesDeAntiguedadParaAplicarDescuentoEnDate.getTime();

            } else if (usuario != null && descuento.getTipoCondicionDescuentoUsuario().getValor().equals(CondicionDescuentoUsuario.TIPO_USUARIO.etiqueta)) {
                return usuario.getTipoUsuario().getValor().equals(descuento.getValorCondicion());
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }

    public Float calcularTotalSinDescuentos (List<ArticuloCarritoDTO> carrito) {
        Float totalSinDescuentos = 0f;

        for (ArticuloCarritoDTO articuloCarrito : carrito) {
            totalSinDescuentos = totalSinDescuentos + (articuloCarrito.getCantidad() * articuloCarrito.getProducto().getPrecio());   
        }

        return totalSinDescuentos;
    }

    public Float calcularDescuentosPorcentualesSobreTotalCompra (List<ArticuloCarritoDTO> carrito, List<Descuento> descuentos) {

        Float sumatoriaDescuentos = 0f;
        
        for (Descuento descuento : descuentos) {

            sumatoriaDescuentos = calcularDescuentoPorcentualPorDescuento(carrito, descuento);
        }

        return sumatoriaDescuentos;
    } 

    private Float calcularDescuentoPorcentualPorDescuento (List<ArticuloCarritoDTO> carrito, Descuento descuento) {

        var sumatoriaDescuento = 0f;
        if (descuento.getTipoCondicionDescuentoCantidad().getValor().equals(CondicionDescuentoCantidad.TOTAL_COMPRA.etiqueta)) {

            //Si lista DescuentosPorProducto es NULA o VACIA, aplica a TODOS los Productos
            if (descuento.getDescuentosPorProducto() == null || descuento.getDescuentosPorProducto().isEmpty()) {
                for (ArticuloCarritoDTO articulo : carrito) {
                    sumatoriaDescuento += (articulo.getProducto().getPrecio() * articulo.getCantidad()) * (Float.parseFloat(descuento.getValorDescuento()) / 100);
                }
            } else {
                List<Long> idsTipoProducoAplicablesParaDescuento = listaIdsTipoProducoAplicablesParaDescuento(descuento.getDescuentosPorProducto());

                for (ArticuloCarritoDTO articulo : carrito) {
                    if (idsTipoProducoAplicablesParaDescuento.contains(articulo.getProducto().getTipoProducto().getId())) {

                        sumatoriaDescuento += (articulo.getProducto().getPrecio() * articulo.getCantidad()) * (Float.parseFloat(descuento.getValorDescuento()) / 100);
                    }
                }
            }
        }

        return sumatoriaDescuento;
    }

    private List<Long> listaIdsTipoProducoAplicablesParaDescuento(List<DescuentoPorTipoProducto> descuentosPorProducto) {
        List<Long> idsTipoProducoAplicablesParaDescuento = new ArrayList<>();
        descuentosPorProducto.forEach(descuentoPorProducto -> {
            idsTipoProducoAplicablesParaDescuento.add(descuentoPorProducto.getTipoProducto().getId());
        });

        return idsTipoProducoAplicablesParaDescuento;
    }

    public Float calcularDescuentosSobreCantidadAlcanzada (ResumenOrdenDTO resumen, List<Descuento> descuentos) {
        Float sumatoriaDescuento = 0f;

        for (Descuento descuento : descuentos) {
            if (descuento.getTipoCondicionDescuentoCantidad().getValor().equals(CondicionDescuentoCantidad.CANTIDAD_ALCANZADA.etiqueta)) {

                Float totalCuenta = resumen.getTotalSinDescuento();

                Float descuentoPorCantidadAlcanzada = Float.parseFloat(descuento.getValorCondicion());

                Integer vecesDeCantidadAlcanzada = (int) (totalCuenta / descuentoPorCantidadAlcanzada);

                sumatoriaDescuento += vecesDeCantidadAlcanzada * Float.parseFloat(descuento.getValorDescuento());
            }
        }

        return sumatoriaDescuento;
    }

    public List<DescuentoPorTipoProducto> guardarDescuentosPorTipoProducto (Descuento descuentoDB, List<TipoProducto> tiposProductos) {

        List<DescuentoPorTipoProducto> descuentosPorTipoProductos = new ArrayList<>();

        tiposProductos.forEach(tipoProducto -> descuentosPorTipoProductos.add(new DescuentoPorTipoProducto(descuentoDB, tipoProducto)));

        return descuentoPorTipoProductoService.saveAlls(descuentosPorTipoProductos);
    }
}