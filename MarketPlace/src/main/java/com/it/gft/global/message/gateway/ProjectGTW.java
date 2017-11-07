package com.it.gft.global.message.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;

@MessagingGateway(defaultRequestChannel = "requestChannel", defaultReplyChannel = "responseChannel", defaultReplyTimeout = "8000")
public interface ProjectGTW {

    @Bean(name = "requestChannel")
    public default MessageChannel requestChannel() {
	return new DirectChannel();
    }

    @Bean(name = "responseChannel")
    public default MessageChannel responseChannel() {
	return new QueueChannel();
    }
}
