package pageEvents;


import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseTest;
import pageObjects.AllProductElements;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents  extends BaseTest{
//	public static Logger log; 
	
	
	ElementFetch element = new ElementFetch();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/*
	 * To close faith and preferred language popUp
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents verifySSClogo() throws InterruptedException
	{
		logger.info("Verfiy SSC logo on homepage");
		Thread.sleep(5000);
		element.getwebElement("XPATH", HomePageElements.sscLogo).isDisplayed();
		logger.pass("SSC logo is present");
		return this;
	}
	
	/*
	 * Click LBP logo
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents clickSSClogo() throws InterruptedException
	{
		logger.info("Click LBP logo");
		Thread.sleep(5000);
		element.getwebElement("XPATH", HomePageElements.sscLogo).isDisplayed();
		element.getwebElement("XPATH", HomePageElements.sscLogo).click();
		logger.pass("Clicked LBP logo");
		return this;
	}
	
	
	/*
	 * To verify homepage is getting displayed
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents verifyHomePage()
	{
		logger.info("Verify account Icon on homepage");
		element.getwebElement("XPATH", HomePageElements.accountIcon).isDisplayed();
		logger.pass("Account icon is present");
		logger.info("Verify cart Icon on homepage");
		element.getwebElement("XPATH", HomePageElements.cartIcon).isDisplayed();
		logger.pass("Cart icon is present");
		captureScreenshot();
		return this;
	}
	
	/*
	 * Add First item to cart
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String addFirstProductToCart() throws InterruptedException
	{
		logger.info("Click A2C button");
		Thread.sleep(3000);
		//element.getwebElement("XPATH", HomePageElements.AddToCart).click();
		jsClick(element.getwebElement("XPATH", HomePageElements.AddToCart));
		logger.info("Clicked Add to cart button for first product");
		String productName = element.getwebElement("XPATH", HomePageElements.productName).getAttribute("data-product-title");
		logger.info("Product which is added to cart is: "+productName);
		Thread.sleep(2000);
		captureScreenshot();
		return productName;
	} 
	
	/*
	 * To verify homepage banner
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents verifyHomePageBanner()
	{
		element.getwebElement("XPATH", HomePageElements.homepageBanner).isDisplayed();
		element.getwebElement("XPATH", HomePageElements.bannerText).isDisplayed();
		logger.pass("Offer banner is present");
		return this;
	}
	
	/*
	 * To click homepage banner
	 * Parameters : None
	 * Created By : Sonam
	 */
	public BundleOfferEvents clickHomePageBanner()
	{
		element.getwebElement("XPATH", HomePageElements.homepageShopNow).click();
		logger.pass("Offer banner is clicked");
		return new BundleOfferEvents();
	}
	
	
	
	/*
	 * To verify ticker
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents verifyTicker()
	{
		element.getwebElement("XPATH", HomePageElements.tickerMsg).isDisplayed();
		logger.pass("Ticker is present");
		return this;
	}
	
	

	/*
	 * Click ticker
	 * Parameters : None
	 * Created By : Sonam
	 */
	public BundleOfferEvents clickTicker()
	{
		element.getwebElement("XPATH", HomePageElements.tickerMsg).click();
		logger.pass("Clicked ticker");
		return new BundleOfferEvents();
	}
	
	/*
	 * Click first item
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents clickFirstProduct() throws InterruptedException
	{
		logger.info("Click A2C button");
		element.getwebElement("XPATH", HomePageElements.productBlock).click();
		logger.info("Clicked first product");
		captureScreenshot();
		return this;
	} 
	
	
	/*
	 * Naviagte to URL
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents navigateToUrl(String url) throws InterruptedException
	{
		logger.info("Navigate to URL: "+url);
		element.getwebElement("XPATH", HomePageElements.productBlock).click();
		logger.info("Clicked first product");
		captureScreenshot();
		return this;
	} 
	
	
	/*
	 * Click Super Combos submenu link
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEvents navigateToComboPage() throws InterruptedException
	{
		logger.info("Navigate to Combo page");
		element.getwebElement("XPATH", HomePageElements.productMenuLink).click();
		element.getwebElement("XPATH", HomePageElements.combosLink).click();
		logger.info("Clicked Combos link");
		captureScreenshot();
		return this;
	} 
	
}
