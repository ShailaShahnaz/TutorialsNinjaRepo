//under src/test/java
package com.tutorialsninja.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.tutorialsninja.utilities.Utilities;

public class TestBase {
	public static WebDriver driver;
	
	public static Properties prop;
	
	//This is properties file inside a method:
	//public void loadPropertiesFile() throws Exception{
	//prop = new Properties();    //object of properties class
	//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
	//prop.load(ip);
	//}
	
	//OR you can write your code inside your constructor:
	//Using properties file inside the constructor
	public TestBase() throws Exception{
		prop = new Properties();//object of properties class
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
		prop.load(ip);
	}
	
	public WebDriver initializeBrowser (String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicitly_Wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoad_Timeout));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
