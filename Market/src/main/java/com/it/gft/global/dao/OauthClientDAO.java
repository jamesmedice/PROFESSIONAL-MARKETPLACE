package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.OauthClient;

/**
 * 
 * @author TOSS
 *
 */
public interface OauthClientDAO extends BaseOauthDAO<OauthClient> {

    void save(OauthClient entity);

    void deleteById(String id);

    void update(OauthClient entity);

    List<OauthClient> findAll(Boolean orderBy, String name);

    OauthClient findById(String id);

}
