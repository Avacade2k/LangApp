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
	
	@GetMapping(path = "/translate")
	public String Translator(String word, 
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		try {
			return messageSource.getMessage(word+".message", null, locale);
			}
		catch(Exception e) {
			return "Can not be found";
			}
	}
	
	@GetMapping(path = "/translate/add/{name}&{translate}")
	public String expandApi(@PathVariable String name, String translate) {
		return ("Expanding API with: "+ name);
	}
	
}