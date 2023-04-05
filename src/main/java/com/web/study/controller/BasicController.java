package com.web.study.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;
// controller는 view를 무조건 리턴 , restcontroller는 데이터를 응답하는 용도

@RestController // restcontroller 을 사용하면 항상 responsebody를 붙이고 있다
public class BasicController {
	//responsebody을 붙여주면 controller인데 오류가 안나고 정상적으로 작동 , controller혼자 쓰면 ViewResolver로 전달 돼서 오류남
	@GetMapping("/view/test")
	public ResponseEntity < ? extends ResponseDto> view() { //업케스팅
		
		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		
		
		if(strList.contains("e")) {
			try {
				throw new RuntimeException("오류났음");
			}catch(Exception e) {
				return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e));
			
			}
		}
		return ResponseEntity.ok().body(DataResponseDto.of(strList));
		
		
	}

}
