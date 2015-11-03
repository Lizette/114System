
package com.ust.edu.utility.sql;

public interface SQLCommands {
	String INSERT_STUDENT = "insert into student(LastName, FirstName, Section, ItemBorrowed, quantity) values(?,?,?,?)";
	String GET_ALL_STUDENT = "select * from student";
	String UPDATE_ITEMS = "update item set equipments= ? totalnum = ? where id = ?";
	String GET_ALL_ITEMS = "select * from item order by equipments asc ";
	String INSERT_NEW_ITEM = "insert into item(equipments, totalnum) values(?,?);";
	String SEARCH_ITEM ="Select * from item where id=?";
	
}
