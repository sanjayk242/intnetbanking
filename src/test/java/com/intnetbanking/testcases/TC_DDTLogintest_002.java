package com.intnetbanking.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intnetbanking.pageobject.loginpage;
import com.intnetbanking.utilities.XLUtils;

public class TC_DDTLogintest_002 extends BaseClass
{
	@Test(dataProvider = "Excell")
	public void loginTest(String username,String password) throws IOException, InterruptedException 
	{	
		logger.info("Url is opened");
		
		loginpage login=new loginpage(driver);
		//login.clickadvanced();
		//login.proceedclick();

		login.enteruserid(username);
	    logger.info("entered username");
	    
		login.enterpassword(password);
		logger.info("entered password");
		
		login.clicklogin();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			login.logout();
			logger.info("Logout passed");

			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
		@DataProvider(name = "Excell")
		String[][] testDataGenerator2() throws IOException 
		{
			String path="C://sanjay//acer d//selenium64//intnetbanking_project//src//test//java//com//intnetbanking//testdata//testdata.xlsx";
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		
	}
}


