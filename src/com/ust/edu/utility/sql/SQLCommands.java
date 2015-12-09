
package com.ust.edu.utility.sql;

public interface SQLCommands {
	String INSERT_STUDENT = "insert into student(LastName, FirstName, Section,itemID, ItemBorrowed, quantity,Returned,timeIN)"
			+ " values(?,?,?,?,?,?,?,?)";
	
	String GET_ALL_STUDENT = "select * from student";
	
	String UPDATE_ITEMS = "update item set equipments= ?, totalnum = ? where id = ?";
	
	String GET_ALL_ITEMS = "select * from item order by equipments asc ";
	
	String INSERT_NEW_ITEM = "insert into item(equipments, totalnum) values(?,?);";
	
	String FIND_ITEM="select * from item where equipments=?";
	
	String DELETE_ITEM = "delete from item where id=?";
	
	String SEARCH_ITEM = "select * from item where id=?";
	
	String SEARCH_STUDENT="select * from student where id=?";
	
	String UPDATE_STUDENT="update student set timeout=?, returned=? where id=?";
	
	String SEARCH_STUDENTS_QUERY="select * from student where lastname like ?"
			+ "OR firstName like ?"
			+ "OR Section like ?"
			+ "OR itemId like ?"
			+ "or itemBorrowed like ?";
	
	String SEARCH_ITEMS_QUERY="select * from item where id like ?"
			+ "OR equipments like ?"
			+ "OR totalnum like ?";
}
