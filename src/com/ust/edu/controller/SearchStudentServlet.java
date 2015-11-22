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

/**
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/searchstudent.html")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query= request.getParameter("query");
		ResultSet rs = SQLOperations.searchStudentsDatabase(query, connection);
		request.setAttribute("recordStudent",rs);
		request.setAttribute("query",query);
		
		getServletContext().getRequestDispatcher("/listStudent.jsp").forward(request, response);
	}

}
