package com.shoprus.microservicios.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shoprus.microservicios.generics.models.entities.GenericTable;

@Entity
@Table(name = "usuarios", schema = "clientes")
public class Usuario extends GenericTable {

    @Column(length = 50)
    private String nombre;

    @Column(name="apellido_paterno", length = 100)
    private String apellidoPaterno;

    @Column(name="apellido_materno", length = 100)
    private String apellidoMaterno;

    @Column(length = 50, unique = true)
    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "hibernateProxy"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_tipo_usuario_id")
    private TipoUsuario tipoUsuario;

    public Usuario () {}

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String email, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}