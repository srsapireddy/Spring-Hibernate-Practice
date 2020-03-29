package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// To show the custom login form
@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage") // Based on the information from the spring security configuration file
	public String showMyLoginPage() {
		return "plain-login"; // View name (/WEB-INF/view/plain-login.jsp)
	}
	
}
