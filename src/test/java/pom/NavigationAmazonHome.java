package pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.BaseTest;
import utils.Common;
import utils.SeleniumUtils;

public class NavigationAmazonHome {
	WebDriver driver;
	BaseTest base =  new BaseTest();
	Common com = new Common();
	SeleniumUtils seleniumUtils;
	WebDriverWait wait;

	@CacheLookup
	@FindBy(xpath = "//a[@id = 'nav-link-accountList']")
	WebElement accountListElm; 


	@CacheLookup
	@FindBy(xpath = "//span[text() = 'Create a Wish List']")
	WebElement CreateWishList; 
	//$x("//span[text() = 'Your Account']")

	@CacheLookup
	@FindBy(xpath = "//span[ text() = 'Your Account']")
	WebElement yourAccountElm; 
	//$x("//h2[contains(text(), 'Amazon Pay balance')]")
	//$x("//div[@data-card-identifier = 'AmazonPay']")

	//new Release 
	@CacheLookup
	@FindBy(partialLinkText = "Releases")
	WebElement newReleaseLink;

	@CacheLookup
	@FindBy(xpath = "//div[@id = 'zg_banner_text_wrapper']")
	WebElement newReleasePage;

	@CacheLookup
	@FindBy(xpath = ("//li[@id = 'my-lists-tab']//div[contains(text(),'Your Lists')]"))
	WebElement listPage;


	@FindBy(xpath = "//div[@id = 'wishlist-page']")
	WebElement wishList;

	@FindBy(xpath = "//li[@id = 'my-lists-tab']")
	WebElement wishListTab;

	@FindBy(xpath = ("//div[@class = 'a-section ya-personalized']/div[3]/div[3]//div[@class = 'a-row']"))
	WebElement amazonPayBalanceTab; ///$x("//h2[contains(text(), 'Amazon Pay balance')]")

	@FindBy(xpath = ("//h2[contains(text(), 'Amazon Pay balance')]"))
	WebElement amazonPyBlceText;




	public NavigationAmazonHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils(driver);
		wait = new WebDriverWait(driver, 2000);
	}


	public void navigateToElement(String module) {

		switch(module) {

		case "Create Wish List":
			seleniumUtils.mouseHoverActions(accountListElm, CreateWishList);
			break;
		case "Your Account":
			seleniumUtils.mouseHoverActions(accountListElm, yourAccountElm);
			break;	
		}

	}

	public void validatePage(String page) {

		switch(page) {

		case "wishlist":
			//verify that URL contains WishLists
			if(driver.getCurrentUrl().contains("wishlist")) {
				System.out.println("URL contains: " + page);
			}else System.out.println("URL doesnt contain: " + page);

			String expected = "Your Lists";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id = 'my-lists-tab']")));
			if(wishListTab.isDisplayed()){
				String actual =listPage.getText().trim();
				assertEquals(expected, actual);
				System.out.println(actual +" is Present");

			}
			else System.out.println(page + "not present");


			break;

		case "Amazon Pay balance":	
			String expectedText = "Amazon Pay balance";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'a-section ya-personalized']/div[3]/div[3]")));
			System.out.println("SeleniumUtils is succssfull!");
			String actulText = amazonPyBlceText.getText().trim();
			assertEquals(expectedText, actulText);
			System.out.println(actulText +" is Present");
			break;

		case "new Releases Page":

			String actualText = "Amazon Hot New Releases";
			if(driver.getCurrentUrl().contains("new Releases")) {
				System.out.println("URL contains: " + page);
				assertEquals(newReleasePage.getText(), actualText);
			}else System.out.println("URL doesnt contain: " + page);

			
			break;
		}

	}

	public void navigateTo(String tab) {
		switch(tab)  {
		case "New Releases":
			newReleaseLink.click();

			break;	

		}
		System.out.println(tab + ": Is Clicked!");

	}

}
