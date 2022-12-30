package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.base.TestBase;
import com.tutorialsninja.utilities.Utilities;

public class RegisterTest extends TestBase{
  
	public RegisterTest() throws Exception {
		super();
		
	}
  
@BeforeMethod()
public void Setup() {
	  driver= initializeBrowser(prop.getProperty("BrowserName"));	  
	  driver.findElement(By.xpath("//span[text()='My Account']")).click();
	  driver.findElement(By.linkText("Register")).click();
}

  @Test(priority=1)
  public void VerifyRegisterWithMandatoryFields() {
	  driver.findElement(By.id("input-firstname")).sendKeys("selenium1");
	  driver.findElement(By.id("input-lastname")).sendKeys("Panda1");
	  driver.findElement(By.id("input-email")).sendKeys(Utilities.generateDateTimeStamp());
	  driver.findElement(By.id("input-telephone")).sendKeys("3216549870");
	  driver.findElement(By.id("input-password")).sendKeys("Selenium@1234");
	  driver.findElement(By.id("input-confirm")).sendKeys("Selenium@1234");
	  
	  driver.findElement(By.name("agree")).click();
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	  
	  String actualMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	  String expectedMessage = "Your Account Has Been Created!";
	  Assert.assertEquals(actualMessage, expectedMessage, "Account success message didn't displayed");
  }
  
  @Test(priority=2)
  public void VerifyRegisterWithAllFields() {
	  driver.findElement(By.id("input-firstname")).sendKeys("selenium1");
	  driver.findElement(By.id("input-lastname")).sendKeys("Panda1");
	  driver.findElement(By.id("input-email")).sendKeys(Utilities.generateDateTimeStamp());
	  driver.findElement(By.id("input-telephone")).sendKeys("3216549870");
	  driver.findElement(By.id("input-password")).sendKeys("Selenium@1234");
	  driver.findElement(By.id("input-confirm")).sendKeys("Selenium@1234");
	  
	  driver.findElement(By.xpath("//input[@name='newsletter' and @value = '1']"));
	  driver.findElement(By.name("agree")).click();
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	  
	  String actualMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	  String expectedMessage = "Your Account Has Been Created!";
	  Assert.assertEquals(actualMessage, expectedMessage, "Account success message didn't displayed");
  }
  @Test(priority=3)
  public void VerifyRegisterWithoutFeelingAnyFields() {
	  driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	  
	  String actualPrivacyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	  String expectedPrivacyWarning = "Warning: You must agree to the Privacy Policy!";
	  Assert.assertTrue(actualPrivacyWarning.contains(expectedPrivacyWarning),"Privacy warning message is not displaying");
	  
	  String actualFirstNameWarning= driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
	  String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
	  Assert.assertTrue(actualFirstNameWarning.contains(expectedFirstNameWarning),"First name warning message is not displayed");
  
	  String actualLastNameWarning= driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
	  String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
	  Assert.assertTrue(actualLastNameWarning.contains(expectedLastNameWarning),"Last name warning message is not displayed");
  
	  String actuaEmailAddressWarning= driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
	  String expectedEmailAddressWarning = "E-Mail Address does not appear to be valid!";
	  Assert.assertTrue(actuaEmailAddressWarning.contains(expectedEmailAddressWarning),"Email warning message is not displayed");
 
	  String actualTelephoneWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
	  String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
	  Assert.assertTrue(actualTelephoneWarning.contains(expectedTelephoneWarning),"Telephone warning message is not displaying");
  
	  String actualPasswordWarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
	  String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
	  Assert.assertTrue(actualPasswordWarning.contains(expectedPasswordWarning),"Password warning message is not displaying");
	  
  }

@AfterMethod()
  public void tearDown() {
  	driver.quit();
  }

}
