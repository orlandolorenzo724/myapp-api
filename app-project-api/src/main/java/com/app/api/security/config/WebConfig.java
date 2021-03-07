package com.app.api.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("unused")
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/users/**").permitAll()
			.antMatchers("/login").permitAll()
			.and()
			.formLogin()
//			.defaultSuccessUrl("/users/test")
//			.failureUrl("/users/fail")
		;
	}
}
