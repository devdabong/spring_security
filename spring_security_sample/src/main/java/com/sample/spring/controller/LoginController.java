package com.sample.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.spring.model.LoginVO;
import com.sample.spring.service.LoginService;

@Controller
public class LoginController {
		
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		
		LoginVO vo = new LoginVO();
		vo.setUserId("jj");
		vo.setUserPwd("1234");
		
		List<LoginVO> list = loginService.selectUserList(vo);
		
		model.addAttribute("userList", list);
		
		return "login";
	}
}
