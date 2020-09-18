package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.BaseTest;
import utils.SeleniumUtils;

public class LoginAmazon {
	WebDriver driver;
	BaseTest base = new BaseTest();
	SeleniumUtils navig ;

	@CacheLookup
	@FindBy(xpath = "//div[@id = 'nav-tools']//a[2]")
	WebElement signInButton;
	//signInSubmit
	//@CacheLookup
	@FindBy(xpath = ("//h1[contains(text(), 'Login')]"))
	WebElement loginPage;

	@CacheLookup
	@FindBy(xpath = "//input[@id = 'ap_email']")
	WebElement emailPhoneField;

	@CacheLookup
	@FindBy(id = "continue")
	WebElement continueButton;

	@CacheLookup
	@FindBy(id = "ap_password")
	WebElement passwordField;

	@CacheLookup
	@FindBy(id = "signInSubmit")
	WebElement loginButn;


	@CacheLookup
	///("//a[@id = 'nav-item-signout']/span[@class = 'nav-text']")
	@FindBy(id = "nav-item-signout")
	WebElement logoutButn;

	@CacheLookup
	@FindBy(xpath = "//a[@id = 'nav-link-accountList']")
	WebElement accountListElm; 

	//("//div[@class = 'nav-line-1-container']/span[contains(text(), 'Hello, king')]")

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'nav-line-1-container']/span[contains(text(), 'Hello, king')]")
	WebElement accountOwner; 



	@CacheLookup
	@FindBy(xpath = "//h4[@class = 'a-alert-heading']")
	WebElement ErrorHeader;

	@CacheLookup
	@FindBy(xpath = "//span[@class = 'a-list-item']") 
	WebElement ErrorMessage;

	public LoginAmazon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navig = new SeleniumUtils(driver) ;

	}
	public void navigateToUrl(String url) {
		driver.navigate().to(url);
		System.out.println("navigated to " + url);    
	}

	public void clickOn(String button) {
		switch(button) {
		case "signIn":

			signInButton.click();
			break;

		case "continue":
			continueButton.click();
			break;

		case "login":
			loginButn.click();

			break;

		}

	}

	public String validatePage() {
		String actualPage = null;
		try {
			Thread.sleep(1000);
			 actualPage = loginPage.getText();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		

		return actualPage;
	}

	public void enterDataInInputField(String data, String TextField) {
		switch(TextField) {
		case "phoneOrEmail":
			emailPhoneField.clear();
			emailPhoneField.sendKeys(data);

			break;

		case "password":
			passwordField.clear();
			passwordField.sendKeys(data);

			break;	

		}
		System.out.println(TextField +  " is entered in " + data) ;
	}

	public String validateHeaderErrorMessage() {
		String ActualHeader = ErrorHeader.getText();
		return ActualHeader;
	}

	public String validateErrorMessage() {
		String ExpectedErrorMsg = ErrorMessage.getText();
		return ExpectedErrorMsg;
	}



	public void logout() {
		navig.mouseHoverActions(accountListElm, logoutButn);
	}

	public String validateLoginIn() {
		String accntOwner = accountOwner.getText();
		System.out.println(accntOwner);
		return accntOwner;
	}


}
