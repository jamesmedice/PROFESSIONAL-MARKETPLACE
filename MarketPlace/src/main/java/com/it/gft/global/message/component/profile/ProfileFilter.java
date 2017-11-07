package com.it.gft.global.message.component.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.it.gft.global.model.Profile;

/**
 * 
 * @author TOSS
 *
 */
@MessageEndpoint
public class ProfileFilter {

    @Bean(name = "profileFilterInput")
    public MessageChannel profileFilterInput() {
	return new DirectChannel();
    }

    @Filter(inputChannel = "profileFilterInput", outputChannel = "profileByIdInput", discardChannel = "errorProfileChannel", throwExceptionOnRejection = "true")
    public Boolean verifyCompany(Message<Profile> request) {
	Long id = request.getPayload().getId();
	return id != null && id > 0 ? true : false;
    }

}
