package com.digconn.controller;

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

import com.digconn.Applicant;
import com.digconn.Constants;
import com.digconn.Payment;
import com.digconn.digconnection;
import com.digconn.dao.ApplicantDAO;


@Controller
@RequestMapping("/applicant")
public class ApplicantController{
 
	@RequestMapping(method=RequestMethod.GET)
	public String applicantform(Map<String, Object> model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		System.out.println("GET Applicant method");
		Applicant a=new Applicant();
		model.put("applicant",a);
		return "ApplicantPage";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String applicantview(@Valid @ModelAttribute("applicant") Applicant applicant,BindingResult result, Map<String, Object> model) {
		System.out.println("POST applicant method");
		if(result.hasErrors()){
			return "ApplicantPage";
		}
		
		ApplicationContext context;
	    context =  new ClassPathXmlApplicationContext(Constants.BEAN_FILE_LOCATION);
	    ApplicantDAO aDAO = (ApplicantDAO) context.getBean(Constants.APPLICANT_DAO);
	    aDAO.insert(applicant);
	    ((AbstractApplicationContext)context).close();
		Applicant appl = new Applicant();
		model.put("applicant", appl);
		System.out.println("Applicant sucessfully updated");
		
		Payment pay = new Payment();
		model.put("payment",pay);
		
        return "Payment";
    }
 
	
}
