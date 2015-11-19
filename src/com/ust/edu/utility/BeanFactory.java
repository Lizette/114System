package com.ust.edu.utility;
import com.ust.edu.model.ItemBean;
import com.ust.edu.model.LabBean;

public class BeanFactory {
	  public static LabBean getInstance(String lastName, String firstName, String section,int itemID, String item, int itemQuantity)
	    {
		  LabBean lab = new LabBean();
		  lab.setLastName(lastName);
		  lab.setFirstName(firstName);
		  lab.setSection(section);
		  lab.setItemID(itemID);
		  lab.setItem(item);
		  lab.setItemQuantity(itemQuantity);
		  
	      return lab;
	    }
	  
	  public static ItemBean getInstance(String item, int quantity){
		  ItemBean add = new ItemBean();
		  add.setItem(item);
		  add.setQuantity(quantity);
		  return add;
	  }
}
