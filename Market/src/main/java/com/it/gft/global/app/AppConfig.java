package com.it.gft.global.app;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.it.gft.global.service.CompanyService;
import com.it.gft.global.service.FilterEventService;
import com.it.gft.global.service.impl.CompanyServiceImpl;
import com.it.gft.global.service.impl.FilterEventServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.it.gft.global")
public class AppConfig {

    @Bean(autowire = Autowire.BY_NAME, name = "companyService")
    public CompanyService companyService() {
	return new CompanyServiceImpl();
    }

    @Bean(autowire = Autowire.BY_NAME, name = "filterEventService")
    public FilterEventService filterEventService() {
	return new FilterEventServiceImpl();
    }
}
