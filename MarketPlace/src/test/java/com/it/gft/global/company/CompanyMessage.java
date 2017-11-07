package com.it.gft.global.company;

import java.util.List;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.gft.global.model.Company;

public class CompanyMessage extends GenericMessage<List<Company>> {

    @JsonCreator
    public CompanyMessage(@JsonProperty("payload") List<Company> payload, @JsonProperty("headers") MessageHeaders headers) {
	super(payload, headers);
    }

    private static final long serialVersionUID = 1132133135709947153L;

}
