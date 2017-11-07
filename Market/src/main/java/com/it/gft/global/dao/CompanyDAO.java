package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.Company;

public interface CompanyDAO extends BaseDAO<Company> {

    void save(Company entity);

    List<Company> findAll(Boolean orderBy, String name);

    void deleteById(Integer id);

    void update(Company entity);

    void delete(Company entity);

    Company findById(Integer id);

}
