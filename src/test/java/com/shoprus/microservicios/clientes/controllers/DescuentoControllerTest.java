package com.shoprus.microservicios.clientes.controllers;

import static org.junit.Assert.assertEquals;

import com.shoprus.microservicios.clientes.AbstractClassTest;
import com.shoprus.microservicios.controllers.dtos.DescuentoDTO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;

public class DescuentoControllerTest extends AbstractClassTest{

    private String uri = "/descuentos";
 
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createDescuento() throws Exception {

       		//Descuento que reducirá 10 dolares por cada 500 alcanzados
		DescuentoDTO descuentoDTO = new DescuentoDTO();
		descuentoDTO.setValorCondicion("500");
		descuentoDTO.setValorDescuento("10");
		
		/*
			Para los productos electronicos
			1.- Electronicos
			2.- Comestibles
			3.- Limpieza
		*/
		Long idTipoProductoElectronicos = 1l;
		descuentoDTO.setIdsProductosQueAplica(
			new ArrayList<>( Arrays.asList(
				new Long[] {idTipoProductoElectronicos}
				)
			)
		);

		/*
			Sera un descuento Acumulable con otros
			1.- Acumulable
			2.- Único
		*/
		descuentoDTO.setTipoAcumulacionDescuentoId(1l);

		/*
			Sera un descuento por cada vez que se alcance 500 dolares
			1.- Total de la compra
			2.- Cantidad alcanzada (Ejemplo cada 100 dolares)
		*/
		descuentoDTO.setTipoCondicionDescuentoCantidadId(2l);

		/*
			Tipo de usuario
			1.- Afiliado
			2.- Empleado
			3.- Todos
		*/
		descuentoDTO.setTipoCondicionDescuentoUsuarioId(2l);

		/*
			Tipo de usuario
			1.- Valor Condición será Neta
			2.- Valor Condición será Porcentual
		*/
		descuentoDTO.setTipoDescuentoId(2l);

       String inputJson = super.mapToJson(descuentoDTO);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }


    @Test
    public void testObtenerDescuentoPorProductoCliente() throws Exception {

        String idProducto = "1";
        String idCliente = "1";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/producto/" + idProducto)
                        .param("idCliente", idCliente))
                        .andExpect(status().isOk())
                            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                            .andExpect(jsonPath("$.totalDescuento").value("2250.0"))
                            .andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }

    @Test
    public void testObtenerDescuentoPorID() throws Exception {

        String idDescuento = "1";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/" + idDescuento)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                            .andExpect(jsonPath("$.estatus").value("true"))
                            .andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }

    @Test
    public void testListar() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
            .get(uri)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(greaterThan(0))))
            .andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);    
    }
}