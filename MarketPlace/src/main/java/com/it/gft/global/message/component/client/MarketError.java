package com.it.gft.global.message.component.client;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Market;

/**
 * 
 * @author TOSS
 *
 */
@MessageEndpoint
public class MarketError {

    private static final String MISSING_REQUIRED_FIELDS = "Missing required fields_:";

    @Bean(name = "errorChannel")
    public MessageChannel errorChannel() {
	return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "errorClientChannel")
    public Message<?> displayErrorMessage(Message<Market> request) {
	return MessageBuilder.withPayload(MISSING_REQUIRED_FIELDS + request.getPayload().toString()).build();
    }

}
