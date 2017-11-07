package com.it.gft.global.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.it.gft.global.model.Company;
import com.it.gft.global.model.EntityProvider;
import com.it.gft.global.model.FilterEvent;
import com.it.gft.global.service.CompanyService;
import com.it.gft.global.service.FilterEventService;
import com.it.gft.global.util.JsonUtils;

public class AppMainRunner extends EntityProvider {

    static List<Company> companies = null;

    public static void main(String[] args) throws Exception {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	CompanyService service = (CompanyService) context.getBean("companyService");
	service.saveCompany(getCompany());

	FilterEventService filterEventService = (FilterEventService) context.getBean("filterEventService");

	companies = service.findAllCompanies();
	showProperties(companies);
	try {
	    for (Company item : companies) {
		String json = JsonUtils.serializeAsJsonString(item);

		FilterEvent filterEvent = new FilterEvent();
		filterEvent.setEventdoc(json);
		filterEventService.save(filterEvent);
	    }
	} catch (Exception e) {
	    throw new Exception("FAILURE");
	}
    }

}
