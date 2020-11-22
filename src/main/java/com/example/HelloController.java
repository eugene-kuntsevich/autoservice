package com.example;


import org.apache.commons.collections4.collection.CompositeCollection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		CompositeCollection<String> collection = new CompositeCollection<>();
		return "Greetings from Spring Boot!";
	}
}
