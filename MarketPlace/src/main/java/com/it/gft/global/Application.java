package com.it.gft.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author MEDICI
 *
 */
@ComponentScan(basePackages = { "com.it.gft.global" })
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public Application() {
	super();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(new Object[] { Application.class });
    }

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
