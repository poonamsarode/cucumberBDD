package vit.Aoutomation.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageObjects {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	
	// sec1 declare a driver object 
	private WebDriver driver ;
	private WebDriverWait webDriverWait;

	//sec2 parametrize constructor 
	public  LandingPageObjects(WebDriver driver , WebDriverWait webDriverWait)
	{
		this.driver = driver;
		this.webDriverWait = webDriverWait;
	}
	//sec3 Define the locaters
	private By searchBoxElement = By.id("twotabsearchtextbox");
	private By searchButtonElement = By.xpath("//input[@value='Go']");
	
	//sec4 write bussiness Methods
		public void searchProduct(String productName )
	{
	     webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
		 logger.info("waiting for WebElement - > elementSearchBox to be clickable");
         driver.findElement(searchBoxElement).sendKeys(productName);
         logger.info("sending keys into WebElement -> elementSearchBox ");
         driver.findElement(searchButtonElement).click();
         logger.info("clicking on the search button ");


	}
	
	
	public void validateUserIsOnlandingPage(String base_url)
	{
	 driver.get(base_url);
     logger.info("Browser got invoked with url as - > "+ base_url );

    String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    String actual =driver.getTitle();
    Assert.assertEquals("Page Title validation",expected,actual);
	 logger.info("Assertion for page title validation is passed with expected as -> " + expected + "and actual as ->" +actual    );
	
	}
	
	
	
	
}
