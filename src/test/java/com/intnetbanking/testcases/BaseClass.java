package com.intnetbanking.testcases;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.intnetbanking.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{		
	Readconfig readobj=new Readconfig();
	public String BaseUrl=readobj.getApplicationURL();
	public String username=readobj.getUsername();
	public String password=readobj.getPassword();
    public WebDriver driver;
    public static Logger logger;
    
@Parameters("browser")
@BeforeClass
public void Setup(String br)
{
	logger=Logger.getLogger("ebanking");
	PropertyConfigurator.configure("log4j.properties");
	
	if(br.equals("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	else if(br.equals("ie"))
	{
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	else if(br.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(BaseUrl);
}

@AfterClass
public void teardown()
{
	driver.quit();
}
public void captureScreen(WebDriver driver, String tname) throws IOException 
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}

public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}
}
