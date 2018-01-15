package com.it.gft.global.app;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:dbConnection.properties" })
public class DataSourceConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	sessionFactory.setDataSource(dataSource());
	sessionFactory.setPackagesToScan(new String[] { "com.it.gft.global.model" });
	sessionFactory.setHibernateProperties(hibernateProperties());
	return sessionFactory;
    }

    @Bean(autowire = Autowire.BY_NAME, name = "dataSource")
    public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(environment.getRequiredProperty("hibernate.connection.driver_class"));
	dataSource.setUrl(environment.getRequiredProperty("hibernate.connection.url"));
	dataSource.setUsername(environment.getRequiredProperty("hibernate.connection.username"));
	dataSource.setPassword(environment.getRequiredProperty("hibernate.connection.password"));
	return dataSource;
    }

    private Properties hibernateProperties() {
	Properties properties = new Properties();
	properties.put("hibernate.dialect", environment.getRequiredProperty("dialect"));
	properties.put("hibernate.show_sql", environment.getRequiredProperty("show_sql"));
	properties.put("hibernate.format_sql", environment.getRequiredProperty("format_sql"));
	return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	transactionManager.setSessionFactory(sessionFactory);
	return transactionManager;
    }
}
