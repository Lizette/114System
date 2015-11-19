package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.model.ItemBean;
import com.ust.edu.utility.BeanFactory;
import com.ust.edu.utility.sql.SQLOperations;

@WebServlet("/addprocess.html")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;

	public void init() throws ServletException {
		connection = SQLOperations.getConnection();

		if (connection != null) {
			getServletContext().setAttribute("dbConnection", connection);
			System.out.println("connection is READY.");
		} else {
			System.err.println("connection is NULL.");
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String item = request.getParameter("item");
			int quantity;

			quantity = Integer.parseInt(request.getParameter("quantity"));

			ItemBean add = BeanFactory.getInstance(item, quantity);

			if (connection != null) {
				
				if (SQLOperations.addNewItem(connection, add)) {//tetest kung naadd ba o hindi
					System.out.println("successful insert");
					request.setAttribute("add", add);
					getServletContext().getRequestDispatcher(
							"/addActionStatus.jsp?success=true").forward(
							request, response);
				} else {//kung hindi na add
					getServletContext().getRequestDispatcher(
							"/addActionStatus.jsp?success=false").forward(
							request, response);
					System.out.println("failed insert");
				}
			} else {//kung walang connection
				System.out.println("invalid connection");
			}
		} catch (Exception e) {
			getServletContext().getRequestDispatcher(
					"/addActionStatus.jsp?success=false").forward(request,
					response);
		}
	}

}
