package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	private WebElement txtusername;
	
	@FindBy(name="password")
	private WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	private WebElement btnlogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	private WebElement btnlogout;
	
	public void setUsername(String name)
	{
		txtusername.sendKeys(name);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnlogin.click();
		
	}
	
	public void clickLogout()
	{
		btnlogout.click();
	}
	
}
