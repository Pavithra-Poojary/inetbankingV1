package com.inetBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.XLutils;

public class TC_LoginDD_002 extends BaseClass {
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String password) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();//come back to login page
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login pass");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{try
	{driver.switchTo().alert();
	return true;
		
	}
	catch(Exception e)
	{
		return false;
	}
		
	}
	@DataProvider(name="LoginData")
String[][] getData() throws IOException
{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/testData/LoginData.xlsx";
int rownum=XLutils.getRowCount(path, "Sheet1");
int cocount=XLutils.getCellCount(path, "Sheet1", 1);
String logindata[][]=new String[rownum][cocount];
for(int i=1;i<=rownum;i++)
{
	for(int j=0;j<cocount;j++)
	{
		logindata[i-1][j]=XLutils.getCellData(path, "Sheet1", i, j);
		
	}
}
return logindata;

}

}
