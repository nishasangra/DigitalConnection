package com.digconn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quote")
public class QuoteController{
 

	//@RequestMapping(method=RequestMethod.POST)
	public ModelAndView viewLogin() {
		
		ModelAndView model = new ModelAndView("QuotePage","quotevalue", "$125.55");	
        return model;
        
        
    }
	
}
