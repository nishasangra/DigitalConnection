package com.digconn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.digconn.digconnection;

public class DigConnDAO {
    
    private DataSource dataSource;
    
    public void setdataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public void insert(digconnection digconnection) {

		String sql = "INSERT INTO digconnection"
				+ "( connectiontype, connectionDuration,  "
				+ "connectionUsageType,  renewalAutoPayment)"
				+ "VALUES (?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, digconnection.getconntype());
			ps.setString(2, digconnection.getconnduration());
			ps.setString(3, digconnection.getconnusagetype());
			ps.setString(4, digconnection.getrenewalautopayment());
			ps.executeUpdate();
			ps.close();
			System.out.println("Connection details updated successfully!");

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

    
}
