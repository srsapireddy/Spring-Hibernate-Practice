package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

// 390
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// 391
		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		// adding users and doing all of the security configuration
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("MANAGER"))
		.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
		
		
	}

	// 397
	// 408
    // Override the configure method that takes the http security.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Configure security of web paths in application, login, logout etc
		// authorizeRequests() --> Restrict access based on the HttpServletRequest
		// .anyRequest().authenticated() --> Any request to the app must be authenticated (ie logged in)
		// .formLogin() --> Customizing the form login process
		// .loginPage("/showMyLoginPage") --> Show our custom form at the request mapping
		// .loginProcessingUrl("/authenticateTheUser") --> Login form should POST data to this URL for processing (check user id and password)
		// .permitAll(); --> Allow everyone to see login page. No need to be logged in.
		// .and().logout().permitAll(); -> Add logoit support
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().logout()
		.permitAll();
	}
}
