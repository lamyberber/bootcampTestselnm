package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Common;

public class BaseTest  {
	public static WebDriver driver;
	Common com = new Common();
	String browser;
	String baseUrl;
	Properties prop;
	
	

	@Before
	public void setUpMethod() {
		
//	prop = com.getPropertiesFile();
//	
//     browser = prop.getProperty("browser");
//	 baseUrl = prop.getProperty("url");
//	com.setupBrowser(browser, baseUrl);
//	driver = com.getDriver();
//	
	
		com.setUpBrowser();
		driver = com.getDriver();
		
	
		
	}
	@After
	public void tearDown() {
		com.quitBrowser();
		
}








}
