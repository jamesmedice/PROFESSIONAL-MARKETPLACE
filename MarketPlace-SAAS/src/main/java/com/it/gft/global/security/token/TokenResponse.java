package com.it.gft.global.security.token;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author TOSS
 *
 */
public class TokenResponse {

    @JsonProperty
    private String token;

    public TokenResponse() {
    }

    public TokenResponse(String token) {
	this.token = token;
    }
}