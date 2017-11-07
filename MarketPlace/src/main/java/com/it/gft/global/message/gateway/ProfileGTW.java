package com.it.gft.global.message.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;

import com.it.gft.global.model.Profile;

@MessagingGateway(defaultRequestChannel = "requestChannel", defaultReplyChannel = "responseChannel", defaultReplyTimeout = "8000")
public interface ProfileGTW {

    @Bean(name = "requestChannel")
    public default MessageChannel requestChannel() {
	return new DirectChannel();
    }

    @Bean(name = "responseChannel")
    public default MessageChannel responseChannel() {
	return new QueueChannel();
    }

    @Gateway(requestChannel = "profileFilterInput", replyChannel = "profileByIdOutput")
    GenericMessage<Profile> findProfile(@Payload Message<Profile> request);
}