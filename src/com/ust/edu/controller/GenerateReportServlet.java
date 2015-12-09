package com.ust.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.ust.edu.utility.pdfBean;
import com.ust.edu.utility.sql.SQLOperations;

/**
 * Servlet implementation class SearchItemServlet
 */
@WebServlet("/generate.html")
public class GenerateReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection connection;
	
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Date query= java.sql.Date.valueOf(request.getParameter("petsa"));
		ResultSet rs = SQLOperations.searchDateDatabase(query, connection);
		try {
			pdfBean.createPdf(rs, query);
			response.sendRedirect("generateupdate.jsp?status=true");
		} catch (DocumentException e) {
			System.out.println("createBean-");
			e.printStackTrace();
			response.sendRedirect("generateupdate.jsp?status=false");
		}
		
	}

}
