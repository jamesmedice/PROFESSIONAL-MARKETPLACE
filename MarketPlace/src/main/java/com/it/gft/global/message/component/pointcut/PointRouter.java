package com.it.gft.global.message.component.pointcut;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.messages.StandardSet;

@MessageEndpoint
public class PointRouter {

    @Bean(name = "pointOutChannel")
    public MessageChannel pointOutChannel() {
	return new DirectChannel();
    }

    @ServiceActivator
    public RecipientListRouter routers(Message<StandardSet> request) {
	RecipientListRouter router = new RecipientListRouter();
	router.setApplySequence(true);
	router.setIgnoreSendFailures(true);
	router.setDefaultOutputChannel(pointOutChannel());
	router.addRecipient("projectChannel" , "payload.parents");
	router.addRecipient("profileChannel", "payload.childs");
	return router;
    }

}
