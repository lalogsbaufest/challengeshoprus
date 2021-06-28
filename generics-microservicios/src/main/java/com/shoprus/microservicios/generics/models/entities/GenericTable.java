package com.shoprus.microservicios.generics.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
public abstract class GenericTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    protected Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "hibernateProxy"})
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="fec_crea")
	protected Date fecCrea;
	
	@Column(name="estatus")
	protected Boolean estatus;
	
	@PrePersist
	public void prePersist () {
		fecCrea = new Date();
        estatus = true;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Date fecCrea) {
        this.fecCrea = fecCrea;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}