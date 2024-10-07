package testCases;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;


public class placeFirstOrder extends BaseTest{
	
	HomePageEvents homepage = new HomePageEvents();
	ShoppingCartPageEvents cart = new ShoppingCartPageEvents();
	
	@Test
	public void placeFirstOrder() throws InterruptedException
	{
	String productName = homepage.verifySSClogo()
	.verifyHomePage()
	.addFirstProductToCart();
	cart.verifyProductIsAdded(productName)
	.clickCheckoutButton()
	.enterShippingDeatils(productName)
	.clickProceedToPay()
	.verifyPaymentPage()
	.clickCompleteOrder()
	.verifyThankYouPage()
	.getOrderId();                
	}

}
