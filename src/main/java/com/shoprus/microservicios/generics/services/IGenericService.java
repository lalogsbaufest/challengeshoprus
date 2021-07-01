package com.shoprus.microservicios.generics.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenericService<E> {
    
    public Page<E> findAllWithPage(Pageable pageable);

    public Iterable<E> findAll();

    public Optional<E> findById (Long id);

    public E save(E entity);
}
