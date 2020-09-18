package pom;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;

public class URLValidations {
WebDriver driver;
	

 public URLValidations(WebDriver driver) {
	this.driver = driver;
}
	
	public void navigateToUrl(String url) {
		driver.navigate().to(url);
		System.out.println("navigated succssfully to :" + url);
	}
	
	
	public String verifyDirectedUrl() {
		String directedUrl =  driver.getCurrentUrl();
		System.out.println("Current Url :" + directedUrl);
		return directedUrl;
	}
		
	public String verifyTitle() {
		String actualTitle =  driver.getTitle();
		System.out.println("This is the actual Title:" + actualTitle);
		return actualTitle;
		
		
		
	}
	
}
