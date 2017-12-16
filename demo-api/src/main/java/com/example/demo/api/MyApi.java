package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApi {

	@GetMapping(path="hello")
	public String sayHello() {
		return "hello from demo-eureka-client2 service";
	}
}
