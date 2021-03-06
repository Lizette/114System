package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.utility.sql.SQLOperations;


@WebServlet("/listItems.html")
public class ListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	
	public void init() throws ServletException {
		
			connection = SQLOperations.getConnection();
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			if (connection != null) {
				ResultSet rs = SQLOperations.getAllItems(connection); 			
				request.setAttribute("recordStudent", rs);
				getServletContext().getRequestDispatcher("/listItems.jsp")
					.forward(request, response);
			} else {
				System.out.println("Invalid Connection resource");
			}
		 } catch (NullPointerException npe) {
				System.err.println("Invalid Connection resource - " + npe.getMessage());
		 } catch (Exception e) {
				System.err.println("Exception - " + e.getMessage());
		 } 
	}

}
