package pom;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;
import utils.Common;
import utils.SeleniumUtils;


public class Mobiles {
	WebDriver driver;
	BaseTest base =  new BaseTest();
	Common com = new Common();

	SeleniumUtils utils;
	String product;
	String expectedProduct;
	WebDriverWait wait ;
	String SponserdName;


	public Mobiles(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1000);
		utils = new SeleniumUtils(driver); //ask ramesh if this is the good approcah	
	}


	//@CacheLookup

	@FindBy(xpath = "//input[@name = 'submit.add-to-cart']")
	WebElement addToCartButton; 




	@FindBy(xpath = "//a[@id = 'attach-close_sideSheet-link']")
	WebElement cartCloseButton; 

	@CacheLookup
	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	WebElement searchBar;

	///@CacheLookup   //$x("//input[@type = 'submit']")
	@FindBy(xpath = ("//h1[@class = 'a-size-medium a-spacing-small']"))
	WebElement techqueDetails;


	@CacheLookup   //$x("//input[@type = 'submit']")
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement searchButton;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'a-section a-spacing-small a-spacing-top-small']")
	WebElement result;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'a-section a-spacing-small a-spacing-top-small']//span[1]")
	WebElement resultCount;

	@CacheLookup
	@FindBy(xpath = "//span[@class = 'a-color-state a-text-bold']")
	WebElement proudctName;

	@CacheLookup
	@FindBy(xpath = "//div[@id = 'reviewsRefinements']//ul//li[1]")
	WebElement customerReview4;



	@CacheLookup
	@FindBy(xpath = "//div[@id = 'sp_hqp_shared_inner']//a")
	WebElement sponsoredLink;

	//@CacheLookup
	@FindBy(xpath = "//iframe[@id='ape_Detail_hero-quick-promo_Desktop_iframe']")
	WebElement sponsoredFrame ;

	@FindBy(xpath = "//iframe[@id='ape_Detail_customer-reviews-top_Glance_iframe']")
	WebElement sponsoredFrame2 ;

	//	@CacheLookup
	//	@FindBy(xpath = "//div[@span = 'a-size-medium a-color-base a-text-normal']")
	//	WebElement firstLink1;
	//
	//	@CacheLookup
	//	@FindBy(xpath = "//h2[@class = 'a-size-mini a-spacing-none a-color-base s-line-clamp-4']")
	//	WebElement firstLink;


	//@CacheLookup   
	@FindBy(id = "priceblock_ourprice")  
	WebElement itemPrice;
	///
	@CacheLookup
	@FindBy(xpath = "//span[@id = 'productTitle']")
	WebElement itemSelected;

	//	@CacheLookup
	//	@FindBy(xpath = "//span[@id = 'contextualIngressPtLabel']")
	//	WebElement deliveryAddress;

	@CacheLookup
	@FindBy(xpath = "//div[@id = 'contextualIngressPtLabel_deliveryShortLine']//span[2]")
	WebElement deliveryAddress;

	//@CacheLookup
	@FindBy(xpath = "//span[@id = 'glow-ingress-line2']")
	WebElement deliveryAdressinTop;

	//@CacheLookup
	//@FindBy(xpath = "//div[@id = 'a-popover-6']")
	@FindBy(xpath = "//div[starts-with(@id = 'a-popover-']")
	WebElement popUpWindowDelivry;


	//@CacheLookup
	
	@FindBy(xpath = "//h4[contains(@id, 'a-popover-header')]")
	WebElement titleOfWindow;

	//@CacheLookup
	@FindBy(xpath = "//input[@id = 'GLUXZipUpdateInput']")
	WebElement picodeTextField;

	@CacheLookup
	@FindBy(xpath = "//span[@id = 'GLUXZipUpdate']/span/input")
	WebElement applyButton;

	//@CacheLookup
	@FindBy(xpath = "//div[@id ='attachDisplayAddBaseAlert']//h4")
	WebElement addedTocartElm;

	//@CacheLookup
	@FindBy(xpath = ("//div[@id = 'huc-v2-order-row-confirm-text']//h1"))
	WebElement addedTocart2;

	@CacheLookup
	@FindBy(xpath = "//*[contains(text(), 'Added to Cart')]")
	WebElement addedTocartelment;


	///get first mobile to be selected
	public String getMobileToSelect(int itemNumber) {

		List<WebElement> products =  driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
		for(int i = 0; i<=products.size() ; i++) {

			try {
				Thread.sleep(2000);
				products.get(itemNumber).click();
				product = products.get(itemNumber).getText();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Item at inex " + itemNumber + "--"+product + " is selected!");

			break;
		}
		return product; 

	}



	//get product price
	public String getPrice(int itemNumber) {
		String price = null;
		List<WebElement> mobilePrices =  driver.findElements(By.xpath("//span[@class = 'a-price-whole']"));
		for(int i = 0; i<=mobilePrices.size() ; i++) {

			try {
				Thread.sleep(2000);
				String price1 = mobilePrices.get(itemNumber).getText();
				price = price1.concat(".00");


			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

			System.out.println("price of of the selected Item  :" + product +"--" +  "--"+ price);
			break;
		}
		return price;
	}


	public void selectCustomerReview(String review) {
		switch(review) {
		case "4 stars & Up":

			customerReview4.click();

			break;
		}
		System.out.println(review +  ": Review is Selected!");
	}


	public String validateSelectedItem() {
		utils = new SeleniumUtils(driver); 
		utils.switchToNewTab(1);
		expectedProduct = itemSelected.getText();
		return expectedProduct;	
	}

	public String mobilePrice(String product) {
		String price = null;
		String priceText = itemPrice.getText();
		String[] arrPrice = priceText.split(" ");
		price = arrPrice[1];


		return price;

	}

	public void validateLocationModel(String expectedTitle) { 
		//wait = new WebDriverWait(driver, 1000);
		switch(expectedTitle) {
		case "Choose your location":
			//wait.until(ExpectedConditions.visibilityOf(popUpWindowDelivry));
			String actualTitle = titleOfWindow.getText();
			System.out.println(actualTitle + " is the actaul title ");
			assertEquals(actualTitle, expectedTitle);
             System.out.println("passed!");
			break;

		}
	}



	public String validatechangeDeliveryLocation() { 
		String location = deliveryAdressinTop.getText();
		System.out.println("Location is: " + location);
		return location;

	}


	public void enterDataInTextField(String data, String element) {
		wait = new WebDriverWait(driver, 2000);
		switch(element) {
		case "search bar":
			searchBar.sendKeys(data);
			break;
		case "picode":

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'GLUXZipUpdateInput']")));
			picodeTextField.sendKeys(data);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			break;


		}
	}


	public void clickOnButton(String button) {
		switch(button) {

		case "search button":
			searchButton.click();

			break;

		case "delivery location":
			deliveryAdressinTop.click();

			break;

		case "apply button":
			applyButton.click();

			break;
		case "Add to cart":
			try {

				Thread.sleep(2000);
				addToCartButton.click();
				//driver.findElement(By.xpath("//input[@name = 'submit.add-to-cart']")).click();
			} catch (InterruptedException e) {				
				System.out.println("Add to cart buttn not found ");
			}


			break;

		case "Added to Cart window":
			try {
				cartCloseButton.click();
			}catch(Exception e) {
				//System.out.println(e);
				System.out.println(button + "Is not dispalyed!carryo");
			}

			break;
		}

		System.out.println(button + " is clicked!");
	}


	public void validateSpononserdLink(String product) {
		product = "Sponsored link";
		System.out.println("waiting for frame");
		List webIframe = driver.findElements(By.tagName("iframe"));
		System.out.println(webIframe.size() + " Frame count!");
		try {
			driver.switchTo().frame("ape_Detail_hero-quick-promo_Desktop_iframe");
			//driver.switchTo().frame(sponsoredFrame);
			System.out.println("switched to frame!");
			//Get sponsored link text and store it  in a globale variable for later validatio :
			SponserdName = sponsoredLink.getText();
			//click o the link
			sponsoredLink.click();
			System.out.println("sponsored link clicked! --");
			//navigate to new window  get mobile details and assert valida
			utils.switchToNewTab(2);
			Thread.sleep(1000);
			expectedProduct = itemSelected.getText();
			assertEquals(expectedProduct,SponserdName );
			//and close it 
			driver.close();
			System.out.println("closing the current tab--");
			//switch back to the previous page
			utils.switchToNewTab(1);

		}catch (Exception e) {
			System.out.println("Desired sponsor link  not found");
			//driver.switchTo().frame("ape_Detail_customer-reviews-top_Glance_iframe");

		}
	}




	public void searchResult(String numberOfpage, String itemSelected) {
		String results = result.getText();
		System.out.println(results);
		String pageCount =	resultCount.getText();
		String[] page = pageCount.split("results");
		numberOfpage = page[0];
		System.out.println("Number of Page is : " + numberOfpage);
		itemSelected = proudctName.getText();
		System.out.println(itemSelected);

	}


	public String messageValiation() {
		wait = new WebDriverWait(driver, 2000);
		String expectedMessge = null;

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id ='attachDisplayAddBaseAlert']")));
			Thread.sleep(2000);
			expectedMessge = addedTocartElm.getText();
			System.out.println( "message displayed! :" + expectedMessge);

		} catch(Exception e) {
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'huc-v2-order-row-confirm-text']")));

			expectedMessge = addedTocart2.getText();
			System.out.println( "message displayed!: " + expectedMessge);		
		}


		return expectedMessge;
	}

	public void scrollingDown(String elem) {
		try {

			utils.scrollDownwards(techqueDetails);


		} catch (Exception e) {
			System.out.println("---techqueDetails not Found in the page !");
			e.printStackTrace();

		}

	}

}

