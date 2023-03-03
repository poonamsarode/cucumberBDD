package vit.Aoutomation.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPageObjects {
	
	private static final Logger logger = LogManager.getLogger(ProductListingPageObjects.class);

	// sec1 declare a driver object 
		private WebDriver driver ;
		private WebDriverWait webDriverWait;
		
	//sec2 parametrize constructor 
		public ProductListingPageObjects (WebDriver driver , WebDriverWait webDriverWait)
		{
			this.driver = driver;
			this.webDriverWait = webDriverWait;
		}
		
		//sec3 Define the locaters
	//	private By searchBoxElement = By.id("twotabsearchtextbox");
		
		//sec4 
		public void validateSearchResult(String productName )
		{
			 logger.info("waiting for the page title to contain -> " + productName );
		    webDriverWait.until(ExpectedConditions.titleIs("Amazon.in : "+productName+""));
		    
		    //Assertion for Page Title
		    Assert.assertEquals("Page Title validation","Amazon.in : "+productName+"", driver.getTitle());
		    logger.info(" Assertion passed for validation of search result with product name as -> " + productName );

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
}
