package com.inetBankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
@Test	
public void addNewCustomer() throws InterruptedException, IOException {
	LoginPage lp=new LoginPage(driver);
	lp.setUsername(username);
	lp.setPassword(password);		
	lp.clickLogin();
	
	Thread.sleep(3000);
	
	AddCustomerPage ac=new AddCustomerPage(driver);
	ac.addNewCustomer();
	ac.custName("Pavithra");
	ac.custGender("female");
	ac.custCity("Banglore");
	ac.custAddress("BTM Layout");
	ac.custDOB("10", "20", "1998");
	Thread.sleep(5000);
	ac.custState("Karnataka");
	ac.pinno(123456);
	ac.custTelephoneNo("7258255296");
	String email=RandomString()+"gmail.com";
	ac.email(email);
	ac.password("adbh");
	ac.submit();
	Thread.sleep(2000);
	boolean res = driver.getPageSource().contains("Customer Registered Successfully");
	
	if(res==true)
	{
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
}
public String RandomString() {
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
	
}
}
