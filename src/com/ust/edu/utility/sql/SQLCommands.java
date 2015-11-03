
package com.ust.edu.utility.sql;

public interface SQLCommands {
	String INSERT_STUDENT = "insert into student(LastName, FirstName, Section, ItemBorrowed, quantity) values(?,?,?,?)";
	String GET_ALL_STUDENT = "select * from student";
<<<<<<< HEAD
	String UPDATE_ITEMS = "update item set ItemBorrowed= ? quantity = ? where id = ?";
	String GET_ALL_ITEMS = "select * from items";
	String INSERT_NEW_ITEM = "insert into items(equipments, totalnum) values(?,?);";
=======
	String UPDATE_ITEMS = "Update item";
	String GET_ALL_ITEMS = "select * from item";
	String INSERT_NEW_ITEM = "insert into item(equipments, totalnum) values(?,?);";
>>>>>>> refs/remotes/origin/master
	
}
