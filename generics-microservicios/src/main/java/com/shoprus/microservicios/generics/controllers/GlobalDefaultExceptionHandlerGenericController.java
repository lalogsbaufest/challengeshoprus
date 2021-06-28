package com.shoprus.microservicios.generics.controllers;

import javax.servlet.http.HttpServletRequest;

import com.shoprus.microservicios.commons.controllers.dtos.ErrorInfoRespDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface GlobalDefaultExceptionHandlerGenericController {
 
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(Exception.class)
    public default ErrorInfoRespDTO handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ErrorInfoRespDTO(req.getRequestURL().toString(), ex);
    }
}