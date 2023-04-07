package com.web.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.IocAndDi.IocTest;
import com.web.study.IocAndDi.IocTest2;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // 호환되는 부품이 하나만 존재할때 사용
public class IocTestController {

//	@Autowired //자동으로 주입 ,객체가 여러가지 있을때 차별을 줄때 사용
//private final IocTest iocTest;
//@Autowired
//	private final IocTest2 iocTest2;

//final을 붙여주면 이것은 이 부품이 무조건 필수라는 의미이다
	// 생성이될때 매개변수, 즉 객체가 필요하다
	//생성과 주입자체를 부품을 기준으로 container가 함 
	private final IocTest iocTest;
	private final IocTest2 iocTest2;
	

	@GetMapping("ioc/test")
	public Object test() {
		iocTest.run();
		iocTest2.run();
		return null;
	}
}
