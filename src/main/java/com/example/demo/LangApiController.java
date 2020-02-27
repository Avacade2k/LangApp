package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
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
	
	//Translating the searched word
	@GetMapping(path = "/translate", produces = MediaType.APPLICATION_JSON_VALUE)
	public String Translator(String word, 
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		try {
			return messageSource.getMessage(word+".message", null, "Word can not be found", locale); //returns translation
			}
		catch(Exception e) {
			return "Something went wrong";
			}
	}
	
	//Adding new words to properties
	@GetMapping(path = "/translate/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public String expandApi(String name, String translate) {
		LangApiMain.appendPropertiesEng(name, name); //updating properties
		LangApiMain.appendPropertiesSwe(name, translate); //updating properties_se
		return ("Expanding API with: "+ name);
	}
		
}