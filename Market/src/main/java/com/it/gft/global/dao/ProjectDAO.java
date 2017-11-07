package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.*;

public interface ProjectDAO extends BaseDAO<Project> {

    void save(Project entity);

    void update(Project entity);

    void delete(Project entity);

    void deleteById(Integer id);

    List<Project> findAll(Boolean orderBy, String name);

    Project findById(Integer id);

}
