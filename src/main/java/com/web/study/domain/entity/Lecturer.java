package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.LecturerRespDto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Lecturer {
	private int id;
	private String name;
	private LocalDate birth_date;
	// 카멜 표기법 문제 해결방법
	// responseDto객체를 만드는 방법과 xml에서 as을 만드는 방법이 있음
	// repository에서 return 이 2번 일어나는 경우가 생김 (return 자료형은 1개밖에 쓰지 못함), response는 재사용
	// 불가 -> dto만드는 것이 더 좋은 이유

	public LecturerRespDto toDto() {
		return LecturerRespDto.builder()
				.id(id)
				.name(name).
				birthDate(birth_date).
				build();
	}

}
