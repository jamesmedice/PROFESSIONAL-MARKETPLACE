package com.it.gft.global.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.it.gft.global.app.AppConfig;
import com.it.gft.global.model.OauthClient;
import com.it.gft.global.service.OauthClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(classes = { AppConfig.class })
public class OauthClientDAOImplTest {

    private static final Integer ID_ = 1;

    @Autowired
    private ApplicationContext context;

    @Autowired
    @Qualifier(value = "oauthClientService")
    private OauthClientService oauthClientService;

    @Before
    public void init() {
    }

    @Test
    public void findById() {
	OauthClient target = oauthClientService.findById(ID_.toString());
    }

}
