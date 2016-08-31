package com.myweb.myblog.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweb.myblog.model.*;
import com.myweb.myblog.model.User;
import com.myweb.myblog.service.impl.ForumServiceImpl;
import com.myweb.myblog.service.impl.UserServiceImpl;

@Controller
public class ForumController {
	@Autowired
    private ForumServiceImpl fs;
	
	 private UserServiceImpl us;
	 @Autowired
    public ForumController(ForumServiceImpl fs, UserServiceImpl us) {
		super();
		this.fs = fs;
		this.us = us;
	}





	/*public ForumController(ForumServiceImpl fs) {
		super();
		this.fs = fs;
	}*/
    


	

	public ForumController() {
		super();
	}





	/*@RequestMapping(value = "/openblog", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("user", new User());
      //  model.addAttribute("listfromtable", this.us.listUsers());
        return "myblog";
    }*/
	
	@RequestMapping(value = "/openforum", method = RequestMethod.GET)
	   public String student(Model model) {

	    model.addAttribute("forum",new Forum());
	    model.addAttribute("user", new User());
		
	      return "myforum";
	   }
	
	@RequestMapping("/product/addProduct")
    public String addProduct(Model model){
		Forum forum = new Forum();
        forum.setfCategory("java");


        model.addAttribute("forum", forum);

        return "myforum";
    }


	@RequestMapping(value= "/openforum/addforum", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("forum") Forum frm, Principal p)
	{
		
		User user = us.getUserByusername(p.getName());
		
		frm.setU_name(user.getUsername());
		long millis=System.currentTimeMillis();  
		java.util.Date date=new java.util.Date(millis); 
		
		frm.setTime(date);
		//blg.setUser_Id(user.getUserId());
		fs.addForum(frm);
		
		
			return "myforum";
	}
	


	
}
