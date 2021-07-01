package com.shoprus.microservicios.controllers.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDTO {

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String email;

    @NotBlank
    @Size(min = 1, max = 2, message = "Ingrese 1 Afiliado - 2 Empleado")
    private Long idTipoUsuario;
    
    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   
}