package com.digconn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LoginDAO {
    
    private DataSource dataSource;
    
    public void setdataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public boolean findbyuser(String strusr, String strpwd) {

		String sql = "SELECT username,password FROM logindetail "
				+ "WHERE username = ? and password = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, strusr);
			ps.setString(2, strpwd);
			ResultSet rs = ps.executeQuery();
			if (!rs.first()) {
				ps.close();
				rs.close();
				return false;
			}
			ps.close();
			rs.close();
			System.out.println("Authenticated user sucessfully!");
			return true;

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
