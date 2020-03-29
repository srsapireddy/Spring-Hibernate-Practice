package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Pure java configuration
@EnableAspectJAutoProxy // Spring AOP Proxy Support for calling the objects using proxys
@ComponentScan("com.luv2code.aopdemo") // Where to go and scan spring beans or components
public class DemoConfig {

}
