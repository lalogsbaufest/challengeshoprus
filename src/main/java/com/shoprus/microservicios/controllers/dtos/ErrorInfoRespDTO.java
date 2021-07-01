package com.shoprus.microservicios.controllers.dtos;

public class ErrorInfoRespDTO {
 
    private final String url;
    private final String ex;

    public ErrorInfoRespDTO(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }

    public String getUrl() {
        return url;
    }

    public String getEx() {
        return ex;
    }
}