package com.ust.edu.utility.sql;

import java.sql.*;
import javax.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ust.edu.utility.sql.SQLCommands;
import com.ust.edu.model.LabBean;


public class SQLOperations implements SQLCommands {
	private static Connection connection;
		
	private static Connection getDBConnection() {
		try {
		    InitialContext context = new InitialContext();
		    DataSource dataSource = (DataSource) 
		     context.lookup("java:comp/env/jdbc/UST-3CSC-DS");
		    
		    if (dataSource != null) {
		    	connection = dataSource.getConnection();
		    }
		} catch (NamingException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return connection;
	 }
	
	public static Connection getConnection() {
		return (connection!=null)?connection:getDBConnection();
	}
	
	public static boolean addStudent(LabBean lab,Connection connection) {
		
		try {
	        PreparedStatement pstmt = connection.prepareStatement(INSERT_STUDENT);
	        pstmt.setString(1, lab.getLastName()); 
	        pstmt.setString(2, lab.getFirstName());
	        pstmt.setString(3, lab.getSection());
	        pstmt.setString(4, lab.getItem());            
	        pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SQLException insert student: " + sqle.getMessage());
			return false; 
		}	
		return true;
	}
	

	public static ResultSet getAllStudent(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GET_ALL_STUDENT);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getAllStudents: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
		
		
		public static void addItems(String item ,String Total, Connection connection) {
			
			try {
				connection.setAutoCommit(false);
		        PreparedStatement pstmt = connection.prepareStatement(UPDATE_ITEMS);
		        pstmt.setString(1,Total); 
		      //  pstmt.setString(2,StopNum); 
		        pstmt.executeUpdate();
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - deleteEmployee: " + sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Delete Connection Rollback - " + sql.getMessage());
				}
			}	
		}
		

		public static ResultSet getAllItems(Connection connection) {
			ResultSet rs = null;
			try {
				Statement stmt = connection.createStatement();
				rs = stmt.executeQuery(GET_ALL_ITEMS);  
			} catch (SQLException sqle) {
				System.out.println("SQLException - getAllEarning: " 
				  + sqle.getMessage());
				return rs; 
			}	
			return rs;
		}
		
}
			