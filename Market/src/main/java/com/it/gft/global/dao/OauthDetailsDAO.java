package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.OauthDetails;

/**
 * 
 * @author TOSS
 *
 */
public interface OauthDetailsDAO extends BaseOauthDAO<OauthDetails> {

    void save(OauthDetails entity);

    void deleteById(String id);

    void update(OauthDetails entity);

    List<OauthDetails> findAll(Boolean orderBy, String name);

    OauthDetails findById(String id);

}
