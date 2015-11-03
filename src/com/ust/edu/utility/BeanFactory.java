package com.ust.edu.utility;
import com.ust.edu.model.AddBean;
import com.ust.edu.model.LabBean;

public class BeanFactory {
	  public static LabBean getInstance(String lastName, String firstName, String section, String item)
	    {
		  LabBean lab = new LabBean();
		  lab.setLastName(lastName);
		  lab.setFirstName(firstName);
		  lab.setSection(section);
		  lab.setItem(item);
		  
	      return lab;
	      
	    }
	  
	  public static AddBean getInstance(String item, int quantity){
		  AddBean add = new AddBean();
		  add.setItem(item);
		  add.setQuantity(quantity);
		  return add;
	  }
}
