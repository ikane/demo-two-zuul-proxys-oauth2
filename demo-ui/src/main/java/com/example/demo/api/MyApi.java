package com.example.demo.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyApi {
	
	@Autowired
	private LoadBalancerClient restClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

	@GetMapping(path="hello")
	public Map<String, Object> sayHello() {
		return Collections.singletonMap("hello", "hello from demo-eureka-client service");
	}
	
	@GetMapping(path="hello2")
	public Map<String, Object> sayHello2() {
		
		ServiceInstance zuul2Instance = restClient.choose("zuul2");
		
		String uri = zuul2Instance.getUri().toString() + "/client2/hello";
		//this.restTemplate.exchange(zuul2Instance.getUri().toString() + "/client2/hello", HttpMethod.GET, null, String.class, null);
		String response = this.restTemplate.getForObject(uri, String.class, new HashMap<>());
		
		return Collections.singletonMap("hello", response);
	}
}
