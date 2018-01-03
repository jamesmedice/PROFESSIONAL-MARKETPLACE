package com.it.gft.global.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.OauthClientDAO;
import com.it.gft.global.model.OauthClient;
import com.it.gft.global.service.OauthClientService;

@Service("oauthClientService")
@Transactional
public class OauthClientServiceImpl implements OauthClientService {

    @Autowired(required = true)
    private OauthClientDAO oauthClientDAO;

    @Override
    public void saveOauthClient(OauthClient entity) {
	oauthClientDAO.save(entity);
    }

    @Override
    public void deleteOauthClientById(String id) { 
	oauthClientDAO.deleteById(id);
    }

    @Override
    public void deleteOauthClient(OauthClient entity) { 
	oauthClientDAO.delete(entity);
    }

    @Override
    public OauthClient findById(String id) { 
	return oauthClientDAO.findById(id);
    }

    @Override
    public void updateOauthClient(OauthClient entity) { 
	oauthClientDAO.update(entity);
    }

}
