package com.it.gft.global.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 
 * @author TOSS
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "*****";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
	resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
	 http.anonymous()
	 .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
         .and().authorizeRequests()
         	.antMatchers(HttpMethod.OPTIONS).permitAll()
		.antMatchers("/t1/oauth**").permitAll()
		.antMatchers("/t1/public**").permitAll()
		.antMatchers("/t1/private**").authenticated() 
		.antMatchers("/t1/protected**").authenticated().anyRequest().permitAll();
    }
}