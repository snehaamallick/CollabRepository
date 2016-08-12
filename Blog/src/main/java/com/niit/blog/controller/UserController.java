package com.niit.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.blog.model.User;
import com.niit.blog.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	
	private UserServiceImpl us;
	
	@Autowired
	public UserController(UserServiceImpl us) {
		this.us = us;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("user", new User());
      //  model.addAttribute("listfromtable", this.us.listUsers());
        return "register";
    }
	
	@RequestMapping(value= "/register/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("user") User u,BindingResult result, HttpServletRequest request)
    {
		u.setEnabled(true);
		u.setRole("ROLE_USER");
		us.addUser(u);
		/*if(u.getUserId() == 0){
            //new person, add it
            this.us.addUser(u);
        }else{
            //existing person, call update
            this.us.updateUser(u);
        }*/
         
        return "registersuccess";
    }
	@RequestMapping(value = "/admin/listuser", method = RequestMethod.GET)
	public ModelAndView listProducts(Model model) {
	    model.addAttribute("user", new User());
	    model.addAttribute("listfromtable", this.us.listUsers());
	    List<User> listUsers=new ArrayList<User>();
	    listUsers=us.listUsers();
	    String json = new Gson().toJson(listUsers);  // converting list into Google Gson object which is a string
		   
		   ModelAndView mv=new ModelAndView("listuser");
		   mv.addObject("myJson", json);
		   return mv;
	    
	}


}

