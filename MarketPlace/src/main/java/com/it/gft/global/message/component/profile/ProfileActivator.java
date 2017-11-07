package com.it.gft.global.message.component.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import com.it.gft.global.model.Profile;
import com.it.gft.global.service.ProfileService;

@MessageEndpoint
public class ProfileActivator {

    @Autowired(required = true)
    @Qualifier("profileService")
    private ProfileService profileService;

    @Bean(name = "profileByIdInput")
    public MessageChannel profileByIdInput() {
	return new DirectChannel();
    }

    @Bean(name = "profileByIdOutput")
    public MessageChannel profileByIdOutput() {
	return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "profileByIdInput", outputChannel = "profileByIdOutput")
    public Message<Profile> companyById(Message<Profile> request) {
	Long id = ((Profile) request.getPayload()).getId();
	Profile company = profileService.findById(id.intValue());

	return new GenericMessage<Profile>(company);
    }

}
