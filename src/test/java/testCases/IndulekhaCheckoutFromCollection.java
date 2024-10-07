package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaCheckoutEvents;
import pageEvents.IndulekhaHomepageEvents;
import pageEvents.IndulekhaPDPEvents;

public class IndulekhaCheckoutFromCollection extends BaseTest{

	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();
	IndulekhaCheckoutEvents IndulekhaCheckoutEventOBJ  = new IndulekhaCheckoutEvents();
	IndulekhaPDPEvents IndulekhaPDPEventsOBJ = new IndulekhaPDPEvents();
	public static final String skuID = "7459089023021";
	public static final String zipCode = "110059";
	public static final String email = "UnileverTesting01@gmail.com";
	public static final String pincode ="110059";
	public static final String firstName ="Unilever";
	public static final String lastName = "Testing";
	public static final String address = "Testing";
	public static final String City = "Delhi";
	public static final String state = "Delhi";
	public static final String phone = "8790372838";
	public static final String category = "all_products";
	public static final String subCategory = "Shampoo";
	
	@Test
	public void verifyCheckoutFlowFromPDPPage() throws InterruptedException
	{
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> go to best pick section <br>"
				+ "<b>And:</b> click on all product from global navbar <br>"
				+ "<b>And:</b> click on any sub category<br>"
				+ "<b>And:</b> click on Add to cart<br>"
				+ "<b>And:</b> verify sku in cart <br>"
				+ "<b>And:</b>  verify sku price in cart <br>"
				+ "<b>And:</b>  click on checkout <br>"
				+ "<b>And:</b>  verify checkout page should get display <br>"
				+ "<b>Then:</b>  enter contact information <br>"
		 		+ "<b>And:</b>  click on pay Now <br>"
				+ "<b>And:</b>  verify sku price in cart <br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp()
		.clickOnGlobalNavbarCategory(category)
		.clickOnGlobalNavbarSubCategory(category, subCategory);
		String skuTitle = IndulekhaHomePageEventOBJ.getProductTitleFromCollection(skuID);
		String skuPrice = IndulekhaHomePageEventOBJ.getProductPriceFromCollection(skuID);
		IndulekhaHomePageEventOBJ.clickOnATCFromInduCollection(skuID)
		.verifyShoppingCartShouldOpen()
		.verifySkuAddedInCartForCollection(skuID, skuTitle)
		.verifySkuPriceAddedInCartForCollection(skuID, skuPrice)
		.clickOnCheckout();
		IndulekhaCheckoutEventOBJ.verifyCheckoutPageIsPresent()
		.enterContactInfoOnIndulekha(email, firstName, lastName, address, City, state, pincode, phone)
		.clickOnPayNow();
		
	}
}
