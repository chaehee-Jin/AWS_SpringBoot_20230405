package com.web.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Lecturer;
import com.web.study.dto.request.lecturer.LecturerReqDto;
import com.web.study.repository.LecturerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {

	private final LecturerRepository lecturerRepository;

	@Override
	public void registeLecturer(LecturerReqDto lecturerReqDto) {

		lecturerRepository.saveLecturer(lecturerReqDto.toEntity());

	}
	
	@Override
	public List<Lecturer> getLecturerAll() {
		
		return lecturerRepository.getLecturerAll();
	}

	@Override
	public Lecturer findLecturerById(int id) {
		
		return lecturerRepository.findLecturerById(id);
	}

}
