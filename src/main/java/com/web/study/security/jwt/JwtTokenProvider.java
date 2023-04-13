package com.web.study.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.security.PrincipalUserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component

public class JwtTokenProvider {

	private final Key key;

	// 가장 중요한 키 , 다른 곳에 유출되면 안됨
	public JwtTokenProvider(@Value("${jwt.secretKey}") String secretKey) {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);

	}

	public JwtTokenRespDto createToken(Authentication authentication) {
		StringBuilder authoritiesBuilder = new StringBuilder();
		
		authentication.getAuthorities().forEach(grantedAuthority ->{
			authoritiesBuilder.append(grantedAuthority.getAuthority());
			authoritiesBuilder.append(",");
		});
		
		authoritiesBuilder.delete(authoritiesBuilder.length() - 1, authoritiesBuilder.length());
		
		//문자열 변환 
		String authorities = authoritiesBuilder.toString();
		
		//현재시간 가져오기 
		long now = (new Date()).getTime();
		
		//1000 == 1초, 탈취당할 위험이 있어서 길게 시간을 주지 않음 
		Date tokenExpriesDate = new Date(now + (1000 * 60 * 30 )); //토큰 만료 시간 
		
		PrincipalUserDetails userDetails = (PrincipalUserDetails) authentication.getPrincipal();
		
		String accessToken = Jwts.builder()
				.setSubject(authentication.getName())
				.claim("userId", userDetails.getUserId())
				.claim("auth", authorities)
				.setExpiration(tokenExpriesDate)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
		
		return JwtTokenRespDto.builder()
				.grantType("Bearer")
				.accessToken(accessToken)
				.build();
		
	

	}

}
