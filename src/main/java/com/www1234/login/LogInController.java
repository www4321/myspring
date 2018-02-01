package com.www1234.login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LogInController {
	private static Logger log = LoggerFactory.getLogger(LogInController.class);
    /** 
     * @param session  HttpSession 
     * @param username 
     * @param password 
     * @return 
     */  
    @RequestMapping(value="/login")  
    public String login(HttpSession session,@RequestParam("username") String username,@RequestParam("password") String password,Model model) throws Exception{    
    	log.info("username:"+username+", password:"+password);
        session.setAttribute("username", username);  
        model.addAttribute("name", "freemaker");
		model.addAttribute("message", "Hello World!");
        return "test";   
    }  
   
    /** 
     * @param session Session 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping(value="/logout")  
    public String logout(HttpSession session) throws Exception{   
        session.invalidate();  
        return "login";  
    }  
}
