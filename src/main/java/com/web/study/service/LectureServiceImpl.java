package com.web.study.service;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Lecture;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.repository.LectureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
	//  final을 다는 이유: final => 상수: 초기화가 무조건 일어나야함 
	// 초기화를 할때 매개변수로 받아다가 초기화하는 방법이 있었음  = @RequiredArgsContrutor, 무조건 값이 들어와야함 (강제성)
	private final LectureRepository lectureRepository;

	@Override
	public void registeLecture(LectureReqDto lectureReqDto) {
		// Dto ->Entity로 변환
		Lecture lecture = lectureReqDto.toEntity();
		System.out.println("변환:" + lecture);
		lectureRepository.registe(lecture);
	}

}
