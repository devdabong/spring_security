package com.sample.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring.dao.LoginDAO;
import com.sample.spring.model.LoginVO;
import com.sample.spring.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
		
	@Autowired
	LoginDAO loginDao;
	
	@Override
	public List<LoginVO> selectUserList(LoginVO vo) {
		return loginDao.selectUserList(vo);
	}

}
