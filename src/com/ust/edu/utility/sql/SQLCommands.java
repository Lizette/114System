package com.ust.edu.utility.sql;

public interface SQLCommands {
	String INSERT_STUDENT = "insert into student(LastName, FirstName, Section, ItemBorrowed, quantity) values(?,?,?,?)";
	String GET_ALL_STUDENT = "select * from student";
	String UPDATE_ITEMS = "Update items";
	String GET_ALL_ITEMS = "select * from items";
	
}
