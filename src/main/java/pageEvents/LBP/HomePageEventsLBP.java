package pageEvents.LBP;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageEvents.BundleOfferEvents;
import pageObjects.HomePageElements;
import pageObjects.LBP.HomePageElementsLBP;
import utils.ElementFetch;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomePageEventsLBP  extends BaseTest{
//	public static Logger log; 
	
	
	ElementFetch element = new ElementFetch();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/*
	 * To close faith and preferred language popUp
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEventsLBP verifyLBPlogo() throws InterruptedException
	{
		logger.info("Verfiy lbp logo on homepage");
		Thread.sleep(5000);
		element.getwebElement("XPATH", HomePageElementsLBP.logo).isDisplayed();
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.logo));
		logger.pass("LBP logo is present");
		return this;
	}
	
	/*
	 * Click LBP logo
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEventsLBP clickLBPlogo() throws InterruptedException
	{
		logger.info("Click LBP logo");
		Thread.sleep(5000);
		element.getwebElement("XPATH", HomePageElementsLBP.logo).isDisplayed();
		element.getwebElement("XPATH", HomePageElementsLBP.logo).click();
		logger.pass("Clicked LBP logo");
		return this;
	}
	
	
	/*
	 * To verify homepage is getting displayed
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEventsLBP verifyHomePage()
	{
		logger.info("Verify account Icon on homepage");
		element.getwebElement("XPATH", HomePageElementsLBP.accountIcon).isDisplayed();
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.accountIcon));
		logger.pass("Account icon is present");
		logger.info("Verify cart Icon on homepage");
		element.getwebElement("XPATH", HomePageElementsLBP.cartIcon).isDisplayed();
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.cartIcon));
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
		scrollIntoView(element.getwebElement("XPATH", HomePageElementsLBP.AddToCart));
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.AddToCart));
		jsClick(element.getwebElement("XPATH", HomePageElementsLBP.AddToCart));
		logger.info("Clicked Add to cart button for first product");
		String productName = element.getwebElement("XPATH", HomePageElementsLBP.productName).getText();
		logger.info("Product which is added to cart is: "+productName);
		String convertedProductName= capitalizeWords(productName);
		Thread.sleep(2000);
		captureScreenshot();
		return convertedProductName;
	} 
	
	/*
	 * To verify homepage banner
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEventsLBP verifyHomePageBanner()
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
	public HomePageEventsLBP verifyTicker()
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
	public HomePageEventsLBP clickFirstProduct() throws InterruptedException
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
	public HomePageEventsLBP navigateToUrl(String url) throws InterruptedException
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
	public HomePageEventsLBP navigateToNewLaunchesPage() throws InterruptedException
	{
		logger.info("Navigate to New Launches page");
		element.getwebElement("XPATH", HomePageElementsLBP.shopMenuLink).click();
		element.getwebElement("XPATH", HomePageElementsLBP.newLaunchesLink).click();
		logger.info("Clicked New Launches link");
		captureScreenshot();
		return this;
	} 
	
	/*
	 * Click add to cart from reel section
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String addToCart_Reel() throws InterruptedException
	{
		logger.info("Click A2C button");
		Thread.sleep(3000);
		scrollIntoView(element.getwebElement("XPATH", HomePageElementsLBP.reelHeading));
//		scrollIntoView(element.getwebElement("XPATH", HomePageElementsLBP.reelProductName));
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.reelAddToCartSection));
		jsClick(element.getwebElement("XPATH", HomePageElementsLBP.reelAddToCart));
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.reelAddToCartSection));
		element.getwebElement("XPATH", HomePageElementsLBP.reelAddToCart).click();
		logger.info("Clicked Add to cart button for first product");
		String productName = element.getwebElement("XPATH", HomePageElementsLBP.reelProductName).getText();
		logger.info("Product which is added to cart is: "+productName);
		String convertedProductName= capitalizeWords(productName);
		Thread.sleep(2000);
		captureScreenshot();
		return convertedProductName;
	} 
	
	/*
	 * Click add to cart from reel section
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String addToCart_Spotlight() throws InterruptedException
	{
		logger.info("Click A2C button");
		Thread.sleep(3000);
		//element.getwebElement("XPATH", HomePageElements.AddToCart).click();
		scrollIntoView(element.getwebElement("XPATH", HomePageElementsLBP.spotlightAddToCart));
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.spotlightAddToCart));
		jsClick(element.getwebElement("XPATH", HomePageElementsLBP.spotlightAddToCart));
		logger.info("Clicked Add to cart button for first product");
		String productName = element.getwebElement("XPATH", HomePageElementsLBP.spotlightProductName).getText();
		logger.info("Product which is added to cart is: "+productName);
		String convertedProductName= capitalizeWords(productName);
		Thread.sleep(2000);
		captureScreenshot();
		return convertedProductName;
	} 
	
	/*
	 * Add First item to cart
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String addFirstProductToCart_Collection() throws InterruptedException
	{
		logger.info("Click A2C button");
		Thread.sleep(3000);
		//element.getwebElement("XPATH", HomePageElements.AddToCart).click();
		scrollIntoView(element.getwebElement("XPATH", HomePageElementsLBP.collectionAddToCart));
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.collectionAddToCart));
		jsClick(element.getwebElement("XPATH", HomePageElementsLBP.collectionAddToCart));
		logger.info("Clicked Add to cart button for first product");
		String productName = element.getwebElement("XPATH", HomePageElementsLBP.collectionProductName).getText();
		logger.info("Product which is added to cart is: "+productName);
		String convertedProductName= capitalizeWords(productName);
		Thread.sleep(2000);
		captureScreenshot();
		return convertedProductName;
	} 
	
	
	/*
	 * To verify broken links in footer section
	 * Parameters : None
	 * Created By : Sonam
	 */
	public HomePageEventsLBP verifyBrokenLinks_Footer()
	{
		logger.info("Verify account Icon on homepage");
		 String currentUrl = driver.getCurrentUrl();
		 System.out.print(currentUrl);

		List<WebElement> links= element.getwebElements("XPATH", HomePageElementsLBP.commonFooterLink);
		highlightElement(element.getwebElement("XPATH", HomePageElementsLBP.accountIcon));
		logger.pass("Account icon is present");
		for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                    	logger.fail("Broken link: " + url + " (Status Code: " + responseCode + ")");
                    }
                } catch (Exception e) {
                	logger.fail("Error checking link: " + url + " (" + e.getMessage() + ")");
                }
            }
        }
		return this;
	}

}
