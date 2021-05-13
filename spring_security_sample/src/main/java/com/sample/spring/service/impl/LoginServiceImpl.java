package com.sample.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.sample.spring.dao.LoginDAO;
import com.sample.spring.model.LoginVO;
import com.sample.spring.security.CustomUserDetails;
import com.sample.spring.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
		
	@Autowired
	private LoginDAO loginDao;

	//스프링 시큐리티 없이 DB 연동 시
//	@Override
//	public List<LoginVO> selectUserList(LoginVO vo) {
//		return loginDao.selectUserList(vo);
//	}
	
	
	@Override
	public Authentication selectLogin(LoginVO vo) throws Exception {
		
		Authentication authentication = null;
		
		LoginVO userInfo = loginDao.selectLogin(vo);
		
		if (userInfo == null) {
			System.out.println("user null");
		} else {
			
			// CustomUserDeatils 사용한 코드
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			authentication = new UsernamePasswordAuthenticationToken(vo.getUserId(), vo.getUserPwd(), roles);
			((UsernamePasswordAuthenticationToken) authentication).setDetails(new CustomUserDetails(vo.getUserId(), vo.getUserPwd()));
			
			System.out.println("로그인 성공");
			
			// CustomUserDeatils 사용하지 않고, LoginVO 이용한 코드
//			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//			authentication = new UsernamePasswordAuthenticationToken(vo.getUserId(), "", roles);
//			((UsernamePasswordAuthenticationToken) authentication).setDetails(userInfo);
		}
		
		return authentication;
	}

}
