package com.shoprus.microservicios.generics.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.shoprus.microservicios.commons.controllers.dtos.ErrorInfoRespDTO;
import com.shoprus.microservicios.commons.utils.IConstantes;
import com.shoprus.microservicios.commons.utils.StringUtilityTool;
import com.shoprus.microservicios.generics.services.IGenericService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GenericController<E, S extends IGenericService<E>> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected S service;

    @Autowired
    protected StringUtilityTool stringTool;

    @GetMapping
    public ResponseEntity<Iterable<E>> listar() {
        
        Iterable<E> lista = service.findAll();

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(lista));
        logger.info(responseString);

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/paging")
    public ResponseEntity<Iterable<E>> listarWithPage(@PageableDefault() Pageable pageable) {
        
        Iterable<E> lista = null;
        
        if (pageable == null) {
            lista = service.findAll();
        } else {
            lista = service.findAllWithPage(pageable).getContent();
        }

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(lista));
        logger.info(responseString);

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{idEntidad}")
    public ResponseEntity<E> detalles(@PathVariable(required = true, name = "idEntidad") Long id) {

        var requestString = String.format(IConstantes.LOG_REQUEST, stringTool.objectToString(id));
        logger.info(requestString);

        Optional<E> entity = service.findById(id);

        if (entity.isEmpty()) {
            throw new DataIntegrityViolationException("ID Usuario: No se encontró ID");
        }

        var responseString = String.format(IConstantes.LOG_RESPONSE, stringTool.objectToString(entity.get()));
        logger.info(responseString);

        return ResponseEntity.ok().body(entity.get());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    ErrorInfoRespDTO handleDataIntegrityExceptions(HttpServletRequest req, Exception ex) {
        return new ErrorInfoRespDTO(req.getRequestURL().toString(), ex);
    }
}