package com.digconn;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Payment {
	@NotEmpty(message ="Please enter your SSN number.")
	@Size(min=9, max=9, message ="SSN number should be 9 characters.")
	String ssn;
	
	@NotEmpty(message="Please enter your mode of income.")
	String incomemode;
	
	public String getIncomemode() {
		return incomemode;
	}
	public void setIncomemode(String incomemode) {
		this.incomemode = incomemode;
	}
	@NotEmpty(message="Please enter your Annual Income.")
	String annualincome;
	
	@NotEmpty(message ="Please enter your Credit Card Type.")
	String creditcardtype;
	
	@NotEmpty(message="Please enter your Credit Card number.")
	@Size(min=16, max=16, message="Credit Card number should be 16 characters.")
	String creditcardnumber;
	
	@NotEmpty(message ="Please enter your Expiry Date.")
	String expirydate;
	
	@NotEmpty(message = "Please enter name on Credit Card used.")
	String creditcardname;
	
	@NotEmpty(message ="Please enter your Billing ZipCode.")
	@Size(min=5, max=5, message ="Billing Zip Code should be 5 characters.")
	String billingzipcode;

	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(String annualincome) {
		this.annualincome = annualincome;
	}
	public String getCreditcardtype() {
		return creditcardtype;
	}
	public void setCreditcardtype(String creditcardtype) {
		this.creditcardtype = creditcardtype;
	}
	public String getCreditcardnumber() {
		return creditcardnumber;
	}
	public void setCreditcardnumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getCreditcardname() {
		return creditcardname;
	}
	public void setCreditcardname(String creditcardname) {
		this.creditcardname = creditcardname;
	}
	public String getBillingzipcode() {
		return billingzipcode;
	}
	public void setBillingzipcode(String billingzipcode) {
		this.billingzipcode = billingzipcode;
	}
	
	
}


