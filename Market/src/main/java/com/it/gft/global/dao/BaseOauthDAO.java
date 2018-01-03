package com.it.gft.global.dao;

import java.util.List;

public interface BaseOauthDAO<T> {

    void save(T entity);

    List<T> findAll(Boolean orderBy, String name);

    void deleteById(String id);

    void update(T entity);

    void delete(T entity);

    T findById(String id);
}
