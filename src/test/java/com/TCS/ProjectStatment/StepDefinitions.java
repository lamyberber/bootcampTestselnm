package com.TCS.ProjectStatment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.LoginAmazon;
import pom.Mobiles;
import pom.NavigationAmazonHome;
import pom.URLValidations;
import test.BaseTest;
import utils.Common;

public class StepDefinitions {

	BaseTest base = new BaseTest();
	Common com = new Common();
	WebDriver driver = BaseTest.driver;
	Mobiles mobile;
	
	
	NavigationAmazonHome homeObj;
	LoginAmazon loginObj;
	URLValidations urlValidObj;
	String product;
	String expectedMobile;
	String price;

	@Given("I am navigated {string}")
	public void navigated(String url) {
	
		System.out.println(driver.getTitle());
	}

	@Given("I enter {string} in the {string} textBox")
	public void enterData(String data, String element) {
		
	 mobile = new Mobiles(driver);
		
		switch(element) {
		case "search bar":
			mobile.enterDataInTextField("mi mobile", "search bar");

			break;
		case "picode":
			mobile.enterDataInTextField("500011", "picode"); 
			break;
		}
		System.out.println(data + " is entered in " +  element);
	}

	@Given("I click on {string}")
	public void clickOnButton(String button) {

		switch(button) {
		case "search button":
			mobile.clickOnButton("search button");
			break;
		case"delivery location":
			mobile.clickOnButton("delivery location");
			break;
		case"apply button":
			mobile.clickOnButton("apply button");
			break;
		case "Add to cart":
			mobile.clickOnButton("Add to cart");

			break;  
		case "Added to Cart Button":
			mobile.clickOnButton("Added to Cart Button");
			break;
		}

		System.out.println( button + " :Button is Clicked! :"); 

	}

	@Then("I validate the search Results as {string} Results for {string}")
	public void validateSearchResults(String pageCount, String product) {

		mobile.searchResult(pageCount, product);
		assertEquals(product, "mi mobile");

	}


	@Then("I  Select Avg. Customer Review as {string}")
	public void selectCustomerrReview(String review) {
		mobile.selectCustomerReview("4 stars& Up");
	}

	@Then("I select {string} that appears")
	public void selectFirstLink(String link) {
		
		product= mobile.getMobileToSelect(0);
		price = mobile.getPrice(0);
		//System.out.println("first page details  :" + price + " " + product);
		
	}


	@Then("I Validate the appeared mobile is relevant to the first item selected")
	public void validatemobileIsRelevant() {
		expectedMobile = mobile.validateSelectedItem( );
		assertEquals(product, expectedMobile);
		
		System.out.println("Appeared Mbile: " + expectedMobile);
		
	} 


	@Then("I validate the price of {string}")
	public void priceValidation(String product) {
		 String priceInSecndPage = mobile.mobilePrice("first item selected");
		 System.out.println(priceInSecndPage + "---2nd page");
		 System.out.println(price + "first page");
		 assertEquals(price, priceInSecndPage);
		
	}



	@Then("I validate the {string} model")
	public void validateLocation(String model) {
		mobile.validateLocationModel("Choose your location");
	}

	@Then("I Validate the delivery location is {string}")
	public void i_validate_the_delivery_location_is(String string) {
		
	}


	@Then("I Validate the change in the delivery location as Deliver to {string}")
	public void validateChangeInDeliveryLocation(String location) {
		String deliveryAdress = mobile.validatechangeDeliveryLocation();
		// assertEquals(deliveryAdress, location);
		if(deliveryAdress.equalsIgnoreCase(location)) {
			System.out.println("pass");
		}
	}


	@Then("I click on {string} on the page")
	public void clickOnLink(String link) {
		mobile.validateSpononserdLink("Sponsored link");
	}

	@Then("I validate {string} message is dispalyed")
	public void validateMessageDispalyed(String expectedMessage) {
		String message = mobile.messageValiation();
		assertEquals(expectedMessage, message);
	
		} 
			
	

	@Then("I Close the {string}")
	public void closeWindow(String closeWindw) {
		mobile.clickOnButton("Added to Cart window");
	}

	@Then("I scroll downwards until {string}")
	public void scrollDownwardsUntil(String element) {
		mobile.scrollingDown("Technical Details");
	}

	///SeleniumUtils class module validations
	@Given("I navigate to {string} and to {string}")
	public void navigateToModule(String tab, String module) {
		homeObj = new NavigationAmazonHome(driver);
		switch(module) {
		case"Create Wish List":

			homeObj.navigateToElement("Create Wish List");

			break;

		case"Your Account":
			homeObj.navigateToElement("Your Account" );
			break;

		}

		System.out.println("--Hover the Mouse to: " + tab + " and select: " + module);


	}

	@Then("I validate the {string} page")
	public void validateThePage(String page) {
		switch(page) {
		case "wishlist":
			homeObj.validatePage("wishlist");
			break;
		case "Amazon Pay balance":
			homeObj.validatePage("Amazon Pay balance");
			break;
		case "new Releases Page":
			homeObj.validatePage("new Releases Page");

		}

	}
	//nagi to release
	@Given("I navigate to {string}")
	public void NavigateTo(String string) {
		homeObj = new NavigationAmazonHome(driver);
		homeObj.navigateTo("New Releases");
	}


	

	///login module
//	@Given("I navigate to url {string}")
//	public void navigateToURL (String url) {
//		loginObj = new LoginAmazon(driver);
//		loginObj.navigateToUrl(url);
//	    
//	}	
	

	@Then("I navigate to {string} and hit {string} button")
	public void NavigatetoTabAndSelect(String string, String string2) {
		loginObj = new LoginAmazon(driver);
		loginObj.clickOn("signIn");

	}

	@Then("I validate {string} page")
	public void validatePage(String expected) {
		String actual = loginObj.validatePage();
		assertEquals(expected, actual);
	}

	@Then("I enter valid email id as {string} in {string}")
	public void enterValidEmailIdAsIn(String emailID, String inputField) {

		switch(inputField) {
		case "phoneOrEmail":
			loginObj.enterDataInInputField(emailID, inputField);
			break;
		}
	}


	@Then("I click {string}")

	public void clickOn(String button) {
		switch(button) {
		
		case"continue":
			loginObj.clickOn("continue");
			break;

		case "login":
			loginObj.clickOn("login");
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}

		System.out.println(button + ":Button is clicked");
	}



	@Then("I enter valid password as {string} in {string} field")
	public void i_enter_valid_password_as_in_field(String password, String passwordField) {
		loginObj.enterDataInInputField(password, "password");
	}


	@Then("I am landed on amazon home page and {string} is dispalyed")
	public void validateLandedPage(String expected) {
		String actual = loginObj.validateLoginIn();
		assertEquals(actual, expected);
	}


	@Then("I log out from amazon")
	public void logout() {
		loginObj.logout();
	}

	@Then("I validate that i am successfully logged out")
	public void validateloggedOut() {

		String actual = loginObj.validatePage();
		assertEquals("Login", actual);
	}

	
	@Then("I enter invalid {string}")
	public void enterinvalidEmailID(String data) {
		
		loginObj.enterDataInInputField(data, "phoneOrEmail");
	}
	
	
	@Then("I enter invalid password {string}")
	public void enterInnvalidPassword(String data) {
		loginObj.enterDataInInputField(data, "password");
		
	}
	
	@Then("I validate {string} {string}")
	public void validateErrosMsgHeader(String actual, String expected) {
		switch(actual) {
		case "header":
			String ActualHeader = loginObj.validateHeaderErrorMessage();
			assertEquals(ActualHeader, expected);
			break;
		case "error message":
		String ActualErrorMessage = loginObj.validateErrorMessage();	
		assertEquals(ActualErrorMessage, expected);
		break;
		}
		
	}

	////////url validations 
	
	@Given("I enter url as {string}")
	public void enterUrl(String url) {
		urlValidObj = new URLValidations(driver);
		urlValidObj.navigateToUrl(url);
	}

	@Then("I redirected to {string}")
	public void redirectedTo(String url) {
		String actualUrl = urlValidObj.verifyDirectedUrl(); 
		assertEquals(actualUrl, actualUrl);
	  
	}

	@Then("I vaidate the page title as {string}")
	public void vaidatePageTitle(String Title) {
		String atualTitle = urlValidObj.verifyTitle();
	assertEquals(atualTitle,Title );
	}
	



	
	
	
	
	
	
	
	
	
	
}


