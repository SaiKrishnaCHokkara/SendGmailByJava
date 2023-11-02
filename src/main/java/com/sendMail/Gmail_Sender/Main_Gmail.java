package com.sendMail.Gmail_Sender;

public class Main_Gmail {

	public static void main(String[] args) 
	{
	    
		    String from="sai.test90701@gmail.com";
	        String to="kittu90701@gmail.com";
	        String msg="Mail Recieved Sucessfully"
	        		+ "Here is your students details......!";
	        String subject="This is a test mail to Send Attachment By Using Java Application";
	        
            Gmail_SetterAndGetter sg=new Gmail_SetterAndGetter();
	        sg.setFrom(from);
	        sg.setMsg(msg);
	        sg.setSubject(subject);
	        sg.setTo(to);
	    
	  Gmail gmail=HelperGmail.getInstance();	
	  
	  gmail.parseJSONToExcel();
	  gmail.sendGmail(from, to, msg, subject);
	  
	  
     
	}

}
