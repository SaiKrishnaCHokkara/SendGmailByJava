package com.sendMail.Gmail_Sender;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws IOException
	{
		parseJSONToExcel();
		//convertToExcel();
	}
     
	
	public static void convertToExcel() throws IOException
	{
      
	XSSFWorkbook workBook = new XSSFWorkbook();
		
		XSSFSheet sheet=workBook.createSheet();
		
		Object studentObj[][] = { {"StdId","StdName","Percentage","Gmail"},
				 		   {1,"Ch Sai Krishna",71.0,"kittu90701@gmail.com"},
				 		   {2,"G yash",66.0,"yashraj@gmail.com"},
				 		   {3,"S Jay",68.0,"jaysurya@gmail.com"}
				
		                 };
		 int rows=studentObj.length;  //4 
		 int column=studentObj[0].length;  //3
		 
		 for (int r = 0; r < rows; r++)
		 {
			 XSSFRow row=sheet.createRow(r);
			 
			 for (int c = 0; c < column; c++)
			 {
				 XSSFCell cell=row.createCell(c);
				 
				 Object value =studentObj[r][c];
				 
				 if(value instanceof String)
					 cell.setCellValue((String)value);
				 
				 if(value instanceof Integer)
					 cell.setCellValue((Integer)value);
				 
				 if(value instanceof Boolean)
					 cell.setCellValue((Boolean)value);
				 
				 if(value instanceof Double)
					 cell.setCellValue((Double)value);
				
			 }
			
		 }
		 FileOutputStream fos=new FileOutputStream("./JsonFiles/Students.xlsx");
		 
		 workBook.write(fos);
		 workBook.close();
		 fos.close();
		 System.out.println("Excel file created");

	}

public static void parseJSONToExcel()
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
		 System.out.println("Excel file created");
	
		
	   }
	catch (Exception e)
	{
		
		e.printStackTrace();
	}

}}
