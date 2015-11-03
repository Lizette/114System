package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.model.AddBean;
import com.ust.edu.utility.sql.SQLOperations;



/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addprocess.html")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
			connection = SQLOperations.getConnection();
		
		if (connection != null) {
			getServletContext().setAttribute("dbConnection", connection);
			System.out.println("connection is READY.");
		} else {
			System.err.println("connection is NULL.");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		AddBean add=  com.ust.edu.utility.BeanFactory.getInstance(item, quantity);
		
		if (connection != null) {
			if (SQLOperations.addNewItem(connection, add)){
				System.out.println("successful insert");
				request.setAttribute("add", add);
				getServletContext().getRequestDispatcher("/actionstatus.jsp?success=true").forward(request, response);
			} else {
				System.out.println("failed insert");
				getServletContext().getRequestDispatcher("/actionstatus.jsp?success=false").forward(request, response);
			}
		} else {
			System.out.println("invalid connection");
		}
	}

}
