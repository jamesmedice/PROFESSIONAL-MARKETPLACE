package com.it.gft.global.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 
 * @author TOSS
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "*****";

    @Autowired
    private TokenStore tokenStore;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
	resources.resourceId(RESOURCE_ID).stateless(false);
	resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
	  http.anonymous().and().sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.NEVER)
          .and().authorizeRequests()
		.antMatchers("/t1/oauth**").permitAll()
		.antMatchers("/t1/public**").permitAll()
		.antMatchers("/t1/private**").authenticated() 
		.antMatchers("/t1/protected**").authenticated().anyRequest().permitAll();
    }
}
