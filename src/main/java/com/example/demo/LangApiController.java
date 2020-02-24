package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//Controller
@RestController
public class LangApiController {
	@Autowired
	private MessageSource messageSource;


	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}


//passing a path variable 
//hello-world/path/ASTRING
	@GetMapping(path = "/hello-world/path/{name}")
	public String helloWorldPathVariable(@PathVariable String name) {
		return ("Hello World"+ name); 
	}

//I18N 
	@GetMapping(path = "/hello-world-I18N")
	public String helloWorldInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("hello.world.message", null, locale);
	}
}