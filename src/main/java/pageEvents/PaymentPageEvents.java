package pageEvents;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pageObjects.PaymentPageElements;
import pageObjects.ShoppingCartPageElements;
import utils.ElementFetch;

public class PaymentPageEvents extends BaseTest{
	ElementFetch element = new ElementFetch();


	/*
	 * Verify payment page
	 * Parameters : None
	 * Created By : Sonam
	 */
	public PaymentPageEvents verifyPaymentPage()
	{
		logger.info("Verify payment page");
		element.getwebElement("XPATH", PaymentPageElements.paymentPageHeading).isDisplayed();
		logger.pass("Payment page is present");
		return this;
	} 
	
	
	/*
	 * click complete order button
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ThankyouPageEvents clickCompleteOrder()
	{
		logger.info("click complete order button");
		element.getwebElement("XPATH", PaymentPageElements.cashOnDeliverRadioButton).isDisplayed();
		element.getwebElement("XPATH", PaymentPageElements.cashOnDeliverRadioButton).click();
		element.getwebElement("XPATH", PaymentPageElements.completeOrderButton).isDisplayed();
		element.getwebElement("XPATH", PaymentPageElements.completeOrderButton).click();
		logger.pass("clicked complete order button");
		return new ThankyouPageEvents();
	} 
	
	/*
	 * Apply discount
	 * Parameters : None
	 * Created By : Sonam
	 */
	public PaymentPageEvents checkShippingChargeAtCheckout() throws InterruptedException
	{
		logger.info("Verify shipping charge");
		element.getwebElement("XPATH", PaymentPageElements.subTotalHeading).isDisplayed();
		String orderTotal = element.getwebElement("XPATH", PaymentPageElements.subTotalValue).getText();
		double orderTotalInt = Double.parseDouble(orderTotal.replace("₹", ""));
		logger.info("Order total amount is: "+orderTotalInt);
		element.getwebElement("XPATH", PaymentPageElements.discountTotalHeading).isDisplayed();
		String discount = element.getwebElement("XPATH", PaymentPageElements.discountValue).getText();
		double discountInt= Double.parseDouble(discount.replace("- ₹", ""));
		logger.info("Discount amount is: "+discountInt);
		double newTotalDouble = orderTotalInt - discountInt;
		int newTotal = Double.valueOf(newTotalDouble).intValue();
		logger.info("New total amount is: "+newTotal);
		String shippingCharge = element.getwebElement("XPATH", PaymentPageElements.shippingChargeValue).getText();
		if(newTotal > 448)
		{
			Assert.assertEquals(shippingCharge, "Free", "Shippinh charge is free");
			logger.pass("Shipping charge is free");
		}
		else if(newTotal < 448)
		{
			Assert.assertEquals(shippingCharge,"49", "Shipping charge is not free");
			logger.pass("Shipping charge is: "+ 49);
		}
		else
		{
			Assert.fail("Shipping charge is incorrect");
		}
		captureScreenshot();
		
		return this;
	} 

}
