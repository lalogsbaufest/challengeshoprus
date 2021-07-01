package com.shoprus.microservicios.controllers;

import java.util.Optional;

import com.shoprus.microservicios.controllers.dtos.UsuarioDTO;
import com.shoprus.microservicios.generics.controllers.GenericController;
import com.shoprus.microservicios.models.entities.TipoUsuario;
import com.shoprus.microservicios.models.entities.Usuario;
import com.shoprus.microservicios.services.ITipoUsuarioService;
import com.shoprus.microservicios.services.impl.UsuarioServiceImpl;
import com.shoprus.microservicios.utils.IConstantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/clientes")
public class UsuarioController extends GenericController<Usuario, UsuarioServiceImpl>{

    @Autowired
    ITipoUsuarioService serviceTipoUsuario;

    @Override
    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> listar() {
        
        return super.listar();
    }

    @Override
    @Operation(summary = "Busca un cliente por ID")
    @GetMapping("/{idEntidad}")
    public ResponseEntity<Usuario> detalles(@PathVariable(required = true, name = "idEntidad") Long id) {

        return super.detalles(id);
    }

    @Operation(summary = "Registrar un Cliente")
    @PostMapping
    public ResponseEntity<Usuario> crear (@RequestBody UsuarioDTO usuario) {

        var requestPrint = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(usuario));
        logger.info(requestPrint);

        Optional<TipoUsuario> tipoUsuario = serviceTipoUsuario.findById(usuario.getIdTipoUsuario());

        if (tipoUsuario.isEmpty()) {

            throw new DataIntegrityViolationException("ID Tipo Usuario: No se encontró ID");
        }

        try {

            var usuarioDB = service.save(
                new Usuario(usuario.getNombre(), usuario.getApellidoPaterno(), usuario.getApellidoMaterno(), usuario.getEmail(), tipoUsuario.get())
            );

            var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(usuarioDB));
            logger.info(responseString);
        
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDB);
        
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("El email ya ha sido registrado");
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<Iterable<Usuario>> filtrar (@RequestParam(name = "valor", required = false) String valor, Pageable pageable) {

        var requestPrint = String.format(IConstantes.LOG_REQUEST, valor);
        logger.info(requestPrint);

        try {
            Iterable<Usuario> lista = service.findByNombreCompleto(valor, pageable).getContent();
            
            var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(lista));
            logger.info(responseString);

            return ResponseEntity.ok(lista);
        } catch (InvalidDataAccessResourceUsageException e) {
            throw new InvalidDataAccessResourceUsageException("Ingrese un criterio de ordenamiento valido o retirelo");
        }
    }
}