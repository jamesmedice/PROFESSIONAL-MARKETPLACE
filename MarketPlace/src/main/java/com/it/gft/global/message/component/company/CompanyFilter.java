package com.it.gft.global.message.component.company;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Company;

@MessageEndpoint
public class CompanyFilter {

    @Bean(name = "companyFilterInput")
    public MessageChannel companyFilterInput() {
	return new DirectChannel();
    }

    @Filter(inputChannel = "companyFilterInput", outputChannel = "companyByIdInput", discardChannel = "errorChannel", throwExceptionOnRejection = "true")
    public Boolean verifyCompany(Message<Company> request) {
	Long id = request.getPayload().getId();
	return id != null && id > 0 ? true : false;
    }

}
