package com.web.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.study.IocAndDi.IocTest;
import com.web.study.IocAndDi.TestB;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
//		iocAndDiTest();
	}

//	public static void iocAndDiTest() {
//Inversion Of Control = 제어의 역전
//Ioc= Di를 자동화하는 것 , 조립을 알아서 해줌
//생성될때 매개변수로 다른것을 넣어주겠다(= 생성하는 시점에서 부품을 선택
//Ioc Container이 필요 , 여기에다가 저장, 여기에 이부품이 들어가야한다라는 것을 정의하는 것이 필요	연결할수 있게 container에 만들어서 넣어놓아야함 
//	의존성과 결합도를 낮추기 위하여 외부에서 주입하는 것 수정을 할때 여기의 코드가 바뀌는 것이 아니라 외부에서 어떤 것을 넣어 줄때 선택

//		IocTest iocTest = new IocTest(new TestB());
//		iocTest.run();
//	}

}
