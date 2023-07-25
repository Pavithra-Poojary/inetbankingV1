package com.inetBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.Readconfig;

import freemarker.log.Logger;

public class BaseClass {
Readconfig readconfig=new Readconfig();
public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
//public String chromepath=readconfig.getChromePath();
public static WebDriver driver;
public static Logger logger;

@Parameters("browser")
@BeforeClass
public void setup(String br)
{
	logger=Logger.getLogger("ebanking");
	PropertyConfigurator.configure("log4j.properties");
	if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		System.out.println("open edge browser");
	}
	else
	{
		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(baseURL);
}
@AfterClass
public void tearDown()
{
	driver.quit();
}
public void captureScreen(WebDriver driver,String tname)throws IOException{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}

}
