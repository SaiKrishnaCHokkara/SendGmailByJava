package com.sendMail.Gmail_Sender;

public interface Gmail 
{
	public void sendGmail(String from, String to, String msg, String subject);
	
	public void parseJSONToExcel();

}
