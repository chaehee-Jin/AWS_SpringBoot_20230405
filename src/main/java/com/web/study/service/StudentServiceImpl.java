package com.web.study.service;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;

	@Override
	public void registeStudent(StudentReqDto studentReqDto) {
		
		studentRepository.saveStudent(studentReqDto.toEntity());

	}

}
