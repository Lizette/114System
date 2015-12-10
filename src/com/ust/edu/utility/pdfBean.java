package com.ust.edu.utility;

import java.io.FileOutputStream;
import java.io.IOException;
 
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class pdfBean {
	private static String directory="C://Users/sab/Desktop/";
	
	public static void createPdf(ResultSet rs, java.sql.Date date)
	        throws IOException, DocumentException {
	    	// step 1
	        Document document = new Document();
	        // step 2
	        PdfWriter.getInstance(document, new FileOutputStream(directory+date+"LAB REPORT.pdf"));
	        // step 3
	        document.open();
	        // step 4
	        
	        Paragraph par = new Paragraph();
	        par.add(date +" LAB REPORT");
	        par.setAlignment(Element.ALIGN_CENTER);
	        document.add(par);
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add(createTable(rs));
	        // step 5
	        document.close();
	    }
	
	 public static PdfPTable createTable(ResultSet rs) {
	    	
	        PdfPTable table = new PdfPTable(6);
	       
	        PdfPCell cell;
	        
	        table.addCell("Name");
	        table.addCell("Section");
	        table.addCell("Item Borrowed");
	        table.addCell("Quantity");
	        table.addCell("Time Borrowed");
	        table.addCell("Time Returned");
		       
	        try {
				while(rs.next()){
					/*<tr><a name="<%=recordStudent.getInt("id")%>">
					<td><%=recordStudent.getInt("id")%></td>
					<td><%=recordStudent.getString("LastName")%></td>
					<td><%=recordStudent.getString("FirstName")%></td>
					<td><%=recordStudent.getString("Section")%></td>
					<td><%=recordStudent.getString("itemborrowed")%></td>
					<td><%=recordStudent.getInt("quantity")%></td>
					<td><%=recordStudent.getTimestamp("timein")%></td>
					<td><%=recordStudent.getTimestamp("timeout")%></td></a>
					<td>*/
					table.addCell(rs.getString("lastName")+", "+rs.getString("firstName"));
					table.addCell(rs.getString("Section"));
					table.addCell(rs.getString("itemborrowed"));
					table.addCell(rs.getString("quantity"));
					table.addCell(""+rs.getTimestamp("timein"));
					if(rs.getTimestamp("timeout")!=null){
					table.addCell(""+rs.getTimestamp("timeout"));
					}
					else{
						table.addCell("not yet returned");
					}
				}
			} catch (SQLException e) {
				System.out.print("createtable exception e-"+e);
				e.printStackTrace();
			}
	        return table;
	    }
}
