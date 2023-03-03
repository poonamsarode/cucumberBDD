package vit.Aoutomation.stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vit.Aoutomation.pageObjects.LandingPageObjects;
import vit.Aoutomation.pageObjects.ProductDescPageObject;
import vit.Aoutomation.pageObjects.ProductListingPageObjects;

public class StepDef {
	private static final Logger logger = LogManager.getLogger(StepDef.class);

	    Scenario scn;
	    WebDriver driver;
	    String base_url = "https://amazon.in";
	    int implicit_wait_timeout_in_sec = 20;
		 WebDriverWait webDriverWait;
		 
		 LandingPageObjects landingPageObjects;
		 ProductListingPageObjects productListingPageObjects;
		 ProductDescPageObject productDescPageObject;

@Before
public void Setup(Scenario scn)
{
	this.scn = scn ;
	driver = new ChromeDriver();
	webDriverWait = new WebDriverWait(driver,20);
	 logger.info("Browser got set" );
    driver.manage().window().maximize();
    logger.info("Browser got maximized" );
    driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    logger.info("Browser implicit timeout set to -> " + implicit_wait_timeout_in_sec);
    scn.log("Browser got invoked");
    
    // Initialize Class objects 
    
    landingPageObjects = new LandingPageObjects(driver, webDriverWait);
    productListingPageObjects = new ProductListingPageObjects(driver, webDriverWait);
    productDescPageObject = new ProductDescPageObject(driver,webDriverWait);
}
@After
public void tearDown ()
{
	driver.quit();
    logger.info("Browser got closed" );
	scn.log("Browser got closed");
}

/*@Given("User opened browser")
public void user_opened_browser() 
{
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
   
}*/

@Given("User navigated to the landing page of application")
public void user_navigated_to_the_landing_page_of_application() {
/*	 driver.get(base_url);
	 logger.info("Browser got invoked with url as - > "+ base_url );
     String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
     String actual =driver.getTitle();
     Assert.assertEquals("Page Title validation",expected,actual);
	 logger.info("Assertion for page title validation is passed with expected as -> " + expected + "and actual as ->" +actual    );*/
	landingPageObjects.validateUserIsOnlandingPage(base_url);
     scn.log("User navigated to the landing page of application");
}
@When("User Search for product {string}")
public void user_search_for_product(String productName) {	
    //Wait and Search for product
 /*   WebDriverWait webDriverWait = new WebDriverWait(driver,20);
	 logger.info(" webDriverWait time out set to ->" + 20 );
    WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
	 logger.info("waiting for WebElement - > elementSearchBox to be clickable");
    elementSearchBox.sendKeys(productName);
    logger.info("sending keys into WebElement -> elementSearchBox ");
    driver.findElement(By.xpath("//input[@value='Go']")).click();
    logger.info("clicking on the search button "); */
	landingPageObjects.searchProduct(productName);
    scn.log("User Searched for product "); 
       
}
@Then("Search Result page is displayed")
public void search_result_page_is_displayed(String productName ) {
	
	//Wait for title
 /*   WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
    webDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : "+productName+""));

    //Assertion for Page Title
    Assert.assertEquals("Page Title validation","Amazon.in : "+productName+"", driver.getTitle());*/
	productListingPageObjects.validateSearchResult(productName);
    scn.log("Search Result page is displayed");
}
/*@Then("browser is closed")
public void browser_is_closed()
{
	driver.quit();
}*/

@When("User click on any product")
public void user_click_on_any_product() {
/*	  //listOfProducts will have all the links displayed in the search box
    List<WebElement> listOfProducts = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));

    //But as this step asks click on any link, we can choose to click on Index 0 of the list
    listOfProducts.get(0).click();*/
	productDescPageObject.clickOnAnyProduct();
    scn.log("User click on  product");
} 


@Then("Product Description is displayed in new tab")
public void product_description_is_displayed_in_new_tab() {
	
	 //As product description click will open new tab, we need to switch the driver to the new tab
    //If you do not switch, you can not access the new tab html elements
    //This is how you do it
    Set<String> handles = driver.getWindowHandles(); // get all the open windows
    Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
    String original = it.next();//gives the parent window id
    String prodDescp = it.next();//gives the child window id

    driver.switchTo().window(prodDescp); // switch to product Descp

    //Now driver can access new driver window, but can not access the orignal tab
    //Check product title is displayed
    WebElement productTitle = driver.findElement(By.id("productTitle"));
    Assert.assertEquals("Product Title",true,productTitle.isDisplayed());

    WebElement addToCartButton = driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
    Assert.assertEquals("Product Title",true,addToCartButton.isDisplayed());

    //Switch back to the Original Window, however no other operation to be done
    driver.switchTo().window(original);
    scn.log("Product Description is displayed in new tab");
    
    }







}
