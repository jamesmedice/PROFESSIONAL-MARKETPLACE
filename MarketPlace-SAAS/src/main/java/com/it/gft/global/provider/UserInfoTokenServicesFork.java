package com.it.gft.global.provider;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * 
 * @author TOSS
 *
 */
public class UserInfoTokenServicesFork implements ResourceServerTokenServices {

    protected final Log logger = LogFactory.getLog(getClass());

    private String userInfoEndpointUrl;

    private final String clientId;

    private OAuth2RestOperations restTemplate;

    private String tokenType = DefaultOAuth2AccessToken.BEARER_TYPE;

    public UserInfoTokenServicesFork(String userInfoEndpointUrl, String clientId) {
	this.userInfoEndpointUrl = userInfoEndpointUrl;
	this.clientId = clientId;
    }

    public String getUserInfoEndpointUrl() {
	return userInfoEndpointUrl;
    }

    public void setUserInfoEndpointUrl(String userInfoEndpointUrl) {
	this.userInfoEndpointUrl = userInfoEndpointUrl;
    }

    public void setTokenType(String tokenType) {
	this.tokenType = tokenType;
    }

    public void setRestTemplate(OAuth2RestOperations restTemplate) {
	this.restTemplate = restTemplate;
    }

    public OAuth2AccessToken readAccessToken(String accessToken) {
	throw new UnsupportedOperationException("Not supported: read access token");
    }

    @SuppressWarnings({ "unchecked" })
    private Map<String, Object> getMap(String path, String accessToken) {
	this.logger.info("Getting user info from: " + path);
	try {
	    OAuth2RestOperations restTemplate = this.restTemplate;
	    if (restTemplate == null) {
		BaseOAuth2ProtectedResourceDetails resource = new BaseOAuth2ProtectedResourceDetails();
		resource.setClientId(this.clientId);
		restTemplate = new OAuth2RestTemplate(resource);
	    }
	    OAuth2AccessToken existingToken = restTemplate.getOAuth2ClientContext().getAccessToken();
	    if (existingToken == null || !accessToken.equals(existingToken.getValue())) {
		DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
		token.setTokenType(this.tokenType);
		restTemplate.getOAuth2ClientContext().setAccessToken(token);
	    }
	    return restTemplate.getForEntity(path, Map.class).getBody();
	} catch (Exception ex) {
	    this.logger.info("Could not fetch user details: " + ex.getClass() + ", " + ex.getMessage());
	    return Collections.<String, Object> singletonMap("error", "Could not fetch user details");
	}
    }

    public OAuth2Authentication loadAuthentication(String arg0) throws AuthenticationException, InvalidTokenException {

	return null;
    }

}
