package com.web.study.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
//요청은 setter, 응답은 getter가 필요함 
public class LecturerRespDto {
	private int id;
	private String name;
	private LocalDate birthDate;
	

}
