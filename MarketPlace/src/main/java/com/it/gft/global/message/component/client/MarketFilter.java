package com.it.gft.global.message.component.client;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.message.component.BaseFilter;

@MessageEndpoint
public class MarketFilter extends BaseFilter {

	@Bean(name = "clientSetInput")
	public MessageChannel clientSetInput() {
		return new DirectChannel();
	}

	@Filter(inputChannel = "clientSetInput", outputChannel = "clientSplitterInput", discardChannel = "errorClientChannel", throwExceptionOnRejection = "true")
	public Boolean verify(Message<List<String>> request) {
		return baseFilterRequest(request);
	}

}
