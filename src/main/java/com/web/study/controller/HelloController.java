package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	// get 요청이다
	@GetMapping("/hello")
	//hello라는 메소드를 만들었음 
	public Map<String, String> hello(String name){
		
		
		Map<String, String> testMap = new HashMap<>();
		testMap.put("name", name);
		testMap.put("age", "25");
		testMap.put("address", "영국호그와트");
		return testMap;
		
	}
	

}
