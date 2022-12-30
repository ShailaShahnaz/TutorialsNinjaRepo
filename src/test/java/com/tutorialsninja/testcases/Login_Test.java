package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.TestBase;
import com.tutorialsninja.utilities.Utilities;

public class Login_Test extends TestBase{
  
	public Login_Test() throws Exception {
		super();//super key word will directly link codes from the class TestBase
	}
	
  @BeforeMethod
  public void setup() {
	  driver= initializeBrowser(prop.getProperty("BrowserName")); 
	  driver.findElement(By.xpath("//span[text()='My Account']")).click();
	  driver.findElement(By.linkText("Login")).click();  
  }
@Test(priority =1)
  public void VerifyLoginWithValidCredentials() {
	  driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
	  driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	  String actualMessage = driver.findElement(By.linkText("Edit your account information")).getText();
	  String ExpectedMessage = "Edit your account information";
	  Assert.assertTrue(actualMessage.contains(ExpectedMessage),"The link showing edit your account information doesn't not exist");
	    
  }
  
  @Test(priority =2)
  public void VerifyLoginWithInvalidCredentials() {
	  driver.findElement(By.id("input-email")).sendKeys(Utilities.generateDateTimeStamp());
	  driver.findElement(By.id("input-password")).sendKeys(Utilities.generateDateTimeStamp());
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	  
	  String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText(); 
	  String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
	  //String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText(); 
	  //String expectedWarningMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed.");
	  	  
	 } 
  
  @Test(priority =3)
  public void VerifyLoginWithInvalidEmailValidPassword() {
	  driver.findElement(By.id("input-email")).sendKeys(Utilities.generateDateTimeStamp());
	  driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

	  String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText(); 
	  String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
				 
	  //String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText(); 
	  //String expectedWarningMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
				
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed.");
	 
  }

  @Test(priority =4)
  public void VerifyLoginWithValidEmailInvalidPassword() {
	  driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
	  driver.findElement(By.id("input-password")).sendKeys(Utilities.generateDateTimeStamp());
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

	  String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText(); 
	  String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
				 
	  //String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText(); 
	  //String expectedWarningMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
				
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed.");
	  	  
  }
  
  @Test(priority =5)
  public void VerifyLoginWithNoCredentials() {
	  driver.findElement(By.id("input-email")).sendKeys("");
	  driver.findElement(By.id("input-password")).sendKeys("");
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

	  String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText(); 
	  String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
				 
	  //String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText(); 
	  //String expectedWarningMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
				
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed.");
	  
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
  
}
