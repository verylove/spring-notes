package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application {

	@RequestMapping("/index")
	public String index() {
		return "Hello Maven Docker ";
	}
}
