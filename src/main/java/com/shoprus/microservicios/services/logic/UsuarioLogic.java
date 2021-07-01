package com.shoprus.microservicios.services.logic;

import com.shoprus.microservicios.models.entities.Usuario;
import com.shoprus.microservicios.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLogic {

    @Autowired
    IUsuarioService usuarioService;
    
    public Usuario obtenerYValidarUsuario (Long idCliente) {
        var usuario = usuarioService.findById(idCliente);

        if (usuario.isEmpty()) {
            throw new DataIntegrityViolationException("El ID del cliente no existe");
        } else {
            return usuario.get();
        }
    }
}
