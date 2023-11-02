package com.sendMail.Gmail_Sender;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class App implements Gmail
{
	
	
	public void parseJSONToExcel()
	{
		JSONParser parser= new JSONParser();
		   
		   try
		   {
			FileReader reader= new FileReader("./JsonFiles/ReadJsonByJava.json");
			
			Object obj= parser.parse(reader);
			
			JSONObject jsonObj = (JSONObject)obj;
			
		/*	String name=(String)jsonObj.get("name");
			String collage=(String)jsonObj.get("collage");
			String gmail=(String)jsonObj.get("gmail");
			String percentage=(String) jsonObj.get("percentage");
			
			System.out.println("Name of student : "+name);
			System.out.println("Name of Collage : "+collage);
			System.out.println("Gmail Id : "+gmail);
			System.out.println("Percentage : "+percentage +"%");
		*/	
			
			 /*    stdId=(String) students.get("StdId");
		     name=(String) students.get("name");
		     gmail=(String) students.get("gmail");
		     percentage =(String) students.get("percentage");
		     
		     System.out.println(stdId+" "+name+" "+gmail+" "+percentage);
		   */
			
			JSONArray array= (JSONArray) jsonObj.get("students");
			
			
			XSSFWorkbook workBook = new XSSFWorkbook();
			
			XSSFSheet sheet= workBook.createSheet();
			
			
			//String stdId,name,gmail,percentage;
			
			for (int i = 0; i < array.size(); i++)
			{
			   JSONObject students= (JSONObject) array.get(i);	
			   
			   XSSFRow row = sheet.createRow(i);
			 int currentCell=0;
		     row.createCell(currentCell++).setCellValue((String) students.get("StdId"));
	         row.createCell(currentCell++).setCellValue((String) students.get("name"));
	         row.createCell(currentCell++).setCellValue((String) students.get("gmail"));
	         row.createCell(currentCell).setCellValue((String) students.get("percentage"));
	     }
			
			FileOutputStream fos=new FileOutputStream("./JsonFiles/InfoStudents.xlsx");
			 
			 workBook.write(fos);
			 workBook.close();
			 fos.close();
			 System.out.println();
			 System.out.println("Excel file created");
			 System.out.println();
		
			
		   }
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}
	  /* Steps to Generate Password for java SMTP. 
	   * 
	   * Step 1: Go to G mail and Open Settings ----> See All setting.
	   * 
	   * Step 2: Select Forward POP/IMAP setting.
	   * 
	   * Step 3: And Enable IMAP ---> Save Changes.
	   * 
	   * Step 4: Open Manage Accounts Click on Security.
	   * 
	   * Step 5: Do Two Step Verification.
	   * 
	   * Step 6: Search for App Passwords ---> Enter App Name.
	   * 
	   * Step 7: Click on Create App (It will generate token as Password ).
	   * 
	   * Step 8: Add that Token to your Java code as a Password.
	   */
	
	
	public void sendGmail(String from, String to, String msg, String subject) 
	{
		// Host provider
	   String host="smtp.gmail.com";
	    
	  Properties properties = System.getProperties();
	  properties.put("mail.smtp.host", host);
	  properties.put("mail.smtp.port","587");
	  properties.put("mail.smtp.starttls.enable","true");
	  properties.put("mail.smtp.auth","true");
	   
	  
	  // Step 1: to get session object
	  Session session= Session.getInstance(properties, new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
		
			
			return new PasswordAuthentication("sai.test90701@gmail.com","egfbtsznfvzzsbbk");
		}
	      
		  
	  });
	  session.setDebug(true);
	  
	  
	  // Step 2: Compose the message
	  
	  MimeMessage mimeMessage= new MimeMessage(session);
	  
	 
	  
	  try {
		  
		//Set From Address
		mimeMessage.setFrom(from);
		
		//set To Address
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		

		//Set Subject
		mimeMessage.setSubject(subject);
		
		String path="C:\\Users\\Sai krishna\\eclipse-workspace\\Gmail_Sender\\JsonFiles\\InfoStudents.xlsx";
		
		MimeMultipart mimeMultipart= new  MimeMultipart();
		
		MimeBodyPart text = new MimeBodyPart();
		
		MimeBodyPart file = new MimeBodyPart();
		
		try
		{
			text.setText(msg);
			
			File sendFile = new File(path);
			
			file.attachFile(sendFile);
			
			mimeMultipart.addBodyPart(text);
			mimeMultipart.addBodyPart(file);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		mimeMessage.setContent(mimeMultipart);
		
		//Sending Mail 
		Transport.send(mimeMessage);
		System.out.println();
		System.out.println("Attachment Sent Sucessfully.......!");
		
	     } 
	catch (MessagingException e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  
		  		
	}

	
}

