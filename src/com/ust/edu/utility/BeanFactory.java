package com.ust.edu.utility;
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
}
