package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.UserBean;
import com.spring.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping(value = "/register")
	public ModelAndView sowRegister() {
		return new ModelAndView("Register","userobj",new UserBean());
	}
	
	@PostMapping(value="/insert")
	public String doRegister(@ModelAttribute("userobj") UserBean userBean,Model model) {
		
		int i =	repo.insertUser(userBean);
		
		if(i>0) {
			return "login";
			
		}else {
			model.addAttribute("error","Insert Error");
			return "Register";
					}
		

			
			
		
		
	}

}
