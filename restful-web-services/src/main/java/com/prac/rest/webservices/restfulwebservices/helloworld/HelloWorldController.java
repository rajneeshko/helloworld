package com.prac.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * To define a controller for rest service, we need to -
 * <ul>Annotate a class to make it a rest controller</ul>
 * <ul>Define a method to map the HTTP Method and Path</ul>
 * 
 * @author rajkochh
 *
 */

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping(path="/greet")
	public String greet() {
		return "Greetings !!!!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HellowWorld Bean");
	}

	@GetMapping(path="/hello-world-bean-internationalized")
	public String helloWorldBeanI18N() {
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path="/hello-world-bean/{string}")
	public HelloWorldBean helloWorldBeanWithPath(@PathVariable String string) {
		return new HelloWorldBean(String.format("HellowWorld Bean %s", string));
	}
}
