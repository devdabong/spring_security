package com.sample.spring.service;

import java.util.List;

import com.sample.spring.model.LoginVO;

public interface LoginService {
	
	List<LoginVO> selectUserList(LoginVO vo);
}
