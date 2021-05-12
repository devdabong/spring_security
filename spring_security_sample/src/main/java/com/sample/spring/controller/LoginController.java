package com.sample.spring.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sample.spring.security.CustomUserDetails;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("login")
	public void login(HttpSession session) {
		logger.info("Welcome login! {}", session.getId());
	}
	
	@GetMapping("logout")
	public void logout(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
		
		logger.info("Welcome login! {}, {}", session.getId(), userDetails.getUsername());
		
		session.invalidate();
	}
	
	@GetMapping("loginSuccess")
	public void loginSuccess(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		logger.info("Welcome login! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
	}
	
	@GetMapping("page1")
	public void page1() {
	}
	
}
