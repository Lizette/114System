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

import com.ust.edu.model.AddBean;
import com.ust.edu.model.LabBean;
import com.ust.edu.utility.sql.SQLOperations;

@WebServlet("/borrowformcontinuation.html")
public class BorrowFormContinuationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public void init(/* ServletConfig config */) throws ServletException {
		connection = SQLOperations.getConnection();
		if (connection != null) {
			getServletContext().setAttribute("dbConnection", connection);
			System.out.println("CONNECTED!");
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
		LabBean lab = new LabBean();
		lab.setLastName(request.getParameter("lastName"));
		lab.setFirstName(request.getParameter("firstName"));
		lab.setSection(request.getParameter("section"));
		lab.setItem(request.getParameter("item"));
		request.setAttribute("lab", lab);
		
		String itemsID[] = request.getParameterValues("borrowed");
		
		AddBean[] addBeanArray = new AddBean[itemsID.length]; 
		for (int x=0;x<itemsID.length;x++) {
		
			AddBean currentItem = com.ust.edu.utility.sql.SQLOperations.searchItems(Integer.parseInt(itemsID[x]), connection);
			addBeanArray[x] = currentItem;
		}
			request.setAttribute("items", addBeanArray);
			getServletContext().getRequestDispatcher(
					"/borrowformcontinuation.jsp").forward(request,response);
		
		}

	
	protected void addToResultSet(AddBean currentItem,ResultSet items){
		try {
			items.moveToInsertRow();
			items.updateString("equipments",currentItem.getItem() ); // updates the
			items.updateInt("totalnum",currentItem.getQuantity() ); // updates the second column to be 35
			items.insertRow();
			items.moveToCurrentRow();
			System.out.print("row INSERTED");
		} catch (SQLException e) {
			System.out.print("add row error");
			e.printStackTrace();
		}
		
	}

}
