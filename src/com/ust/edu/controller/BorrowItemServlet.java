package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.model.LabBean;


@WebServlet("/updateitem.html")
public class BorrowItemServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = null; 
		try {
			LabBean lab = new LabBean();
			lab.setLastName(request.getParameter("lastName"));
			lab.setFirstName(request.getParameter("firstName"));
			lab.setSection(request.getParameter("section"));
			lab.setItem(request.getParameter("item"));
			
			int recordsAffected = 
				com.ust.edu.utility.sql.SQLOperations.updateItems(lab, 
						Integer.parseInt(request.getParameter("Id")), 
						connection);
			request.setAttribute("lab", lab);
			
			if (recordsAffected > 0) {
				dispatcher = 
			getServletContext().getRequestDispatcher(
					"/viewupdate.jsp?success=true");
			} else {
				dispatcher = 
			getServletContext().getRequestDispatcher(
				"/viewupdate.jsp?success=false");
			}
			dispatcher.forward(request, response);		
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}

}
