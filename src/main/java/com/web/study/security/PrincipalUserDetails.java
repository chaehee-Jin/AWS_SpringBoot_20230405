package com.web.study.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
//데이터 베이스들의 정보를 다시 한번 PrincipalUserDetails 으로 변환 
public class PrincipalUserDetails  implements UserDetails{
	

	private static final long serialVersionUID = 1L;
	
	//필수적으로 들어가야하는 정보들 
	private int userId;
	private String username;
	private String password;
	private List<String> roles;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(role ->{
			authorities.add(new SimpleGrantedAuthority(role));
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
	
		return username;
	}

	//사용기간 만료, 이중에서 하나라도  false면 로그인이  안됨 
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	//계정을 잠궈버림 
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	//비밀번호가 5회 틀렸을때
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정 비활성 상태(이메일 인증을 완료해야하거나, 전화번호 인증을 하지 않았을 때)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
