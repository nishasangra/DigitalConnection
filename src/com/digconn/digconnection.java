package com.digconn;

import org.hibernate.validator.constraints.NotEmpty;


public class digconnection {
	
	@NotEmpty(message = "This is a mandatory field.")
	String conntype;
	
	@NotEmpty(message = "This is a mandatory field.")
	String connduration;
	
	@NotEmpty(message = "This is a mandatory field.")
	String connusagetype;
	
	@NotEmpty(message = "This is a mandatory field.")
	String renewalautopayment;
	
	public String getconntype() {
		return conntype;
	}
	public void setconntype(String conntype) {
		this.conntype = conntype;
	}
	public String getconnduration() {
		return connduration;
	}
	public void setconnduration(String connduration) {
		this.connduration = connduration;
	}
	public String getconnusagetype() {
		return connusagetype;
	}
	public void setconnusagetype(String connusagetype) {
		this.connusagetype = connusagetype;
	}
	public String getrenewalautopayment() {
		return renewalautopayment;
	}
	public void setrenewalautopayment(String renewalautopayment) {
		this.renewalautopayment = renewalautopayment;
	}	
}
