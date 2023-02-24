package com.oauth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

 

@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
public class OauthCodeApplication extends SpringBootServletInitializer {
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OauthCodeApplication.class);
	}
	//server.port=8082
	//localhost:8082/spring-boot-oauth-code-client/getDashboard
	//localhost:8082/spring-boot-oauth-code-client/getBankAccount
	public static void main(String[] args) {
		SpringApplication.run(OauthCodeApplication.class, args);
		
	}
}