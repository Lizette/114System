package com.ust.edu.model;

public class LabBean {
	private String lastName="";
	private String firstName="";
	private String section="";
	private int itemID;
	private String item="";
	private int itemQuantity;
	private java.sql.Date timeIn;
	private java.sql.Date timeOut;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public java.sql.Date getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(java.sql.Date timeIn) {
		this.timeIn = timeIn;
	}
	public java.sql.Date getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(java.sql.Date timeOut) {
		this.timeOut = timeOut;
	}
	

}
