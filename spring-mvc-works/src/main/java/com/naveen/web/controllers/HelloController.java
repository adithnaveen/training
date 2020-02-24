package com.naveen.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello-mvc")
	public String sayHi() {
// 		return "/WEB-INF/pages/hello.jsp"; 
		// after having internal view resolver
		return "hello"; 
	}
}
