package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.model.ItemBean;
import com.ust.edu.model.LabBean;
import com.ust.edu.utility.sql.SQLOperations;

@WebServlet("/borrowformcontinuation.html")
public class BorrowFormContinuationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public void init(/* ServletConfig config */) throws ServletException {
		connection = SQLOperations.getConnection();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//parang dito muna temp na ilalagay yung mga info na nailagay
		LabBean lab = new LabBean();
		lab.setLastName(request.getParameter("lastName"));
		lab.setFirstName(request.getParameter("firstName"));
		lab.setSection(request.getParameter("section"));
		lab.setItem(request.getParameter("item"));
		request.setAttribute("lab", lab);
		
		//kinukuha ang mga id ng mga items na kukunin
		String itemsID[] = request.getParameterValues("borrowed");
		
		//bale eto yung array na lalagyan ng mga info ng mga iboborrow
		ItemBean[] addBeanArray = new ItemBean[itemsID.length];
		
		//sesearch kada isa na nacheck
		for (int x=0;x<itemsID.length;x++) {
			ItemBean currentItem = SQLOperations.searchItems(Integer.parseInt(itemsID[x]), connection);
			addBeanArray[x] = currentItem;
		}
			request.setAttribute("items", addBeanArray);
			getServletContext().getRequestDispatcher(
					"/borrowformcontinuation.jsp").forward(request,response);
		
		}

	
	

}
