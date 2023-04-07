package com.web.study.IocAndDi;

import org.springframework.stereotype.Component;

@Component ("t1")
// 클래스 자체가 부품으로서 container에 들어가있움
// 컴포넌트를 적어줘야 같은 인터페이스로 인식, 가져다 쓸수 있음
//component에서 controller, service component, repositroy component, config 4가지가 있다
//이것들은 다룬순간에 적용이된다
//config는 설정을 다룬다. 여기에는 2개이상의 bean을 등록할수 있다
// 다른 것들은 1개의 bean만 등록이 가능하다
public class TestA implements Test {

	@Override
	public void printTest() {
		System.out.println("TestA 클래스");
	}
}
