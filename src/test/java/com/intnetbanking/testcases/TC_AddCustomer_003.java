package com.intnetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.intnetbanking.pageobject.AddCustomerPage;
import com.intnetbanking.pageobject.loginpage;

public class TC_AddCustomer_003 extends BaseClass
{
	@Test
public void AddCustomer() throws InterruptedException, IOException
{
		loginpage login=new loginpage(driver);
		login.enteruserid(username);
		login.enterpassword(password);
		login.clicklogin();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clicknewcustomer();
		
		logger.info("providing customer details....");

		
		addcust.EnterCname("sanju");
		addcust.SelectCgender();
		addcust.SelectDOB("12", "1", "1992");
		
		Thread.sleep(5000);

		addcust.EnterCaddress("INDIA");
		addcust.EnterCcity("margao");
		addcust.EnterCstate("goa");
		addcust.EnterCpin("123456");
		addcust.EnterCphno("1234567890");
		
		String email=randomestring()+"@gmail.com";

		addcust.EnterCemailid(email);
		
		addcust.EnterCpassword("abcdef");
		addcust.ClickSubmit();
		
Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"AddCustomer");//test case name
			Assert.assertTrue(false);
		}
			


}
}
