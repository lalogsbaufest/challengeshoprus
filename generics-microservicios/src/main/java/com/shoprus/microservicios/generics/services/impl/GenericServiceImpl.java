package com.shoprus.microservicios.generics.services.impl;

import java.util.Optional;

import com.shoprus.microservicios.generics.services.IGenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class GenericServiceImpl<E, R extends PagingAndSortingRepository<E, Long>> implements IGenericService<E> {

    @Autowired
    protected R repository;

    @Override
    public Page<E> findAllWithPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public E save(E entity) {
        return repository.save(entity);
    }
    
}
