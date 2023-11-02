package com.sendMail.Gmail_Sender;

public class MainGmailSetters
{
	private static	String from="sai.test90701@gmail.com";
	private static String to="kittu90701@gmail.com";
	private static  String msg="Mail Recieved Sucessfully"
    		+ "Here is your students details......!";
	private static  String subject="This is a test mail to Send Attachment By Using Java Application";

	
	public static void main(String[] args)
	{
		        
          Gmail_SetterAndGetter sg=new Gmail_SetterAndGetter();
	        sg.setFrom(from);
	        sg.setMsg(msg);
	        sg.setSubject(subject);
	        sg.setTo(to);

	}

}
