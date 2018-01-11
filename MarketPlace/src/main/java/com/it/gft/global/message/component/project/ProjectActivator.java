package com.it.gft.global.message.component.project;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;

@MessageEndpoint
public class ProjectActivator {

    @Bean(name = "projectChannel")
    public MessageChannel projectChannel() {
	return new QueueChannel();
    }

}