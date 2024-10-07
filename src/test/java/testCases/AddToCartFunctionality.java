package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;
import pageEvents.WizzySearchEvents;

public class AddToCartFunctionality extends BaseTest{
	
	HomePageEvents homepage = new HomePageEvents();
	ShoppingCartPageEvents cart = new ShoppingCartPageEvents();
	WizzySearchEvents wizzy = new WizzySearchEvents();
	
	@Test
	public void verifyAddToCartFunctionality() throws InterruptedException
	{
	
	String productName = homepage.verifySSClogo()
	.verifyHomePage()
	.addFirstProductToCart();
	cart.verifyProductIsAdded(productName)
	.closeShoppingCart()
	.clickCartIcon()
	.verifyProductIsAdded(productName)
	.updateProductQuantity()
	.decreaseProductQuantity()
	.deleteProductQuantity()
	.closeShoppingCart();   
	
	int productCount = wizzy.verifyGlobalSearchBar()
	.searchProduct("Mask")
	.verifySearchedProductPage();
	//wizzy.verifySearchedProductTitles(productCount, "Mask");
	String wizzyProductName = homepage.addFirstProductToCart();
	cart.verifyProductIsAdded(wizzyProductName)
	.verifyShippingCharge();
	}
}
