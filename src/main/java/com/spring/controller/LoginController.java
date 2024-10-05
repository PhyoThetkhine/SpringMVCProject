package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.LoginBean;
import com.spring.model.UserBean;
import com.spring.repository.UserRepository;




@Controller
public class LoginController {
	
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping(value = "/")
	public ModelAndView showLogin() {
		return new ModelAndView("login","loginObj",new LoginBean());
	}
	
	 @PostMapping(value = "/login")
	  public String doLogin(@ModelAttribute("loginObj") LoginBean bean ,Model m,HttpSession session) {
	    
	    boolean result= repo.checkEmail(bean.getEmail());
	    if(result) {
	      
	      UserBean obj= repo.loginUser(bean);
	      if(obj == null) {
	        m.addAttribute("error", "Incorrect Password!!!");
	        return "login";
	      }else {
	        session.setAttribute("email", obj.getEmail());
	        
	        if(obj.getRole().equals("admin")) {
	          
	          return "adminview";
	        }else {
	          
	          return "welcome";
	        }  
	    }
	}
	    return "login";
}
}
