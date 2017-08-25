package com.digconn.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.digconn.digconnection;
import com.digconn.controller.DigConnectionController;

public class TestMonthlyBillPayment {

	@Test
	public void test() {
		
		digconnection c = new digconnection();
		c.setconntype("Private");
		c.setconnduration("6 months");
		c.setconnusagetype("Business");
		c.setrenewalautopayment("no");
		
		DigConnectionController cc = new DigConnectionController();
		int quoteValue = cc.calculateMonthlyPayment(c);
		assertEquals(quoteValue,120);
	}

}
