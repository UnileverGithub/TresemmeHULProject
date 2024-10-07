package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaCheckoutEvents;
import pageEvents.IndulekhaHomepageEvents;

public class IndulekhaCheckoutFromHomePage extends BaseTest{
	
	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();
	IndulekhaCheckoutEvents IndulekhaCheckoutEventOBJ  = new IndulekhaCheckoutEvents();
	public static final String skuID = "7459089907757";
	public static final String zipCode = "110059";
	public static final String email = "UnileverTesting01@gmail.com"; 
	public static final String pincode ="110059";
	public static final String firstName ="Unilever";
	public static final String lastName = "Testing";
	public static final String address = "Testing";
	public static final String City = "Delhi";
	public static final String state = "Delhi";
	public static final String phone = "8790372838";
	
	
	@Test 
	public void verifyCheckoutFlowFromHomePage() throws InterruptedException
	{
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> go to best pick section <br>"
				+ "<b>And:</b> click on Add to cart button <br>"
				+ "<b>And:</b> verify that side shopping cart should open<br>"
				+ "<b>And:</b> verify sku in cart <br>"
				+ "<b>And:</b>  verify sku price in cart <br>"
				+ "<b>And:</b>  click on checkout <br>"
				+ "<b>And:</b>  verify checkout page should get display <br>"
				+ "<b>Then:</b>  enter contact information <br>"
		 		+ "<b>And:</b>  click on pay Now <br>"
				+ "<b>And:</b>  verify sku price in cart <br>";
		logger.info(message);
	    
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ.gotoBestPickSection().clickOnAddToCart(skuID)
		.verifyShoppingCartShouldOpen()
		.verifySkuAddedInCart(skuID)
		.verifySkuPriceAddedInCart(skuID)
		.clickOnCheckout();
		IndulekhaCheckoutEventOBJ.verifyCheckoutPageIsPresent()
		.enterContactInfoOnIndulekha(email, firstName, lastName, address, City, state, pincode, phone)
		.clickOnPayNow();
	}
}