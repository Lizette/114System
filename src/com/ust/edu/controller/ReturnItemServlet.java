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
import com.ust.edu.model.LabBean;
import com.ust.edu.utility.sql.SQLOperations;


@WebServlet("/returnitem.html")
public class ReturnItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		connection=SQLOperations.getConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int labID = Integer.parseInt(request.getParameter("id"));
		LabBean lab = SQLOperations.searchStudent(labID, connection);
		ItemBean item = SQLOperations.searchItems(lab.getItemID(), connection);
		
		item.setQuantity(item.getQuantity()+lab.getItemQuantity());
		SQLOperations.updateStudent(lab, labID, connection);
		SQLOperations.updateItems(item, lab.getItemID(), connection);
		getServletContext().getRequestDispatcher("liststudent.html").forward(request, response);
	}

}
