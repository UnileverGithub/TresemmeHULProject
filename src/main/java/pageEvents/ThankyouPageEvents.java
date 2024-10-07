package pageEvents;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pageObjects.ShoppingCartPageElements;
import pageObjects.ThankyouPageElements;
import utils.ElementFetch;


public class ThankyouPageEvents extends BaseTest{
	ElementFetch element = new ElementFetch();
	
	/*
	 * Verify Thank you page
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ThankyouPageEvents verifyThankYouPage() throws InterruptedException
	{
		Thread.sleep(3000);
		element.getwebElement("XPATH", ThankyouPageElements.thankyouPageHeading).isDisplayed();
		return this;
	} 
	
	
	/*
	 * Get order id
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ThankyouPageEvents getOrderId()
	{
		element.getwebElement("XPATH", ThankyouPageElements.orderId).isDisplayed();
		logger.pass("Thank you page is present");
		String orderNumber = element.getwebElement("XPATH", ThankyouPageElements.orderId).getText().trim();
		String orderID = orderNumber.substring(orderNumber.indexOf(' ') + 1);
		logger.pass("Order has been placed with orderID as: " + orderID);
		return this;
	} 
	
}
