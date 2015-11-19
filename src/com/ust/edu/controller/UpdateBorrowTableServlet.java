package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ust.edu.model.ItemBean;
import com.ust.edu.model.LabBean;
import com.ust.edu.utility.BeanFactory;
import com.ust.edu.utility.sql.SQLOperations;


@WebServlet("/updateborrowtable.html")
public class UpdateBorrowTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection connection;
    public void init(){
    	SQLOperations.getConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemID[]= request.getParameterValues("itemID");
		String itemName[]=request.getParameterValues("itemName");
		String quantity[] =request.getParameterValues("quantity");
		String firstName=request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String section=request.getParameter("section");
		
		for(int x=0;x<itemID.length;x++){
			ItemBean itemBean = SQLOperations.searchItems(Integer.parseInt(itemID[x]), connection);
			
			LabBean bean=BeanFactory.getInstance(lastName, firstName, section, Integer.parseInt(itemID[x]), itemName[x], Integer.parseInt(quantity[x]));		
		}
	}

}
