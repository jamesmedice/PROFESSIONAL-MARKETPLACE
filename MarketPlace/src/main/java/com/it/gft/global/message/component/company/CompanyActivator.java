package com.it.gft.global.message.component.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import com.it.gft.global.model.Company;
import com.it.gft.global.model.StandardOrder;
import com.it.gft.global.service.CompanyService;

/**
 * 
 * @author TOSS
 *
 */
@MessageEndpoint
public class CompanyActivator {

    @Autowired(required = true)
    @Qualifier("companyService")
    private CompanyService companyService;

    @Bean(name = "companyByIdInput")
    public MessageChannel companyByIdInput() {
	return new DirectChannel();
    }

    @Bean(name = "companyByIdOutput")
    public MessageChannel companyByIdOutput() {
	return new DirectChannel();
    }

    @Bean(name = "companyByExInput")
    public MessageChannel companyByExInput() {
	return new DirectChannel();
    }

    @Bean(name = "companyByExOutput")
    public MessageChannel companyByExOutput() {
	return new DirectChannel();
    }

    @Bean(name = "companySetInput")
    public MessageChannel companySetInput() {
	return new DirectChannel();
    }

    @Bean(name = "companySetOutput")
    public MessageChannel companySetOutput() {
	return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "companyByIdInput", outputChannel = "companyByIdOutput")
    public Message<Company> companyById(Message<Company> request) {
	Long id = ((Company) request.getPayload()).getId();
	Company company = companyService.findById(id.intValue());

	return new GenericMessage<Company>(company);
    }

    @ServiceActivator(inputChannel = "companyByExInput", outputChannel = "companyByExOutput")
    public Message<Company> companyByExample(Message<Company> request) {
	Long id = ((Company) request.getPayload()).getId();
	Company company = companyService.findById(id.intValue());

	return new GenericMessage<Company>(company);
    }

    @ServiceActivator(inputChannel = "companySetInput", outputChannel = "companySetOutput")
    public Message<List<Company>> findAllCompanies(Message<StandardOrder> request) {
	Boolean isOrdered = ((StandardOrder) request.getPayload()).getOrder();
	String name = ((StandardOrder) request.getPayload()).getName();

	List<Company> companies = companyService.findAllCompanies(isOrdered, name);
	return new GenericMessage<List<Company>>(companies);
    }

}
