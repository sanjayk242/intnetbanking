package com.intnetbanking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage 
{
WebDriver rdriver;

public AddCustomerPage(WebDriver driver) 
{
	this.rdriver=driver;
}
public void clicknewcustomer()
{
	rdriver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
}
public void EnterCname(String cname)
{
	rdriver.findElement(By.xpath("//input[@name='name']")).sendKeys(cname);
}
public void SelectCgender()
{
	rdriver.findElement(By.name("rad1")).click();
}
public void SelectDOB(String mm,String dd,String yy)
{
	rdriver.findElement(By.id("dob")).sendKeys(mm);
	rdriver.findElement(By.id("dob")).sendKeys(dd);
	rdriver.findElement(By.id("dob")).sendKeys(yy);
}
public void EnterCaddress(String caddress)
{
	rdriver.findElement(By.name("addr")).sendKeys(caddress);
}
public void EnterCcity(String ccity)
{
	rdriver.findElement(By.name("city")).sendKeys(ccity);
}
public void EnterCstate(String cstate)
{
	rdriver.findElement(By.name("state")).sendKeys(cstate);
}
public void EnterCpin(String cpin)
{
	rdriver.findElement(By.name("pinno")).sendKeys(cpin);
}
public void EnterCphno(String cphno)
{
	rdriver.findElement(By.name("telephoneno")).sendKeys(cphno);
}
public void EnterCemailid(String cemailid)
{
	rdriver.findElement(By.name("emailid")).sendKeys(cemailid);
}
public void EnterCpassword(String cpass)
{
	rdriver.findElement(By.name("password")).sendKeys(cpass);
}
public void ClickSubmit()
{
	rdriver.findElement(By.name("sub")).click();
}
}
