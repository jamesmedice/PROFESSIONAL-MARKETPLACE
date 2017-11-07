package com.it.gft.global.dao;

import java.util.List;

public interface BaseDAO<T> {

    void save(T entity);

    List<T> findAll(Boolean orderBy, String name);

    void deleteById(Integer id);

    void update(T entity);

    void delete(T entity);

    T findById(Integer id);
}
