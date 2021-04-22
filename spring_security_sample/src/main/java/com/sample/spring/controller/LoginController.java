package com.sample.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/all")
	public String loginAll(HttpServletRequest request, ModelMap model) throws Exception{
		
		String requestMapping = FilenameUtils.removeExtension(request.getServletPath());
		
		System.out.println("매핑 : " + requestMapping);
		System.out.println("매핑 : " + requestMapping.substring(1));
		
		if(request.isUserInRole("ROLE_USER")) {
			return "redirect:/";
		} else {
			return "login/login";
		} 
		 
	}
	
	@RequestMapping("/admin")
	public String loginAdmin(HttpServletRequest request, ModelMap model) throws Exception{
		
		String requestMapping = FilenameUtils.removeExtension(request.getServletPath());
		
		System.out.println("매핑 : " + requestMapping);
		System.out.println("매핑 : " + requestMapping.substring(1));
		
		return requestMapping.substring(1); 
	}
	
	@RequestMapping("/member")
	public String loginMember(HttpServletRequest request, ModelMap model) throws Exception{
		
		String requestMapping = FilenameUtils.removeExtension(request.getServletPath());
		
		System.out.println("매핑 : " + requestMapping);
		System.out.println("매핑 : " + requestMapping.substring(1));
		
		return requestMapping.substring(1); 
	}
	
	@RequestMapping("/login")
	public String loginCustom(HttpServletRequest request, ModelMap model) throws Exception{
		
		String requestMapping = FilenameUtils.removeExtension(request.getServletPath());
		
		if(request.isUserInRole("ROLE_USER")) {
			return "redirect:/";
		} else {
			return requestMapping.substring(1); 
		}
	} 
	
	/**
	 * 로그인 실패
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/loginFailure")
	public String loginFailure(HttpServletRequest request, ModelMap model) throws Exception {
		//String resultCode = ResponseUtil.RESULT_CODE_SUCESS;
		String resultCode = "0001";
		String requestResultCode = (String) request.getAttribute("resultCode");
		
		if (!StringUtils.isEmpty(requestResultCode)) {
			resultCode = requestResultCode;
		}
		
		model.addAttribute("resultCode", resultCode);
		
		return "login/login"; 
	}   
}
