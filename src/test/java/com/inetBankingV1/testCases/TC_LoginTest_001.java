package com.inetBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void logintest() throws IOException
	{
		driver.get(baseURL);
		logger.info("Entered URL");
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		String title = driver.getTitle();
		System.out.println(title);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage1")) 
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
