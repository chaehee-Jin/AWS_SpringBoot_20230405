package com.web.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecturer;

@Mapper
public interface LecturerRepository {
	public int saveLecturer(Lecturer lecturer);
	public List<Lecturer> getLecturerAll();
	//하나만이라 리스트가 아님 
	public Lecturer findLecturerById(int id);
	

}
