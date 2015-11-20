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
    	connection=SQLOperations.getConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ID of items that are selected
		String itemID[]= request.getParameterValues("itemID");
		//name of items that are selected
		String itemName[]=request.getParameterValues("itemName");
		//quantity of items that are selected
		String quantity[] =request.getParameterValues("quantity");
		
		//student infos
		String firstName=request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String section=request.getParameter("section");
		
		//for testing
		/*
		for(String x:itemID){System.out.println(x);}
		for(String x:itemName){System.out.println(x);}
		*/
		
		
		for(int x=0;x<itemID.length;x++){
			
			//getting infos about the item
			ItemBean itemBean = SQLOperations.searchItems(Integer.parseInt(itemID[x]), connection);
			//subtracting the borrowed from the quantity
			itemBean.setQuantity(itemBean.getQuantity()-Integer.parseInt(quantity[x]));
			//update-update
			SQLOperations.updateItems(itemBean,itemBean.getId(), connection);
			
			
			LabBean lab=BeanFactory.getInstance(lastName, firstName, section, Integer.parseInt(itemID[x]), itemName[x], Integer.parseInt(quantity[x]));
			SQLOperations.addStudent(lab, connection);
		}
		
		getServletContext().getRequestDispatcher("/liststudent.html").forward(request, response);
	}

}
