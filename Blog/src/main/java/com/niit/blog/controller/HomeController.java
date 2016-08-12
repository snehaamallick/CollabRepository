package com.niit.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.engine.model.Model;

import com.niit.blog.model.User;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String loadLandingPage()
	{
		return "index";
	}
	
	@RequestMapping("/admin")
	public String loadAdminPage()
	{
		return "adminpage";
	}
	@RequestMapping("/user")
	public String loadUserPage()
	{
		return "userpage";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/signin?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	
	
	/*protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		  String url;
		  if(req.isUserInRole("ROLE_USER")) {
		    url = "/user";
		  }else if(req.isUserInRole("ROLE_ADMIN")) {
		    url = "/admin";
		  }*/
	
	@RequestMapping(value="/signin", method = RequestMethod.GET)
	 public String login(ModelMap model) {
	  
	 return "login";
	  
	 }


}
