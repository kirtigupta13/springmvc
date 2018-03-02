package com.infotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.service.HelloService;
//http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
@Controller
@RequestMapping(value="/app")
public class HelloworldController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("welcomePage", "welcomeMessage", helloService.getModelObject());
	}
	
	@RequestMapping(value = "/second" , method=RequestMethod.GET)
	public ModelAndView welcome2(){
		return new ModelAndView("welcomePage", "welcomeMessage", "this is second method" );
	}
}
