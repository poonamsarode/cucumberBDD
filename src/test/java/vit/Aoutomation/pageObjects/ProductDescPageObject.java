package vit.Aoutomation.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDescPageObject {

private static final Logger logger = LogManager.getLogger(ProductDescPageObject.class);
	
	// sec1 declare a driver object 
	private WebDriver driver ;
	private WebDriverWait webDriverWait;

	//sec2 parametrize constructor 
	public  ProductDescPageObject(WebDriver driver , WebDriverWait webDriverWait)
	{
		this.driver = driver;
		this.webDriverWait = webDriverWait;
	}
	//sec3 Define the locaters
//	private By searchBoxElement = By.id("twotabsearchtextbox");
	private By listOfProducts = By.xpath("//span[text()=\"RESULT\"]//ancestor::div[@class='s-main-slot s-result-list s-search-results sg-row']//span[@class='a-size-medium a-color-base a-text-normal']");
	
	//sec4 write bussiness Methods
		public void clickOnAnyProduct()
	{

			  //listOfProducts will have all the links displayed in the search box
		    List<WebElement> FirstProduct = driver.findElements(listOfProducts);

		    //But as this step asks click on any link, we can choose to click on Index 0 of the list
		    FirstProduct.get(0).click();	
	}


	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	

