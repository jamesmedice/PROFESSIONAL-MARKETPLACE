package com.it.gft.global.service;

import com.it.gft.global.model.OauthDetails;

public interface OauthDetailsService {
    
    void saveOauthDetails(OauthDetails entity);

    void deleteOauthDetailsById(String id);

    void deleteOauthDetails(OauthDetails entity);

    OauthDetails findById(String id);

    void updateOauthDetails(OauthDetails entity);

}
