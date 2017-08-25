package com.digconn.controller;

import java.util.LinkedHashMap;
import java.util.Map;

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

import com.digconn.Constants;
import com.digconn.digconnection;
import com.digconn.Payment;
import com.digconn.dao.PaymentDAO;

@Controller
@RequestMapping("/payment")
public class PaymentController{
 
	@RequestMapping(method=RequestMethod.GET)
	public String login(Map<String, Object> model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		System.out.println("GET Payment method");
		Payment pay = new Payment();
		model.put("payment",pay);	
		return "Payment";	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String viewLogin(@Valid @ModelAttribute("payment") Payment payment,BindingResult result, Map<String, Object> model) {
		System.out.println("POST payment method");	
		if(result.hasErrors()){
			return "Payment";
		}
		
		ApplicationContext context =  new ClassPathXmlApplicationContext(Constants.BEAN_FILE_LOCATION);
	    PaymentDAO vDAO = (PaymentDAO) context.getBean(Constants.PAYMENT_DAO);
	    vDAO.insert(payment);
	    ((AbstractApplicationContext)context).close();
		Payment paydetails = new Payment();
		model.put("payment", paydetails);
		System.out.println("Payment Information sucessfully updated");
		
		digconnection dgconn=new digconnection();
		model.put("digconnection", dgconn);	
		
        return "DigConnection";
    }	
}
