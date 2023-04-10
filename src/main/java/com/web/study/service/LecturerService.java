package com.web.study.service;

import java.util.List;

import com.web.study.domain.entity.Lecturer;
import com.web.study.dto.request.lecturer.LecturerReqDto;

public interface LecturerService {
	
	public void registeLecturer(LecturerReqDto lecturerReqDto);
	public List<Lecturer> getLecturerAll();
	public Lecturer findLecturerById(int id);

}
