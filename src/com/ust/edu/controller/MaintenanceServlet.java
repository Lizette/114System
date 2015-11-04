package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.model.AddBean;
import com.ust.edu.utility.sql.SQLOperations;


@WebServlet("/maintenanceitems.html")
public class MaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	
	public void init() throws ServletException {
		connection = (Connection) 
				getServletContext().getAttribute("dbConnection");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = null; 
			if (request.getParameter("action").equals("edit")) {
				int id = Integer.parseInt(request.getParameter("id"));
				AddBean add = 
				  com.ust.edu.utility.sql.SQLOperations.searchItems(id, connection);
				request.setAttribute("studentRec", add);
				dispatcher = 
				 getServletContext().getRequestDispatcher("/updateForm.jsp");
			} else if (request.getParameter("action").equals("delete")){
				int id = Integer.parseInt(request.getParameter("id"));
				
				SQLOperations.deleteItems(id, connection);
				ResultSet rs = 
						  SQLOperations.getAllItems(connection);
				request.setAttribute("recordStudent", rs);
				dispatcher = 
				 getServletContext().getRequestDispatcher("/listItems.jsp");	
			}
			dispatcher.forward(request, response);		
		} catch (Exception e) {
			System.err.println("Exception e - " + e.getMessage());
			e.printStackTrace();
		} 
	}

}
