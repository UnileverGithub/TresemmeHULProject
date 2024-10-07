package testCases.LBP;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;
import pageEvents.LBP.HomePageEventsLBP;
import pageEvents.LBP.ShoppingCartPageEventsLBP;

public class PlaceOrder_LBP extends BaseTest{
	
	HomePageEventsLBP homepage = new HomePageEventsLBP();
	ShoppingCartPageEventsLBP cart = new ShoppingCartPageEventsLBP();
	
	@Test
	public void placeFirstOrder() throws InterruptedException
	{
	String productName = homepage.verifyLBPlogo()
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
