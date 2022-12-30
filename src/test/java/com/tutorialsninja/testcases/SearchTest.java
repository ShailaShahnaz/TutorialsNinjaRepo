package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.base.TestBase;

public class SearchTest extends TestBase{

	public SearchTest() throws Exception {
		super();
		
	}
	
@BeforeMethod
public void setup() {
	driver= initializeBrowser(prop.getProperty("BrowserName"));

}
@Test(priority=1)
public void verifySearchWithValidProducts() {
	driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Samsung");
	driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	Assert.assertTrue(driver.findElement(By.linkText("Samsung SyncMaster 941BW")).isDisplayed());
}
@Test(priority=2)
public void verifySearchWithInvalidProducts() {
	driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Dell");
	driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	String ActualInvalidSearchMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]")).getText();
	String expectedInvalidSearchMessage = "There is no product that matches the search criteria.";
	Assert.assertEquals(ActualInvalidSearchMessage,expectedInvalidSearchMessage,"Message is not displaying.");
}
@Test(priority=3)
public void verifySearchWithNoProducts() {
	driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
	driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	String ActualNoProductSearchMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]")).getText();
	String expectedNoProductSearchMessage = "There is no product that matches the search criteria.";
	Assert.assertEquals(ActualNoProductSearchMessage,expectedNoProductSearchMessage,"Message is not displaying.");

}
@AfterMethod
public void tearDown() {
	  driver.quit();
}
}
