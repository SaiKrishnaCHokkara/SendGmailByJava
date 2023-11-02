package com.sendMail.Gmail_Sender;


import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JasonParser {

	public static void main(String[] args) 
	{
	   parseJSON();
	}
	
    public static void parseJSON()
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
 		
 		JSONArray array= (JSONArray) jsonObj.get("students");
 		
 		System.out.println("Details of students are......");
 		
 		String stdId,name,gmail,percentage;
 		for (int i = 0; i < array.size(); i++)
 		{
 		   JSONObject students= (JSONObject) array.get(i);	
 		     stdId=(String) students.get("StdId");
 		     name=(String) students.get("name");
 		     gmail=(String) students.get("gmail");
 		     percentage =(String) students.get("percentage");
 		     
 		     System.out.println(stdId+" "+name+" "+gmail+" "+percentage);
 		   
 		}
 		
 	   }
 	catch (Exception e)
 	{
 		
 		e.printStackTrace();
 	}

    }

}
