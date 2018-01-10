package com.it.gft.global.message.component.employee;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@MessageEndpoint
public class EmployeeFilter {

    @Bean(name = "employeeSetInput")
    public MessageChannel employeeSetInput() {
	return new DirectChannel();
    }

    @Filter(inputChannel = "employeeSetInput", outputChannel = "employeeSplitterInput", discardChannel = "errorEmployeeChannel", throwExceptionOnRejection = "true")
    public Boolean verify(Message<List<String>> request) {
	Boolean allInteger = true;

	for (String item : request.getPayload()) {

	    try {
		Integer.parseInt(item);
	    } catch (NumberFormatException e) {
		allInteger = false;
		break;
	    }
	}

	return allInteger;
    }

}
