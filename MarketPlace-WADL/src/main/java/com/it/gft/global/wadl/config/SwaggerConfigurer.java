package com.it.gft.global.wadl.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author TOSS
 *
 */
@EnableSwagger2
public class SwaggerConfigurer {

    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.it.gft.global.controllers")).paths(PathSelectors.any()).build()
		.apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
	ApiInfo apiInfo = new ApiInfo("MarketPlaceApplication", "An application to manage resources internaly at any company", "MarketPlaceApplication v1", "Terms of service",
		"tiago.sllater@gmail.com", "License of API", "License URL");
	return apiInfo;
    }
}
