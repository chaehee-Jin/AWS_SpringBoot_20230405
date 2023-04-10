package com.web.study.controller.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.lecturer.LecturerReqDto;
import com.web.study.service.LecturerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LecturerController {

	private final LecturerService lecturerService;

	@PostMapping("/lecturer")
	public ResponseEntity<? extends ResponseDto> registeLecturer(@RequestBody LecturerReqDto lecturerReqDto) {

		lecturerService.registeLecturer(lecturerReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}

	//강사전체 조회
	@GetMapping("/lecturers")
	public ResponseEntity<? extends ResponseDto> getLectures() {

		return ResponseEntity.ok().body(DataResponseDto.of(lecturerService.getLecturerAll()));
	}

	// 강사 아이디로  선택한 아이디만 찾기
	@GetMapping("/lecturer/{id}")
	public ResponseEntity<? extends ResponseDto> getLecturesById(@PathVariable int id) {

		return ResponseEntity.ok().body(DataResponseDto.of(lecturerService.findLecturerById(id)));
	}

}
