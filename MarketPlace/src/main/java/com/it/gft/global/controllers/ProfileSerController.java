package com.it.gft.global.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.gft.global.message.gateway.ProfileGTW;
import com.it.gft.global.model.Profile;
import com.it.gft.global.service.ProfileService;

/**
 * 
 * @author TOSS
 *
 */
@RestController
@RequestMapping(path = BaseProtectedApi.PREFIX_PROTECTED + "/profile")
public class ProfileSerController {

    @Autowired(required = true)
    @Qualifier("profileService")
    private ProfileService profileService;

    @Autowired(required = true)
    private ProfileGTW profileGTW;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message<Profile> findProfile(@PathVariable Integer id, Principal principal) {
	Profile profile = new Profile();
	profile.setId(id);
	Message<Profile> request = new GenericMessage<Profile>(profile);
	return profileGTW.findProfile(request);
    }
}
