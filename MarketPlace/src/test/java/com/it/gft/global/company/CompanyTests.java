package com.it.gft.global.company;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.it.gft.global.model.Company;
import com.it.gft.global.model.Project;
import com.it.gft.global.util.JsonUtils;

public class CompanyTests {

    private Logger LOGGER = Logger.getLogger(CompanyTests.class.getName());

    private JsonUtils json;

    private Map<String, Object> mapper;

    @Before
    public void init() {
	json = new JsonUtils();
	mapper = new HashMap<String, Object>();
	mapper.put("Account", "Advisor");
    }

    @Test
    public void serializeMap() throws JsonGenerationException, JsonMappingException, IOException {

	Calendar secondsBfr = Calendar.getInstance();
	secondsBfr.set(2017, 10, 10);
	Calendar first = Calendar.getInstance();
	first.set(2017, 04, 10);

	List<Project> sets = new ArrayList<Project>();
	Project c1 = new Project();
	c1.setInitDate(new Date());
	c1.setProjectName("");

	sets.add(c1);
	c1 = new Project();
	c1.setInitDate(new Date());
	c1.setProjectName("");
	sets.add(c1);

	serialTest((Serializable) sets);
    }

    public void serialTest(Serializable items) {

	for (Serializable serializable : (ArrayList<Serializable>) items) {

	    if (serializable instanceof java.util.Date)
		LOGGER.info(serializable.toString());
	    else
		LOGGER.info("++" + serializable);
	}
    }

}
