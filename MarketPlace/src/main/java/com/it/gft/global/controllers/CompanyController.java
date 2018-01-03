package com.it.gft.global.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.gft.global.message.gateway.CompanyGTW;
import com.it.gft.global.model.Company;
import com.it.gft.global.model.StandardOrder;
import com.it.gft.global.service.CompanyService;

/**
 * 
 * @author TOSS
 *
 */

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired(required = true)
    @Qualifier("companyService")
    private CompanyService companyService;

    @Autowired
    private CompanyGTW companyGTW;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public GenericMessage<List<Company>> retrieveAllCompanies(Principal principal) {
	List<Company> companies = companyService.findAllCompanies();
	return new GenericMessage<List<Company>>(companies);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Message<Company> retrieveCompanyById(@PathVariable Integer id, Principal principal) {
	Company payload = companyService.findById(id);
	return new GenericMessage<Company>(payload);
    }

    @RequestMapping(path = "/entity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message<Company> retrieveCompany(@RequestBody Company payload, Principal principal) {
	Message<Company> request = MessageBuilder.withPayload(payload).build();
	return companyGTW.companyById(request);
    }

    @RequestMapping(path = "/entityEx", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message<Company> retrieveCompanyEx(@RequestBody Company payload, Principal principal) {
	Message<Company> request = MessageBuilder.withPayload(payload).build();
	return companyGTW.companyByExample(request);
    }

    @RequestMapping(path = "/entitySet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message<List<Company>> retrieveAllCompanies(@RequestBody StandardOrder payload, Principal principal) {
	Message<StandardOrder> request = MessageBuilder.withPayload(payload).build();
	return companyGTW.findAllCompanies(request);
    }

}
