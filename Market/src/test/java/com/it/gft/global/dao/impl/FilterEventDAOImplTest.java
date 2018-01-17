package com.it.gft.global.dao.impl;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.it.gft.global.app.AppConfig;
import com.it.gft.global.model.Company;
import com.it.gft.global.model.FilterEvent;
import com.it.gft.global.service.CompanyService;
import com.it.gft.global.service.FilterEventService;
import com.it.gft.global.util.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(classes = { AppConfig.class })
public class FilterEventDAOImplTest {

    private static final Integer ID_COMPANY_1 = 1;

    @Autowired
    @Qualifier(value = "companyService")
    private CompanyService companyService;

    @Autowired
    @Qualifier(value = "filterEventService")
    private FilterEventService filterEventService;

    private JsonUtils jsonUtils;

    @Before
    public void init() {
	jsonUtils = new JsonUtils();
    }

    @Test
    public void findAllAndPersistTest() throws Exception {
	try {

	    Company item = companyService.findById(ID_COMPANY_1);

	    String json = jsonUtils.serializeAsJsonString(item);

	    FilterEvent filterEvent = new FilterEvent();
	    filterEvent.setEventdoc(json);
	    filterEventService.save(filterEvent);
	} catch (IOException e) {
	    throw new Exception("FAILURE");
	}
    }

}
