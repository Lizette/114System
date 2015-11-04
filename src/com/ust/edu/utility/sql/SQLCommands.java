
package com.ust.edu.utility.sql;

public interface SQLCommands {
	String INSERT_STUDENT = "insert into student(LastName, FirstName, Section, ItemBorrowed, quantity) values(?,?,?,?)";
	String GET_ALL_STUDENT = "select * from student";
	String UPDATE_ITEMS = "update item where id = ? set equipments= ? totalnum = ?";
	String GET_ALL_ITEMS = "select * from item order by equipments asc ";
	String INSERT_NEW_ITEM = "insert into item(equipments, totalnum) values(?,?);";
<<<<<<< HEAD
	String DELETE_ITEM = "delete from item where id=?";
	String SEARCH_ITEM = "select * from item where id=?";
=======
	String SEARCH_ITEM ="Select * from item where id=?";
	
>>>>>>> origin/master
}
