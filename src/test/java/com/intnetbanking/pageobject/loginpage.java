package com.intnetbanking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage 
{
WebDriver ldriver;

public loginpage(WebDriver driver)
{
	this.ldriver = driver;
}
public void enteruserid(String username)
{
	ldriver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
}
public void enterpassword(String password)
{
	ldriver.findElement(By.name("password")).sendKeys(password);
}
public void clicklogin()
{
	ldriver.findElement(By.xpath("//input[@name='btnLogin']")).click();
}
public void clickadvanced()
{
	ldriver.findElement(By.id("details-button")).click();

}
public void proceedclick()
{
	ldriver.findElement(By.id("proceed-link")).click();

}
public void logout()
{
	ldriver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
}
}
