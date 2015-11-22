package com.ust.edu.utility.sql;

import java.sql.*;

import javax.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ust.edu.utility.sql.SQLCommands;
import com.ust.edu.model.ItemBean;
import com.ust.edu.model.LabBean;

public class SQLOperations implements SQLCommands {
	private static Connection connection;

	private static Connection getDBConnection() {
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context
					.lookup("java:comp/env/jdbc/UST-3CSC-DS");

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
		return (connection != null) ? connection : getDBConnection();
	}

	public static ItemBean searchEmployee(int id, Connection connection) {

		ItemBean add = new ItemBean();

		try {
			PreparedStatement pstmt = connection.prepareStatement(SEARCH_ITEM);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				add.setItem(rs.getString("equipments"));
				add.setQuantity(rs.getInt("quantity"));
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException - searchEmployee: "
					+ sqle.getMessage());
			return add;
		}
		return add;
	}

	public static boolean addStudent(LabBean lab, Connection connection) {

		try {// "insert into student(LastName, FirstName, Section,itemID, ItemBorrowed, quantity,Returned,timeIN)"
				// + " values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection
					.prepareStatement(INSERT_STUDENT);
			pstmt.setString(1, lab.getLastName());
			pstmt.setString(2, lab.getFirstName());
			pstmt.setString(3, lab.getSection());
			pstmt.setInt(4, lab.getItemID());
			pstmt.setString(5, lab.getItem());
			pstmt.setInt(6, lab.getItemQuantity());
			pstmt.setString(7, "FALSE");
			pstmt.setTimestamp(8,
					new java.sql.Timestamp(new java.util.Date().getTime()));

			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SQLException insert student: "
					+ sqle.getMessage());
			return false;
		}
		return true;
	}

	public static boolean addNewItem(Connection connection, ItemBean add) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement(INSERT_NEW_ITEM);
			pstmt.setString(1, add.getItem());
			pstmt.setString(2, "" + add.getQuantity());
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SQLException add new item: "
					+ sqle.getMessage());
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

	public static void addItems(String item, String Total, Connection connection) {

		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_ITEMS);
			pstmt.setString(1, Total);
			// pstmt.setString(2,StopNum);
			pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - deleteEmployee: "
					+ sqle.getMessage());

			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Delete Connection Rollback - "
						+ sql.getMessage());
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

	public static int updateItems(ItemBean add, int id, Connection connection) {
		int updated = 0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_ITEMS);
			pstmt.setString(1, add.getItem());
			pstmt.setInt(2, add.getQuantity());
			pstmt.setInt(3, id);
			updated = pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - updateItems: "
					+ sqle.getMessage());

			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Update Connection Rollback - "
						+ sql.getMessage());
			}
			return updated;
		}
		return updated;
	}

	public static int updateStudent(LabBean lab, int id, String status,
			Connection connection) {
		// "update student set timeout=?, returned=? where id=?";
		int updated = 0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection
					.prepareStatement(UPDATE_STUDENT);
			pstmt.setTimestamp(1,
					new java.sql.Timestamp(new java.util.Date().getTime()));
			if (status.equals("FALSE")) {
				pstmt.setString(2, "TRUE");
				pstmt.setTimestamp(1, new java.sql.Timestamp(
						new java.util.Date().getTime()));
			} else {
				pstmt.setString(2, "FALSE");
				pstmt.setTimestamp(1, null);
			}
			pstmt.setInt(3, id);
			updated = pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - updateItems: "
					+ sqle.getMessage());

			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Update Connection Rollback - "
						+ sql.getMessage());
			}
			return updated;
		}
		return updated;
	}

	public static synchronized int deleteItems(int id, Connection connection) {
		int updated = 0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(DELETE_ITEM);
			pstmt.setInt(1, id);
			updated = pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - deleteItem: "
					+ sqle.getMessage());
			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Delete Connection Rollback - "
						+ sql.getMessage());
			}
			return updated;
		}
		return updated;
	}

	public static ItemBean searchItems(int id, Connection connection) {

		ItemBean add = new ItemBean();

		try {
			PreparedStatement pstmt = connection.prepareStatement(SEARCH_ITEM);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				add.setId(Integer.parseInt(rs.getString("id")));
				add.setItem(rs.getString("equipments"));
				add.setQuantity(rs.getInt("totalnum"));
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException - searchItem: "
					+ sqle.getMessage());
			return add;
		}
		return add;
	}

	public static LabBean searchStudent(int id, Connection connection) {

		LabBean lab = new LabBean();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement(SEARCH_STUDENT);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				lab.setFirstName(rs.getString("firstname"));
				lab.setLastName(rs.getString("lastname"));
				lab.setSection(rs.getString("section"));
				lab.setItemID(rs.getInt("itemID"));
				lab.setItem(rs.getString("itemborrowed"));
				lab.setItemQuantity(rs.getInt("quantity"));
				lab.setTimeIn(rs.getTimestamp("timein"));
				lab.setTimeOut(rs.getTimestamp("timeout"));

			}
		} catch (SQLException sqle) {
			System.out.println("SQLException - searchStudent: "
					+ sqle.getMessage());
			return lab;
		}
		return lab;
	}
	
	public static ResultSet searchStudentsDatabase(String search,Connection connection){
		ResultSet rs=null;
		try {
			String query = SEARCH_STUDENTS_QUERY;
			
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,"%"+search+"%");
			pstmt.setString(2,"%"+search+"%");
			pstmt.setString(3,"%"+search+"%");
			pstmt.setString(4,"%"+search+"%");
			pstmt.setString(5,"%"+search+"%");
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.print("SearchStudentsDatabase error-");
			e.printStackTrace();
		}
		
		return rs;
		
	}

}
