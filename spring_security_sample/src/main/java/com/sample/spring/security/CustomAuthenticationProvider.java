package com.sample.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.sample.spring.model.LoginVO;
import com.sample.spring.service.LoginService;


public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private LoginService loginService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String user_id = (String)authentication.getPrincipal();
		String user_pw = (String)authentication.getCredentials();
		
		logger.info("Welcome authenticate! {}", user_id + "/" + user_pw);
		
//		DB 연동 전 로그인 시 바로 권한 부여 테스트
//		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
//		result.setDetails(new CustomUserDetails(user_id, user_pw));
		
		
		LoginVO param = new LoginVO();
		param.setUserId(user_id);
		param.setUserPwd(user_pw);
		
		Authentication result = null;
		
		try {
			result = loginService.selectLogin(param);
		
		} catch (LockedException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Authentication error!!", e);
		}
		
		if (result == null) {
			throw new BadCredentialsException("Bad credentials");
		} else {
			logger.info("Authentication success!!");
			logger.info(result.getPrincipal() + "");
		}
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
