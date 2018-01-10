package com.it.gft.global.message.component.employee;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Employee;
import com.it.gft.global.model.Profile;

@MessageEndpoint
public class EmployeeAggregator {

    @Bean(name = "employeeSetOutput")
    public MessageChannel employeeAggregatorOutput() {
	return new DirectChannel();
    }

    @Aggregator(inputChannel = "employeeActivatorOutput", outputChannel = "employeeSetOutput")
    public Profile responseAggregator(List<Employee> request) {
	Profile response = new Profile();
	response.getEmployees().addAll(request);
	return response;
    }

}
