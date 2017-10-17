package com.springmvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.H5UsersService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="h5UsersService")
	private H5UsersService service;
	
	@RequestMapping(value="/manager",method=RequestMethod.GET)
	public ModelAndView hello2(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloMVC");
		mv.setViewName("users");
		return mv;
	}

	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public ModelAndView count(){
		
		int c = service.userCount();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", c);
		mv.setViewName("users");
		return mv;
	}
}


