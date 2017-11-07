package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.Profile;

public interface ProfileDAO extends BaseDAO<Profile> {

    void save(Profile entity);

    List<Profile> findAll(Boolean orderBy, String name);

    void deleteById(Integer id);

    void update(Profile entity);

    void delete(Profile entity);

    Profile findById(Integer id);

}
