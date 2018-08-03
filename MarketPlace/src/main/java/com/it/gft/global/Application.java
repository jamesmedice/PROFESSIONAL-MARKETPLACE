package com.it.gft.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author MEDICI
 *
 */
@ComponentScan(basePackages = { "com.it.gft.global" })
@EnableConfigurationProperties
@SpringBootApplication
@ConfigurationProperties(value = "classpath:application.yaml")
public class Application extends SpringBootServletInitializer {

	public Application() {
		super();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);//NOSONAR
	}
}
