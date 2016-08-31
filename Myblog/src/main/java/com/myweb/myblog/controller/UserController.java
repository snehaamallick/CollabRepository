package com.myweb.myblog.controller;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.myweb.myblog.model.*;
import com.myweb.myblog.service.impl.UserServiceImpl;
@Controller
public class UserController {
	
	@Autowired
    private JavaMailSender mailSender;
	
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
		System.out.println(u.getUsername());
		u.setEnabled(true);
		u.setRole("ROLE_USER");
		us.addUser(u);
		
		// takes input from e-mail form
        String recipientAddress = u.getEmail();
        String fname=u.getName();
        String pwd=u.getPassword();
        String subject ="Welcome!! NIIT Employees Portal " /*request.getParameter("musichub alert")*/;
        String message = "We are happy to see you with us at NIIT Employees Portal. Your username="+u.getUsername()+" and password is: "+pwd+" Thank You!!";
        String finalmessage="Hi "+fname+", "+" "+message+"!!! "+"All the best. - Created by Partha";
         
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + finalmessage);
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(finalmessage);
         
        // sends the e-mail
        mailSender.send(email);
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
	
	@RequestMapping("/user")
	public String loadUserPage(Model model)
	{
		model.addAttribute("listfromtable", this.us.listUsers());
		return "userpage";
	}
	@RequestMapping("/user/basicdetail/editdetail/{userId}")
    public String editProduct(@PathVariable("userId") int id,  Model model){
        User user = us.getUserById(id);

        model.addAttribute("user", user);

        return "editbasic";
    }
	
	@RequestMapping(value="/user/basicdetail/editdetail", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("basicdetail") User user, BindingResult result, HttpServletRequest request){

        


       /* MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Product image saving failed", ex);
            }
        }*/
		//model.addAttribute("basicdetail", this.us.getUserById(userId));
        us.updateUser(user);

        return "redirect:/user";
    }


}

