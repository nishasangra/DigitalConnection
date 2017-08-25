package com.digconn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.digconn.Applicant;
import com.digconn.Constants;
import com.digconn.Payment;
import com.digconn.digconnection;
import com.digconn.dao.DigConnDAO;
import com.digconn.dao.PaymentDAO;

@Controller
@RequestMapping("/digconnection")
public class DigConnectionController{
 
	@RequestMapping(method=RequestMethod.GET)
	public String login(Map<String, Object> model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		System.out.println("GET digconnection method");
		digconnection dgconn=new digconnection();
		model.put("digconnection", dgconn);		
		return "DigConnection";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView viewLogin(@Valid @ModelAttribute("digconnection") digconnection digconnection, BindingResult result) {
		System.out.println("POST Digital Connection method");
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("ConnectionDetailsPage","quotevalue", "Incorrect Data entered");
			return model;
		}

		ApplicationContext context;
	    context =  new ClassPathXmlApplicationContext(Constants.BEAN_FILE_LOCATION);
	    DigConnDAO cDAO = (DigConnDAO) context.getBean(Constants.DIGCONN_DAO);
	    cDAO.insert(digconnection);
	    ((AbstractApplicationContext)context).close();
		int quotevalue = calculateMonthlyPayment(digconnection);
		System.out.println(quotevalue);
		//ModelAndView model = new ModelAndView("ConnectionDetailsPage", "quotevalue", quotevalue);	
	    //ModelAndView model = new ModelAndView("ConnectionDetailsPage","quotevalue", "$125.55");	
        //return model;
      
        RestTemplate temp = new RestTemplate();
        int ran  = new Random().nextInt(20);
        String quote = temp.getForObject("http://localhost:8080/RestfulService/rest/GetQuote/quote?quote="+ran, String.class);
        System.out.println(quote);
        
        Map model = new HashMap();
       model.put("quote", quote);
        model.put("quotevalue", quotevalue);
       ModelAndView modelView = new ModelAndView("ConnectionDetailsPage","model", model);
         return modelView;
       
        //ModelAndView model1 = new ModelAndView("ConnectionDetailsPage", "quote", quote);	
	    //ModelAndView model = new ModelAndView("ConnectionDetailsPage","quotevalue", "$125.55");	
        //return model1;
    }

	public int calculateMonthlyPayment(digconnection c) {
		System.out.println("Calculating Quote Value");
		int billAmount = 0;
		if ("Personal".equalsIgnoreCase(c.getconntype())) {
		  if(c.getconnduration().equalsIgnoreCase("6 months")) {
		billAmount = 60;
		 } else if(c.getconnduration().equalsIgnoreCase("12 Months")) {
		billAmount = 40;
	       } 
		} else if ("Commercial".equalsIgnoreCase(c.getconntype())) {
		if(c.getconnduration().equalsIgnoreCase("6 months")) {
		billAmount = 80;
		} else if(c.getconnduration().equalsIgnoreCase("12 Months")) {
		billAmount = 60;
		} 
		}
		if (c.getconnusagetype().equalsIgnoreCase("Private")) {
		billAmount = billAmount - billAmount/10;
		} else 
		if (c.getconnusagetype().equalsIgnoreCase("Business")) {
		billAmount = billAmount - billAmount/5;
		}
		if (c.getrenewalautopayment().equalsIgnoreCase("yes")) {
		billAmount = billAmount - billAmount/5;
		}
		System.out.println("BILLING AMOUNT CALCULATED WILL BE ::  " + billAmount);
		return billAmount;
		}
	{
		
	}
 
	
}
