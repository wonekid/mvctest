package mvctest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.SysexMessage;

import mvctest.dao.GradeDao;
import mvctest.dao.UserDao;
import mvctest.model.Grade;
import mvctest.model.User;
import mvctest.service.IMvctestService;
import mvctest.service.impl.MvctestServiceImpl;
import mvctest.service.impl.UserServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


@Controller
public class LoginController {
	String message = "Welcome to Spring MVC";
	String error ="用户名或密码不正确！";
	ModelAndView mv = null;
	UserServiceImpl userService = new UserServiceImpl();
	MvctestServiceImpl mvService = new MvctestServiceImpl();
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
	@RequestMapping(value="/login.do",method=RequestMethod.POST) //从页面传入Controller参数的两种方法：1.通过@RequestParam 传递单个参数。2.通过ModelAttribute传递一个对象
	private ModelAndView handleRequest( @ModelAttribute("user") User user,HttpSession session) throws Exception {
//		userService.getUserDao();
//		UserService service = new MvctestService();
//		user.setUserName(username);
		String username = user.getUsername();
		String userpass = user.getUserpass();
		System.err.println(username+"\t"+userpass);
		List<Map<String,User>> list=userService.selectUser(user);
//		List<Map<String, Grade>> grade = mvService.selectGrade(list);
		GradeDao dao = new GradeDao();
		List<Map<String, Grade>> grade = null;
		
		String uname = null;
		String upass = null;
		for (int i=0;i<list.size();i++) {
			uname = String.valueOf(list.get(i).get("username"));
			upass = String.valueOf(list.get(i).get("userpass"));
			System.err.println("页面传入+++++++++++"+username+"\t"+userpass);
			System.err.println("数据库数据+++++++++++"+uname+"\t"+upass);
			if(uname.equals(username)&&upass.equals(userpass)){
				
				System.err.println("登陆成功！============");
				grade = dao.select(list) ;
				
				mv = new ModelAndView("Helloworld");
				
//			mv.setViewName("登陆成功！");
				mv.addObject("message", message);
				mv.addObject("username", username);
				mv.addObject("grade",grade);
				System.err.println("Controller"+grade);
				break;
			}else{
				System.err.println("用户名或密码不正确！============");
				mv = new ModelAndView("login");
				mv.addObject("error", error);
				
				
			}
		}
		return mv;
	}
	@RequestMapping(value="")
	public ModelAndView handleRequest(){
		return mv;}
}
