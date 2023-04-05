package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto;

@RestController
public class BasicRestController {

	// Get 요청의 param을 처리하는 방법
	// 원래는 key값과 param에 매개변수를 적어주어야함 , 생략하려면 key값이 변수명이 되어야함
	@GetMapping("/read")
	// 제네릭이라 responseDto에는 어떠한 값이든 사용이 가능하다
	// 상속받은 것들만 제네릭으로 사용가능

	// BasicTestDto 이것은 put, delete만 가능
	public ResponseEntity<? extends ResponseDto> read(BasicTestDto basicTestDto) {

		String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";

		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));

	}

	@GetMapping("/read2/{id}")
	// @PathVariable 이것은 무조건 있어야한다
	// PathVariable는 post, put, delete전부 다됨
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id) {
		Map<Integer, String> userMap = new HashMap<>();
		userMap.put(1, "heehee");
		userMap.put(2, "haha");
		userMap.put(3, "hoho");
		userMap.put(4, "heeee");
		userMap.put(5, "haho");

		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));

	}

	// post요청의 데이터 처리
	@PostMapping("/create")
	public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto) {
		System.out.println("데이터 추가");
		

		return ResponseEntity.created(null).body(DataResponseDto.of( basicTestDto));
	}

}
