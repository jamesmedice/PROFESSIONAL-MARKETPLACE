package com.it.gft.global.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * 
 * @author TOSS
 *
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	User user = (User) authentication.getPrincipal();
	final Map<String, Object> additionalInfo = new HashMap<String, Object>();

	additionalInfo.put("username", user.getUsername());
	additionalInfo.put("authorities", user.getAuthorities());

	((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

	return accessToken;
    }

}
