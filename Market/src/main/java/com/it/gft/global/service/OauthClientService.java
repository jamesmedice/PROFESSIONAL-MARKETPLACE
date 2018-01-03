package com.it.gft.global.service;

import com.it.gft.global.model.OauthClient;

public interface OauthClientService {
    
    void saveOauthClient(OauthClient entity);

    void deleteOauthClientById(String id);

    void deleteOauthClient(OauthClient entity);

    OauthClient findById(String id);

    void updateOauthClient(OauthClient entity);

}
