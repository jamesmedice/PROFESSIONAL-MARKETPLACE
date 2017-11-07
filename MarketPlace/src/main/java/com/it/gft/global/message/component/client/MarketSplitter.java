package com.it.gft.global.message.component.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Market;

/**
 * 
 * @author TOSS
 *
 */
@MessageEndpoint
public class MarketSplitter {

    @Bean(name = "clientSplitterInput")
    public MessageChannel clientSplitterInput() {
	return new DirectChannel();
    }

    @Bean(name = "clientSplitterOutput")
    public MessageChannel clientSplitterOutput() {
	return new DirectChannel();
    }

    @Splitter(inputChannel = "clientSplitterInput", outputChannel = "clientSplitterOutput")
    public List<Market> createRequests(List<String> request) {
	List<Market> response = new ArrayList<Market>();

	for (String item : request) {
	    Market client = new Market();
	    client.setId(Integer.parseInt(item));
	    response.add(client);
	}

	return response;
    }

}
