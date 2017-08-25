package com.digconn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.digconn.Payment;

public class PaymentDAO {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void insert(Payment payment){
		String sql = "INSERT INTO payment " 
					+ "(ssn, incomemode, annual, creditcard, creditcardnumber, expirydate, nameonCreditCard, billzipcode)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, payment.getSsn());
			ps.setString(2, payment.getIncomemode());
			ps.setString(3, payment.getAnnualincome());
			ps.setString(4, payment.getCreditcardtype());
			ps.setString(5, payment.getCreditcardnumber());
			ps.setString(6, payment.getExpirydate());
			ps.setString(7, payment.getCreditcardname());
			ps.setString(8, payment.getBillingzipcode());
			ps.executeUpdate();
			ps.close();
			System.out.println("Payment details updated successfully!");
		}catch(SQLException e){
			throw new RuntimeException (e);
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
