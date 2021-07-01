package com.shoprus.microservicios.clientes.controllers;

import static org.junit.Assert.assertEquals;

import com.shoprus.microservicios.clientes.AbstractClassTest;
import com.shoprus.microservicios.controllers.dtos.UsuarioDTO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


public class UsuarioControllerTest extends AbstractClassTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createProduct() throws Exception {
       String uri = "/clientes";

       UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNombre("Juan");

        usuario.setApellidoPaterno("Perez");

        usuario.setApellidoMaterno("García");

        usuario.setEmail("juan" + Math.floor(Math.random() * (1000 - 100 + 1) + 100) + "@gmail.com");

        /* Tipos de usuario
            1.- Afiliado
            2.- Empleado
        */
        usuario.setIdTipoUsuario(2l);

       String inputJson = super.mapToJson(usuario);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(201, status);
    }


    @Test
    public void testFiltrar() throws Exception {

        String uri = "/clientes/filter";

        String terminoBusqueda = "Juan";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                        .param("valor", terminoBusqueda))
                        .andExpect(status().isOk())
                            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                            .andExpect(jsonPath("$[0].nombre").value("Juan"))
                            .andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }

    @Test
    public void testListar() throws Exception {

        String uri = "/clientes";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
            .get(uri)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[2].nombre", is("Juan"))).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);    
    }
}
