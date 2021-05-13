package com.sample.spring.dao;

import org.springframework.stereotype.Repository;

import com.sample.spring.model.LoginVO;

@Repository
public interface LoginDAO {
	
	public LoginVO selectLogin(LoginVO vo) throws Exception;
}
