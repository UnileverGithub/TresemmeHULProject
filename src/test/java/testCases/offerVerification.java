package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;

public class offerVerification extends BaseTest{
	
	HomePageEvents homepage = new HomePageEvents();
	ShoppingCartPageEvents cart = new ShoppingCartPageEvents();
	
	@Test
	public void verifyOffer() throws InterruptedException
	{
	homepage.verifySSClogo()
	.verifyHomePage()
//	.verifyHomePageBanner()
	.verifyTicker()
//	.clickHomePageBanner()
	.clickTicker()
	.verifyBuy3BundleBanner()
	.verifyBundleBannerHeading()
	.verifyBuy3Tag();
	String productName= homepage.addFirstProductToCart();
//	.verifyBuy4Tag();
	cart.verifyProductIsAdded(productName)
	.closeShoppingCart();
	// tag not present on combo
	homepage.navigateToComboPage();
	
	}
}
