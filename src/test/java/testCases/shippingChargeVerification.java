package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;
import pageEvents.ShippingPageEvents;

public class shippingChargeVerification extends BaseTest{
	
	HomePageEvents homepage = new HomePageEvents();
	ShoppingCartPageEvents cart = new ShoppingCartPageEvents();
	ShippingPageEvents shippingPgae = new ShippingPageEvents();
	
	@Test
	public void verifyShippingCharge() throws InterruptedException
	{
	String productName = homepage.verifySSClogo()
	.verifyHomePage()
	.addFirstProductToCart();
	cart.verifyProductIsAdded(productName)
	.verifyShippingCharge()
	.clickCheckoutButton()
	.enterShippingDeatils(productName);
	shippingPgae.applyDiscount("Thankyou15");
	shippingPgae.clickProceedToPay()
	.verifyPaymentPage()
	.checkShippingChargeAtCheckout();
	}

}
