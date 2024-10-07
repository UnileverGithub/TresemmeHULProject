package testCases.LBP;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;
import pageEvents.WizzySearchEvents;
import pageEvents.LBP.HomePageEventsLBP;
import pageEvents.LBP.ShoppingCartPageEventsLBP;
import pageEvents.LBP.WizzySearchEvents_LBP;
import pageObjects.LBP.HomePageElementsLBP;

public class AddToCartFunctionality_LBP extends BaseTest{
	
	HomePageEventsLBP homepage = new HomePageEventsLBP();
	ShoppingCartPageEventsLBP cart = new ShoppingCartPageEventsLBP();
	WizzySearchEvents_LBP wizzy = new WizzySearchEvents_LBP();
	
	@Test
	public void verifyAddToCartFunctionality_LBP() throws InterruptedException
	{
	
/*	String productName = homepage.verifyLBPlogo()
	.verifyHomePage()
	.addFirstProductToCart();
	cart.clickCartIcon()
	verifyProductIsAdded(productName)
	.closeShoppingCart()
	.clickCartIcon()
	.verifyProductIsAdded(productName)
	.updateProductQuantity()
	.decreaseProductQuantity()
	.deleteProductQuantity()
	.closeShoppingCart();   */	

/*	String spotlightProductName = homepage.addToCart_Spotlight();
	cart.clickCartIcon().verifyProductIsAdded(spotlightProductName)
	.closeShoppingCart(); 
	
	String reelProductName = homepage.addToCart_Reel();
	cart.clickCartIcon()
	.verifyProductIsAdded(reelProductName); */
	
	String productCollectionName = homepage.navigateToNewLaunchesPage()
	.addFirstProductToCart_Collection();
	cart.clickCartIcon()
	.verifyProductIsAdded(productCollectionName); 

	//add to cart from pdp
	//add to cart from blog
	
/*	int productCount = wizzy.verifyGlobalSearchBar()
	.searchProduct("Mask")
	.verifySearchedProductPage();
	//wizzy.verifySearchedProductTitles(productCount, "Mask");
	String wizzyProductName = homepage.addFirstProductToCart();
	cart.verifyProductIsAdded(wizzyProductName)
	.verifyShippingCharge(); */
	}

}
