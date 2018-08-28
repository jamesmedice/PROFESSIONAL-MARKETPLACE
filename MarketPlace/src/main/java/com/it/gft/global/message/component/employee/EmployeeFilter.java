package com.it.gft.global.message.component.employee;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.message.component.client.BaseFilter;

@MessageEndpoint
public class EmployeeFilter extends BaseFilter {

	@Bean(name = "employeeSetInput")
	public MessageChannel employeeSetInput() {
		return new DirectChannel();
	}

	@Filter(inputChannel = "employeeSetInput", outputChannel = "employeeSplitterInput", discardChannel = "errorEmployeeChannel", throwExceptionOnRejection = "true")
	public Boolean verify(Message<List<String>> request) {
		return baseFilterRequest(request);
	}

}
