package com.sample.spring.dao;

import java.util.List;

import com.sample.spring.model.LoginVO;


public interface LoginDAO {
	
	List<LoginVO> selectUserList(LoginVO vo);
}
