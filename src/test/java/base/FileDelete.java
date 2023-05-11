package base;

import java.io.File;

public class FileDelete {
	 
	public static void validateDownloadFile(String downloadedFile) 
	{ 
	String downloadPath = System.getProperty("user.dir")+"/Downloads";
	try  
	{ 
	
	File f= new File(downloadPath+"/"+downloadedFile);           //file to be delete  
	if(f.delete())                      //returns Boolean value  
	{  
	System.out.println(f.getName() + " deleted");   //getting and printing the file name  
	
	}  
	else  
	{  
	System.out.println("failed");  
	}  
	}  
	catch(Exception e)  
	{  
	e.printStackTrace();  
	}  
	}  
	}  

