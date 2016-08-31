package com.myweb.myblog.controller;

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

@Controller
public class ForumController {
	@Autowired
    private ForumServiceImpl fs;
	
	//@Autow
	//private UserServiceImpl us;
	
	
    
    public ForumController(ForumServiceImpl fs) {
		super();
		this.fs = fs;
	}
    


	

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


	@RequestMapping(value= "/openforum/addforum", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("forum") Forum frm,BindingResult result, HttpServletRequest request)
	{
		
	
		//blg.setUser_Id(user.getUserId());
		fs.addForum(frm);
		
		
			return "myforum";
	}
	


	
}
