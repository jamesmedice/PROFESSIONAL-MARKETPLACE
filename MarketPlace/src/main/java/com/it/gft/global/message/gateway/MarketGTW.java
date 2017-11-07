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

import com.it.gft.global.model.Market;

/**
 * 
 * @author TOSS
 *
 */
@MessagingGateway(defaultRequestChannel = "requestClientChannel", defaultReplyChannel = "responseClientChannel", defaultReplyTimeout = "8000")
public interface MarketGTW {

    @Bean(name = "requestClientChannel")
    public default MessageChannel requestClientChannel() {
	return new DirectChannel();
    }

    @Bean(name = "responseClientChannel")
    public default MessageChannel responseClientChannel() {
	return new QueueChannel();
    }

    @Gateway(requestChannel = "clientSetInput", replyChannel = "clientSetOutput")
    GenericMessage<List<Market>> findClients(@Payload Message<List<String>> request);

}
