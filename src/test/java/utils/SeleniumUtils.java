package utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.BaseTest;

public class SeleniumUtils  {

	WebDriver driver;
	BaseTest base = new BaseTest();
    Actions actions ;
	
	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 actions = new Actions(driver);
		 
	}
	
	public void mouseHoverandClick(WebElement elem1, WebElement elem2) {
		System.out.println("actions");
		
		actions = new Actions(driver);
		actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
		System.out.println("action done !");
	}
	
	
	public void mouseHoverActions(WebElement elem1, WebElement elem2) {

		
		actions.moveToElement(elem1).perform();
		System.out.println("Hover to menu");
		actions.moveToElement(elem2).click().build().perform();
		System.out.println("Hover to the item and click!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void navigateToLink(String link) {
		driver.findElement(By.linkText(link)).click();
		
	}
	
	
	public void searchForProduct(String product) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
		
		
		
	}
	
	
	public void switchToNewTab(int windowIndex) {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(windowIndex));
		
		System.out.println("This is the tab Num:  " + windowIndex + " " + driver.getWindowHandle());
		System.out.println("Switchted to  : " + driver.getTitle());

}		
	
	
	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	System.out.println("Switched to Frame!!");
	
	
	}
	
	public void scrollDownwards(WebElement element) {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	try {
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println("scrolled down to the :" + element.getText());
	} catch (InterruptedException e) {
		System.out.println("element not found");
		e.printStackTrace();
	}
	
	
	}

	}
	
