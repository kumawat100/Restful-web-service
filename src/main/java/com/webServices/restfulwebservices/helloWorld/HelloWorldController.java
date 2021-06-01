package com.webServices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//@GetMapping(path="/hello-world")
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String getHelloWorld() {
		return "Hello World New";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean getHelloWorldBean(@PathVariable String name) {
		return new HelloWorldBean("Hello World Bean " + name);
	}
}
