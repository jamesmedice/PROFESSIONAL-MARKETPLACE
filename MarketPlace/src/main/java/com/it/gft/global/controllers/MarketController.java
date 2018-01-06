package com.it.gft.global.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.gft.global.message.gateway.MarketGTW;
import com.it.gft.global.model.Market;

@RestController
@RequestMapping(path = BaseProtectedApi.PREFIX_PROTECTED + "/market")
public class MarketController {

    @Autowired
    private MarketGTW marketGTW;

    @RequestMapping(value = "/ids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message<List<Market>> findClients(@RequestBody List<String> ids, Principal principal) {
	Message<List<String>> request = new GenericMessage<List<String>>(ids);
	return marketGTW.findClients(request);
    }

}
