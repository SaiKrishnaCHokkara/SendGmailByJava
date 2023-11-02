package com.sendMail.Gmail_Sender;

public class Main_Gmail {

	public static void main(String[] args) 
	{
	    
		       
      Gmail_SetterAndGetter getter=new Gmail_SetterAndGetter();
	  
	    
	  Gmail gmail=HelperGmail.getInstance();	
	  
	  gmail.parseJSONToExcel();
	  gmail.sendGmail(getter.getFrom(),getter.getTo(),getter.getMsg(),getter.getSubject());
	  
	  
     
	}

}
