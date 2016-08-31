package com.myweb.myblog.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.myblog.model.Message;
import com.myweb.myblog.model.OutputMessage;;
@Controller
@RequestMapping("/openchat")
public class HomeController {

    	
	@RequestMapping(method = RequestMethod.GET)
	  public String viewApplication() {
	    return "chat";
	  }
	    
	  @MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
	    return new OutputMessage(message, new Date());
	  }
	
	
}
