package com.web.study.service;

import com.web.study.dto.request.auth.RegisteUserReqDto;

public interface AuthService {
	
	public void registeUser(RegisteUserReqDto registeUserReqDto);
	
	public void duplicatedUsername(RegisteUserReqDto registeUserReqDto); //중복검사

	
	
	
	

}
