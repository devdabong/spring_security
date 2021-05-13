package com.sample.spring.service;

import org.springframework.security.core.Authentication;

import com.sample.spring.model.LoginVO;

public interface LoginService {
	
	//스프링 시큐리티 없이 DB 연동 시 
	//List<LoginVO> selectUserList(LoginVO vo);
	
	/**
	 * 스프링 시큐리티 로그인
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public Authentication selectLogin(LoginVO vo) throws Exception;

}
