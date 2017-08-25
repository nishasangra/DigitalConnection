package com.digconn;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Applicant {
	@NotEmpty(message = "Please enter your First Name.")
	String applfirstname;
	
	String applmidname;
	
	@NotEmpty(message = "Please enter your Last Name.")
	String appllastname;
	
	@NotEmpty(message = "Please enter your Address.")
	String appladdrline1;
	String appladdrline2;
	
	@NotEmpty(message = "Please enter your city.")
	String city;
	
	@NotEmpty(message = "Please enter your zip code.")
	@Size(min = 5, max = 5, message = "Your zip code must be 5 characters")
	String zipcode;
	
	@NotEmpty(message = "Please enter your state.")
	String state;
	
	public String getApplfirstname() {
		return applfirstname;
	}
	public void setApplfirstname(String applfirstname) {
		this.applfirstname = applfirstname;
	}
	public String getApplmidname() {
		return applmidname;
	}
	public void setApplmidname(String applmidname) {
		this.applmidname = applmidname;
	}
	public String getAppllastname() {
		return appllastname;
	}
	public void setAppllastname(String appllastname) {
		this.appllastname = appllastname;
	}
	public String getAppladdrline1() {
		return appladdrline1;
	}
	public void setAppladdrline1(String appladdrline1) {
		this.appladdrline1 = appladdrline1;
	}
	public String getAppladdrline2() {
		return appladdrline2;
	}
	public void setAppladdrline2(String appladdrline2) {
		this.appladdrline2 = appladdrline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
