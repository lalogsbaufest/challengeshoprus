package com.shoprus.microservicios.clientes.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import com.shoprus.microservicios.clientes.controllers.dtos.UsuarioDTO;
import com.shoprus.microservicios.commons.clientes.models.entities.Usuario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioControllerTest {

    @Autowired
    UsuarioController usuarioController;

    @Test
    void testCrear() {

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNombre("Juan");

        usuario.setApellidoPaterno("Perez");

        usuario.setApellidoMaterno("García");

        usuario.setEmail("jua1n@gmail.com");

        /*
            Tipos de usuario
            1.- Afiliado
            2.- Empleado
        */
        usuario.setIdTipoUsuario(2l);

        ResponseEntity<Usuario> usuarioBD = usuarioController.crear(usuario);

        

        assertThat(
			usuarioBD
		).isNotNull();
    }

    @Test
    void testFiltrar() {

        ResponseEntity<Iterable<Usuario>> listaUsuarios = usuarioController.filtrar("Juan", PageRequest.of(0, 2));

        assertThat(
			listaUsuarios
		).isNotNull();        
    }

    @Test
    void testListar() {

        ResponseEntity<Iterable<Usuario>> listaUsuario = usuarioController.listar();

        assertThat(
			listaUsuario
		).isNotNull();        
    }
}
