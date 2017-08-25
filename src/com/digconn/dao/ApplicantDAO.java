package com.digconn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.digconn.Applicant;

/**
 *
 * @author Administrator
 */
public class ApplicantDAO {
    
    private DataSource dataSource;
    
    public void setdataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public void insert(Applicant applicant) {

		String sql = "INSERT INTO applicant "
				+ "( applfirstname, applmidname,  "
				+ "appllastname,  appladdrline1,"
				+ "appladdrline2,  city, state, zipCode)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, applicant.getApplfirstname());
			ps.setString(2, applicant.getApplmidname());
			ps.setString(3, applicant.getAppllastname());
			ps.setString(4, applicant.getAppladdrline1());
			ps.setString(5, applicant.getAppladdrline2());
			ps.setString(6, applicant.getCity());
			ps.setString(7, applicant.getState());
			ps.setString(8, applicant.getZipcode());
			ps.executeUpdate();
			ps.close();
			System.out.println("Applicant data updated successfully!");

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
