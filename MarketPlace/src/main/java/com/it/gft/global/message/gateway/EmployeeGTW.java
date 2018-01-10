package com.it.gft.global.message.gateway;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;

import com.it.gft.global.model.Employee;

/**
 * 
 * @author TOSS
 *
 */
@MessagingGateway(defaultRequestChannel = "requestEmployeeChannel", defaultReplyChannel = "responseEmployeeChannel", defaultReplyTimeout = "8000")
public interface EmployeeGTW {

    @Bean(name = "requestEmployeeChannel")
    public default MessageChannel requestEmployeeChannel() {
	return new DirectChannel();
    }

    @Bean(name = "responseEmployeeChannel")
    public default MessageChannel responseEmployeeChannel() {
	return new QueueChannel();
    }

    @Gateway(requestChannel = "employeeSetInput", replyChannel = "employeeSetOutput")
    GenericMessage<List<Employee>> findEmployees(@Payload Message<List<String>> request);

}
