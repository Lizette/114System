package com.ust.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
 
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.utility.BeanFactory;
import com.ust.edu.utility.sql.SQLOperations;
import com.ust.edu.model.LabBean;


@WebServlet("/process.html")
public class processServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

public Connection connection;
	
	public void init() throws ServletException {
	connection=SQLOperations.getConnection();
	
	if (connection != null) {
		getServletContext().setAttribute("dbConnection", connection);
		System.out.println("connection is READY.");
	} else {
		System.err.println("connection is NULL.");
	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastName = "";
		String firstName = "";
		String section="";
		String item="";
		PrintWriter out = response.getWriter();
		try {
			lastName = (request.getParameter("lastName"));
			firstName = (request.getParameter("firstName"));
			section = (request.getParameter("section"));
			item = (request.getParameter("item"));
			if (lastName.trim().equals("") || firstName.trim().equals("")
					|| section.trim().equals("") || item.trim().equals("")){
				out.print("<h2> Please fill all the boxes provided. Thank you!</h2>"
						+ "<form action = 'index.jsp' method = 'post'>"
						+ "<p><input type='submit' value='Go Back'/></p></form>");
			}  else {
				LabBean lab = BeanFactory.getInstance(lastName, firstName, section, item);
				request.setAttribute("lab", lab); 
			}
				/*if (connection != null) {
					if (SQLOperations.addStudent(passenger, connection)){
						switch(passenger.getStopNum()){
						case "Stop 1":SQLOperations.addEarning(passenger.getStopNum(),passenger.getStop1TotalWord(), connection);
						break;
						case "Stop 2":SQLOperations.addEarning(passenger.getStopNum(),passenger.getStop2TotalWord(), connection);
						break;
						case "Stop 3":SQLOperations.addEarning(passenger.getStopNum(),passenger.getStop3TotalWord(), connection);
						break;
						case "Stop 4":SQLOperations.addEarning(passenger.getStopNum(),passenger.getStop4TotalWord(), connection);
						break;
						case "Stop 5":SQLOperations.addEarning(passenger.getStopNum(),passenger.getStop5TotalWord(), connection);
						break;
						case "Stop 6":SQLOperations.addEarning(passenger.getStopNum(),passenger.getStop6TotalWord(), connection);
						break;
						}
						
						System.out.println("successful insert");
						request.setAttribute("passenger", passenger);
						getServletContext().getRequestDispatcher("/action.jsp?success=true").forward(request, response);
					} else {
						System.out.println("failed insert");
						getServletContext().getRequestDispatcher("/action.jsp?success=false").forward(request, response);
					}
				} else {
					System.out.println("invalid connection");
				}
			}*/
			}
			catch (Exception e) {}
		
}}

