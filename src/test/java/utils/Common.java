package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Common {
 WebDriver driver;
	Properties prop;
	String browser;
	String baseUrl ;
	
	
	public Properties readPropertiesFile(String fileName) {

		FileReader reader;
		Properties prop=new Properties();  
		try {
			reader = new FileReader(fileName);
			prop.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return prop;
	}

	
	public Properties getPropertiesFile() {
		String configFileName = "config.properties";
		String currDir = System.getProperty("user.dir");
		 prop = readPropertiesFile(currDir + "\\" + configFileName);
		 return prop;

	}
	

	public void invokeBrowser(String browser, String url) {
		String currDir = System.getProperty("user.dir");
		switch(browser) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", currDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("Invalid browser value provided, hence stopping the automation run");
			System.exit(0);
		
		}


		driver.manage().window().maximize();
		if(url!="")
			driver.get(url);
		
		
		else
			driver.get("about:blank");
		
	}



	public WebDriver getDriver() {
		
		return driver;
	}

	public void quitBrowser() {
		driver.quit();
	}

	

	
	
	public void setUpBrowser() {
		getPropertiesFile();
		browser = prop.getProperty("browser");
		baseUrl = prop.getProperty("url");
		 invokeBrowser(browser, baseUrl);
		
		
	}

	

}





