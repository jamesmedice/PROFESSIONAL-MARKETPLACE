package com.it.gft.global.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.OauthDetailsDAO;
import com.it.gft.global.model.OauthDetails;
import com.it.gft.global.service.OauthDetailsService;

@Service("oauthDetailsService")
@Transactional
public class OauthDetailsServiceImpl implements OauthDetailsService {

    @Autowired(required = true)
    private OauthDetailsDAO oauthClientDAO;

    @Override
    public void saveOauthDetails(OauthDetails entity) {
	oauthClientDAO.save(entity);
    }

    @Override
    public void deleteOauthDetailsById(String id) { 
	oauthClientDAO.deleteById(id);
    }

    @Override
    public void deleteOauthDetails(OauthDetails entity) { 
	oauthClientDAO.delete(entity);
    }

    @Override
    public OauthDetails findById(String id) { 
	return oauthClientDAO.findById(id);
    }

    @Override
    public void updateOauthDetails(OauthDetails entity) { 
	oauthClientDAO.update(entity);
    }

}
