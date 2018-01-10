package com.it.gft.global.message.component.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Employee;
import com.it.gft.global.service.EmployeeService;

@MessageEndpoint
public class EmployeeActivator {

    @Autowired(required = true)
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @Bean(name = "employeeActivatorOutput")
    public MessageChannel employeeSplitterOutput() {
	return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "employeeSplitterOutput", outputChannel = "employeeActivatorOutput")
    public Employee request(Employee target) {
	return employeeService.findById(target.getId().intValue());
    }
}
