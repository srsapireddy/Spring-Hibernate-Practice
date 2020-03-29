package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 384
@Controller
public class DemoController {

	@GetMapping("/") // for home page
	public String showHome() {
		return "home";
	}
}
