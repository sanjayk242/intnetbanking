package com.intnetbanking.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.intnetbanking.pageobject.loginpage;



public class TC_logintest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException 
	{	
		logger.info("Url is opened");
		
		loginpage login=new loginpage(driver);


		login.enteruserid(username);
	    logger.info("entered username");
	    
		login.enterpassword(password);
		logger.info("entered password");
		
		login.clicklogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);	
			logger.info("logintest passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("logintest failed");
		}
		
	}
}
