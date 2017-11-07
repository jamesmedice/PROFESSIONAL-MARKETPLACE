package com.it.gft.global;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.it.gft.global.json.DateObjectSerializer;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	SimpleModule module = new SimpleModule();
	module.addSerializer(new DateObjectSerializer());
	Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().modules(module);
	converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	super.configureMessageConverters(converters);
    }

}
