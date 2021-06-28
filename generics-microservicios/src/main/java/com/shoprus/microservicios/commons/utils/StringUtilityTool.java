package com.shoprus.microservicios.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class StringUtilityTool {

    private ObjectMapper mapper = new ObjectMapper();
    
    public String objectToString (Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            
            e.printStackTrace();

            return "No se pudo mapear objeto a JSON: " + e.getMessage();
        }
    }
}