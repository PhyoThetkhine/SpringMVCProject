package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.BookBean;
import com.spring.repository.BookRepository;



@Controller
@RequestMapping("/book")
public class BokController {
	@Autowired
	private BookRepository bookrepo;
	
	@GetMapping(value ="/showbook")
	public String showBooks(Model m) {
		
		List<BookBean> list = bookrepo.showAllBook();
		if(list.size()>0) {
			
			m.addAttribute("list", list);
			
		}else {
			m.addAttribute("error","No Book");
		}
		return "booklist";
		helloworld
	
		
	}
	
	@GetMapping(value="/editBook/{id}")
	public String selectBookById(@PathVariable("id")int id,Model m) {
		
		
		
		BookBean obj =	bookrepo.showBookById(id);
		m.addAttribute("obj",obj);
		return "editBook";
			
		
			
		
		
	}
	

}
