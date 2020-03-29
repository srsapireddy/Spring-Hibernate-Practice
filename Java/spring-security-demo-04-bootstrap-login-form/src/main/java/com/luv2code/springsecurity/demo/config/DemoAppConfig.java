package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Gives similar functionality to <mvc:annotation-driven>
@ComponentScan(value="com.luv2code.springsecurity.demo") // Which package to scan to look out for controller, services and support classes 
public class DemoAppConfig {

	// 382
	// define a bean for ViewResolver
	// viewResolver --> Spring will know where to look for the file (what ever the view name is and .jsp)
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
}
