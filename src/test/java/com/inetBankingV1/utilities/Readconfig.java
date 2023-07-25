package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	public Readconfig() 
	{
		File src=new File("./Configuration/config.properties");//referencing the path of the file
		try {
			FileInputStream fis=new FileInputStream(src);//opening the file in read mode
			pro=new Properties();//object creation
			pro.load(fis);//load the file
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}	
	}
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;	
	}
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;	
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;	
	}

}
