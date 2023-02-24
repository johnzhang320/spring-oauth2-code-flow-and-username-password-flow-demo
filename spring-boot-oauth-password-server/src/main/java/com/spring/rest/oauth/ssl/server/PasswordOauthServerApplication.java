package com.spring.rest.oauth.ssl.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class PasswordOauthServerApplication extends SpringBootServletInitializer {
	//server.port=8084
	//localhost:8084/spring-boot-oauth-password-server/oauth/token
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PasswordOauthServerApplication.class);
	}
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PasswordOauthServerApplication.class, args);
    }
}