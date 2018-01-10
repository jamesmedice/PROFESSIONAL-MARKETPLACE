package com.it.gft.global.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.it.gft.global.aspect.provider.CompanyAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppAOPConfig {

    @Bean
    public  CompanyAspect companyAspect() {
	return new CompanyAspect();
    }
    
}
