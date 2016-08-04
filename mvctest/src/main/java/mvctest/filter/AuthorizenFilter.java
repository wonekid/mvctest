package mvctest.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvctest.model.User;

public class AuthorizenFilter {
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws Exception{
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;
		
		HttpSession session = rq.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user == null){
			String uri = rq.getRequestURI();
			//如果请求的是登陆页，则不跳转
			if(uri.equalsIgnoreCase("/mvctest/index.jsp")){
				chain.doFilter(request, response);
				
			}else {
				rp.sendRedirect("/mvctest/index.jsp");
			}
		}else {
			chain.doFilter(request, response);
		}
		
		
	}
}
