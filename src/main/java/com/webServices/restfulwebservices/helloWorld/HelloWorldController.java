package com.webServices.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	// @GetMapping(path="/hello-world")
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String getHelloWorld() {
		return "Hello World New";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean getHelloWorldBean(@PathVariable String name) {
		return new HelloWorldBean("Hello World Bean " + name);
	}

	@GetMapping(path = "/hello-world-internationalized")
	public String getHelloWorldInternationalized(
			//@RequestHeader(name = "Accept-Language", required = false) Locale locale
			) {
		// en = Good Morning
		// fn = Bonjour
		// nl = Goede Morgen

		//return messageSource.getMessage("good.morning.message", null, "Default Good Morning", locale);
		return messageSource.getMessage("good.morning.message", null, "Default Good Morning", LocaleContextHolder.getLocale());
	}
}
