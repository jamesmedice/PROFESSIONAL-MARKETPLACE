package com.it.gft.global.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.filter.OAuth2AuthenticationFailureEvent;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class CustomFilter extends AbstractAuthenticationProcessingFilter {

    public OAuth2RestOperations restTemplate;
    private UserInfoTokenServicesFork tokenServices;

    public CustomFilter(String defaultFilterProcessesUrl) {
	super(defaultFilterProcessesUrl);
    }

    public void setTokenServices(UserInfoTokenServicesFork tokenServices) {
	this.tokenServices = tokenServices;
    }

    public void setRestTemplate(OAuth2RestOperations restTemplate) {
	this.restTemplate = restTemplate;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
	OAuth2AccessToken accessToken;
	try {
	    accessToken = restTemplate.getAccessToken();
	} catch (OAuth2Exception e) {
	    BadCredentialsException bad = new BadCredentialsException("Could not obtain access token", e);
	    publish(new OAuth2AuthenticationFailureEvent(bad));
	    throw bad;
	}
	try {
	    String userInfoEndpointUrl = tokenServices.getUserInfoEndpointUrl() + "?uids=" + accessToken.getAdditionalInformation().get("user_id").toString();
	    tokenServices.setUserInfoEndpointUrl(userInfoEndpointUrl);
	    OAuth2Authentication result = tokenServices.loadAuthentication(accessToken.getValue());
	    if (authenticationDetailsSource != null) {
		request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, accessToken.getValue());
		request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, accessToken.getTokenType());
		result.setDetails(authenticationDetailsSource.buildDetails(request));
	    }
	    publish(new AuthenticationSuccessEvent(result));
	    return result;
	} catch (InvalidTokenException e) {
	    BadCredentialsException bad = new BadCredentialsException("Could not obtain user details from token", e);
	    publish(new OAuth2AuthenticationFailureEvent(bad));
	    throw bad;
	}
    }

    private void publish(ApplicationEvent event) {
	if (eventPublisher != null) {
	    eventPublisher.publishEvent(event);
	}
    }
}
