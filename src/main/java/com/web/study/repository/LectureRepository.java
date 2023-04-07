package com.web.study.repository;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecture;

//insert, delete, update만 안적어줘도 됨 (resert타입이 없음
//my 어쩌구는 $가 아니라 #이다
//매개변수는 무조건 하나이다 #이라고 붙이면 참조한다는 뜻이다, private는 가져올수 없으므로 getter가 필요하다
@Mapper
public interface LectureRepository {
	public int registe(Lecture lecture);

}
