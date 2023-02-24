package com.oauth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

 

@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
public class PasswordOauthClientApplication extends SpringBootServletInitializer {
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PasswordOauthClientApplication.class);
	}
	//server.port=8094
	//localhost:8094/spring-boot-oauth-password-client/getDashboard
	//localhost:8094/spring-boot-oauth-password-client/getBankAccount
	public static void main(String[] args) {
		SpringApplication.run(PasswordOauthClientApplication.class, args);
		
	}
}