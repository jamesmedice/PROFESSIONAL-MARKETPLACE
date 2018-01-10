package com.it.gft.global.message.component.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Employee;

/**
 * 
 * @author TOSS
 *
 */
@MessageEndpoint
public class EmployeeSplitter {

    @Bean(name = "employeeSplitterInput")
    public MessageChannel employeeSplitterInput() {
	return new DirectChannel();
    }

    @Bean(name = "employeeSplitterOutput")
    public MessageChannel employeeSplitterOutput() {
	return new DirectChannel();
    }

    @Splitter(inputChannel = "employeeSplitterInput", outputChannel = "employeeSplitterOutput")
    public List<Employee> createRequests(List<String> request) {
	List<Employee> response = new ArrayList<Employee>();

	for (String item : request) {
	    Employee target = new Employee();
	    target.setLevel(Integer.parseInt(item));
	    response.add(target);
	}

	return response;
    }

}
