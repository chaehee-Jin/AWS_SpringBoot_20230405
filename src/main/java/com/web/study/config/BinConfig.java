package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.study.IocAndDi.TestC;

@Configuration
//기능을 등록하려면 configuration에만 등록
//new를 계속하면 계속 스레드가 생성되어서 bean에다가 등록
public class BinConfig {
	
	@Bean
	public TestC testC() {
		return new TestC();
		
	}
	

}
