package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.Market;

public interface MarketDAO extends BaseDAO<Market> {

    void save(Market entity);

    void deleteById(Integer id);

    void update(Market entity);

    void delete(Market entity);

    List<Market> findAll(Boolean orderBy, String name);

    Market findById(Integer id);
}
