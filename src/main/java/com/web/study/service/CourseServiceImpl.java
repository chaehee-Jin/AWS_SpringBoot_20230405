package com.web.study.service;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRespository;
	
	
	@Override
	public void registeCourse(CourseReqDto courseReqDto) {
		courseRespository.saveCourse(courseReqDto.toEntity());
		
	}

}
