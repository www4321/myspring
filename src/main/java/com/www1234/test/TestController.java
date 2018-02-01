package com.www1234.test;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.www1234.dao.User;
import com.www1234.dao.UserService;


@Controller
public class TestController {
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	@Resource  
    private UserService userService;
	
	@GetMapping(value="/welcome")  
	public ModelAndView  welcomeHandler(Model model) {  
		
		
		List<User> user= userService.doGetUser(1);
		if(user!=null)
			log.info("user infrormation : [ name:"+user.get(0).getName()+",age:"+user.get(0).getAge()+"]");
		else log.info("no user infrormation");
	    model.addAttribute("name", "freemaker");
		model.addAttribute("message", "Hello World!");
		return new ModelAndView("test");
	}
	@GetMapping(value="/welcomejsp")  
	public ModelAndView  welcomeJsp(Model model) {  
		
		log.info(".........Jsp File");
	    model.addAttribute("name", "freemaker");
		model.addAttribute("message", "Hello World!");
		return new ModelAndView("login");
	}
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value= "/test")
	public String testJson(){
		log.info("process test process");
		return "www1234";
	}
}
