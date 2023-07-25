package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
WebDriver ldriver;
public AddCustomerPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustName;

	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;


	@FindBy(how=How.ID,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtAdd;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtPhoneNumber;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME,using="res")
	@CacheLookup
	WebElement btnReset;
	
	public void addNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustName.sendKeys(cname);
	}
	
	public void custGender(String gender) 
	{
		rdGender.sendKeys(gender);
	}
	public void custDOB(String mm,String dd,String yyyy) 
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}
	public void custAddress(String caddress)
	{
		txtAdd.sendKeys(caddress);
	}
	public void custCity(String ccity) 
	{
		txtCity.sendKeys(ccity);
	}
	public void custState(String cState)
	{
		txtState.sendKeys(cState);
	}
	public void pinno(int pin)
	{
		txtPin.sendKeys(String.valueOf(pin));
	}
	public void custTelephoneNo(String cTeleno)
	{
		txtPhoneNumber.sendKeys(cTeleno);
	}
	public void email(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void password(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void submit() 
	{
		btnSubmit.click();
	}
	public void reset()
	{
		btnReset.click();
	}
}
