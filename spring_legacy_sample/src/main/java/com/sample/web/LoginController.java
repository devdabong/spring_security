package com.sample.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/all")
	public String login(HttpServletRequest request, ModelMap model) throws Exception{
		
		String requestMapping = FilenameUtils.removeExtension(request.getServletPath());
		
		System.out.println("매핑 : " + requestMapping);
		System.out.println("매핑 : " + requestMapping.substring(1));
		
		return requestMapping.substring(1); 
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
	
}
