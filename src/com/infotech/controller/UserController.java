package com.infotech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.User;
//https://www.youtube.com/watch?v=Xd2k0oTuT7I&list=PLzS3AYzXBoj9nn2k3AWoIqt13C9Lzdtmr&index=13
@Controller
public class UserController {

	@RequestMapping(value = "/user", method= RequestMethod.GET)
	public ModelAndView getUser()
	{
		return new ModelAndView("/user", "userviewname" , "objectValue");
	}
	
	@RequestMapping(value = "/userSave", method= RequestMethod.POST)
	public ModelAndView saveUser(User user)
	{
		return new ModelAndView("/userSave", "userSaveviewname" , "objectValue");
	}
	
	@RequestMapping(value = "/userDelete", method= RequestMethod.GET)
	public ModelAndView deleteUser(User user)
	{
		return new ModelAndView("/userDelete", "userDeleteviewname" , "objectValue");
	}
	
	@RequestMapping(value = "/welcome/{user}/{age}", method = RequestMethod.GET)
	public ModelAndView getWelcomeMessage(@PathVariable(value = "user") String user,
			@PathVariable(value = "age") int age, @RequestParam(value = "country", required = false) String country)
	{
		return new ModelAndView("welcomePage","welcomeMessageuser",user + ": " + age + " :" + country);
		
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registerPage()
	{
		return "register";
	}
	
	@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public ModelAndView registerSuccess(@RequestParam("name") String userName,@RequestParam("country") String country,@RequestParam(required=false,name="email") String email,@RequestParam(name="age") int age)
	{
		User user = new User(userName, age, email, country);
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
	
	
	
	}
