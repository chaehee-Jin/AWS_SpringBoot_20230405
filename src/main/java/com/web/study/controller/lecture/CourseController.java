package com.web.study.controller.lecture;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.aop.annotation.CheckNameAspect;
import com.web.study.aop.annotation.ParamsAspect;
import com.web.study.aop.annotation.TimerAspect;
import com.web.study.aop.annotation.ValidAspect;
import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.request.course.SearchCourseReqDto;
import com.web.study.exception.CustomException;
import com.web.study.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseController {

	private final CourseService courseService;

	@PostMapping("/course")
	public ResponseEntity<? extends ResponseDto> registeCourse(@RequestBody CourseReqDto courseReqDto) {
		courseService.registeCourse(courseReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}

	@CheckNameAspect
	@TimerAspect
	@GetMapping("/courses")
	public ResponseEntity<? extends ResponseDto> getCourseAll() {

		return ResponseEntity.ok().body(DataResponseDto.of(courseService.getCourseAll()));
	}

	@ValidAspect
	@ParamsAspect
	@GetMapping("/search/courses")
	public ResponseEntity<? extends ResponseDto> searchCourse(@Valid SearchCourseReqDto searchCourseReqDto,
			BindingResult bindingResult) {
		//객체와 함께 업캐스팅으로 들고와졌음 
		//bindingResult 이것은 interface, interface는 생성을 못하니 다른 객체가 들어옴 그게 나타난 것이  BeanPropertyBindingResult

//		if (bindingResult.hasErrors()) {
//			Map<String, String> errorMap = new HashMap<>();
//
//			bindingResult.getFieldErrors().forEach(error -> {
//				errorMap.put(error.getField(), error.getDefaultMessage());
//
//			});
//
//			throw new CustomException("유효성 검사 실패", errorMap);
//		}

		return ResponseEntity.ok().body(DataResponseDto
				.of(courseService.searchCourse(searchCourseReqDto.getType(), searchCourseReqDto.getSearchValue())));
	}
}
