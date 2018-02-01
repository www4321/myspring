package com.www1234.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LogInInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(LogInInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	    String url = request.getRequestURI();
        if (url.indexOf("/login")>=0) {
             return true;
        } else {
             HttpSession session = request.getSession();
             log.info("login interceptor url:"+url);
             String user =  (String) session.getAttribute("username");
             log.info("session:"+user);
             if (user != null) {
                 return true;
             }
        }
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
	}
	
}
