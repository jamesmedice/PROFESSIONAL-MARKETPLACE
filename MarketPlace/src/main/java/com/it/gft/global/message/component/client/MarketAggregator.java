package com.it.gft.global.message.component.client;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Market;
import com.it.gft.global.model.Company;

@MessageEndpoint
public class MarketAggregator {

    @Bean(name = "clientSetOutput")
    public MessageChannel clientAggregatorOutput() {
	return new DirectChannel();
    }

    @Aggregator(inputChannel = "clientActivatorOutput", outputChannel = "clientSetOutput")
    public Company responseAggregator(List<Market> request) {
	Company response = new Company();
	response.getClients().addAll(request);
	return response;
    }

}
