package com.it.gft.global.message.component.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Market;
import com.it.gft.global.service.MarketService;

@MessageEndpoint
public class MarketActivator {

    @Autowired(required = true)
    @Qualifier("marketService")
    private MarketService marketService;

    @Bean(name = "clientActivatorOutput")
    public MessageChannel clientSplitterOutput() {
	return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "clientSplitterOutput", outputChannel = "clientActivatorOutput")
    public Market request(Market client) {
	return marketService.findById(client.getId().intValue());
    }
}
