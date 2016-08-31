package com.myweb.myblog.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweb.myblog.model.*;
import com.myweb.myblog.model.User;
import com.myweb.myblog.service.impl.BlogServiceImpl;
import com.myweb.myblog.service.impl.UserServiceImpl;



@Controller
public class BlogController {
	
	//private static final Date YOUR_DATE = null;
	@Autowired
    private BlogServiceImpl bs;
	
    private UserServiceImpl us;
	@Autowired
	public BlogController(BlogServiceImpl bs, UserServiceImpl us) {
		
		this.bs = bs;
		this.us = us;
	}
	
	//@Autow
	//private UserServiceImpl us;
	
	
	public BlogController() {
		super();
	}
	

	/*@RequestMapping(value = "/openblog", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("user", new User());
      //  model.addAttribute("listfromtable", this.us.listUsers());
        return "myblog";
    }*/
	
	@RequestMapping(value = "/openblog", method = RequestMethod.GET)
	   public String student(Model model) {

	    model.addAttribute("blog",new Blog());
	    model.addAttribute("user", new User());
	    model.addAttribute("blogList", this.bs.listBlogs());
		model.addAttribute("userList", this.us.listUsers());
		
	      return "myblog";
	   }


	@RequestMapping(value= "/openblog/addblog", method = RequestMethod.POST)
	public String addBlog(@ModelAttribute("blog") Blog blog, Principal p)
	{
		User user = us.getUserByusername(p.getName());
		//us.addUser(user);
		
		
		//blog.setUser(user);
		blog.setU_name(user.getUsername());
		long millis=System.currentTimeMillis();  
		java.util.Date date=new java.util.Date(millis); 
		
		blog.setTime(date);
	
		//blg.setUser_Id(user.getUserId());
		bs.addBlog(blog);
		
		
			return "myblog";
	}
	


	
}
