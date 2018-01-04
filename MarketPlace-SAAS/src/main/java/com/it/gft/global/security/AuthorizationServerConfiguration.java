package com.it.gft.global.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 
 * @author TOSS
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final String OAUTH_PREFIX_URL = "t1/oauth";

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Value("classpath:schema.sql")
    private Resource schemaDataScript;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

	clients.jdbc(dataSource).withClient("sampleClientId").authorizedGrantTypes("implicit").scopes("read").autoApprove(true).and().withClient("clientIdPassword")
		.authorizedGrantTypes("password", "headers", "authorization_code", "refresh_token", "implicit").scopes("read", "write", "trust").secret("secret")
		.accessTokenValiditySeconds(1200).refreshTokenValiditySeconds(3600);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).pathMapping("/oauth/token", OAUTH_PREFIX_URL + "/token")
		.pathMapping("/oauth/authorize", OAUTH_PREFIX_URL + "/authorize").pathMapping("/oauth/check_token", OAUTH_PREFIX_URL + "/check_token")
		.pathMapping("/oauth/confirm_access", OAUTH_PREFIX_URL + "confirm_access").pathMapping("/oauth/error", OAUTH_PREFIX_URL + "/error");

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Bean
    public TokenStore tokenStore() {
	return new JdbcTokenStore(dataSource);
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
	DataSourceInitializer initializer = new DataSourceInitializer();
	initializer.setDataSource(dataSource);
	initializer.setDatabasePopulator(dataPopulator());
	return initializer;
    }

    private DatabasePopulator dataPopulator() {
	ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	populator.addScript(schemaDataScript);
	return populator;
    }
}
