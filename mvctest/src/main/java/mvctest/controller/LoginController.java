package mvctest.controller;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvctest.model.User;
import mvctest.service.MvctestService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	String message = "Welcome to Spring MVC";
	String error ="用户名或密码不正确！";
	ModelAndView mv = null;
	/*
	@RequestMapping("/login.do")
	private ModelAndView handleRequest(@RequestParam(value="username",required=false)String username) {
		
		if(username!=null&&username.equals("wangdechang")){
			
			System.err.println("登陆成功！============");
			mv = new ModelAndView("Helloworld");
//			mv.setViewName("登陆成功！");
			mv.addObject("message", message);
			mv.addObject("username", username);
		}else{
			System.err.println("登陆失败！============");
			mv = new ModelAndView("error");
			mv.addObject("error", error);
			
		}
		return mv;
	}
	*/
	@RequestMapping("/login.do")
	private ModelAndView handleRequest(@RequestParam(value="username",required=false)User user) {
		
		String username = user.getUserName();
		
		if(username!=null&&username.equals("wangdechang")){
			
			System.err.println("登陆成功！============");
			mv = new ModelAndView("Helloworld");
//			mv.setViewName("登陆成功！");
			mv.addObject("message", message);
			mv.addObject("username", username);
		}else{
			System.err.println("登陆失败！============");
			mv = new ModelAndView("error");
			mv.addObject("error", error);
			
		}
		return mv;
	}
	
}
