/*
 *
 *  (C) Copyright 2017 Ymatou (http://www.ymatou.com/).
 *  All rights reserved.
 *
 */

package com.ymatou.openapi.service.impl;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ymatou.openapi.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

    protected JpaRepository jpaRepository;

    public BaseServiceImpl(JpaRepository J) {
        this.jpaRepository = J;
    }

    @Override
    @Transactional
    public void save(T t) {
        jpaRepository.save(t);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        jpaRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(T t) {
        jpaRepository.delete(t);
    }

    @Override
    public T findById(Long id) {
        return (T) jpaRepository.findOne(id);
    }

    @Override
    @Transactional
    public void saveAll(Iterable<T> entities) {
        jpaRepository.save(entities);
    }

    @Override
    public Page<T> findByPage(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }
}
