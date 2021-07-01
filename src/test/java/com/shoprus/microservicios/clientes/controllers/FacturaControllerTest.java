package com.shoprus.microservicios.clientes.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.shoprus.microservicios.clientes.AbstractClassTest;
import com.shoprus.microservicios.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.controllers.dtos.SolicitudCompraDTO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class FacturaControllerTest extends AbstractClassTest{
    
    private String uri = "/facturas";
 
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createFactura() throws Exception {

        SolicitudCompraDTO solicitud = new SolicitudCompraDTO();

		solicitud.setIdCliente(1l);

		List<ArticuloCarritoDTO> carrito = new ArrayList<>();

		carrito.add(new ArticuloCarritoDTO(1l, 2, null));
		carrito.add(new ArticuloCarritoDTO(2l, 2, null));

		solicitud.setCarrito(carrito);

       String inputJson = super.mapToJson(solicitud);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }
}