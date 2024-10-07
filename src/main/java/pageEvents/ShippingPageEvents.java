package pageEvents;

import org.testng.Assert;

import base.BaseTest;
import pageObjects.ShippingPageElements;
import pageObjects.ShoppingCartPageElements;
import utils.ElementFetch;

public class ShippingPageEvents extends BaseTest{
	ElementFetch element = new ElementFetch();
	/*
	 * Enter shipping detail information
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShippingPageEvents enterShippingDeatils(String product) throws InterruptedException
	{
		logger.info("Enter shiping detail");	
		element.getwebElement("XPATH", ShippingPageElements.emailInputBox).sendKeys("Testingssc1@gmail.com");
		logger.pass("Enter email_id as : Testinglbp@gmail.com");
		element.getwebElement("XPATH", ShippingPageElements.pincodeInputBox).sendKeys("110045");
		logger.pass("Enter pincode as : 110045");
		element.getwebElement("XPATH", ShippingPageElements.firstnameInputBox).sendKeys("Test");
		logger.pass("Enter first name as : Test");
		element.getwebElement("XPATH", ShippingPageElements.lastnameInputBox).sendKeys("Test");
		logger.pass("Enter last name as : Test");
		element.getwebElement("XPATH", ShippingPageElements.addressInputBox).sendKeys("Testing address");
		logger.pass("Enter address 1 as : Testing address");
		element.getwebElement("XPATH", ShippingPageElements.addressTwoInputBox).sendKeys("Testing address");
		logger.pass("Enter address 2 as : Testing address");
		Thread.sleep(2000);
		element.getwebElement("XPATH", ShippingPageElements.phoneNumberInputBox).sendKeys("9990609199");
		logger.pass("Enter phone number as : 9990609199");
		String productText = element.getwebElement("XPATH", ShippingPageElements.shippingProductName).getText();
		Assert.assertEquals(product, productText, "Product is present at shipping detail page");
		logger.pass("This product is present on shipping page: "+product);
		return this;
	} 
	
	/*
	 * Click proceed to pay
	 * Parameters : None
	 * Created By : Sonam
	 */
	public PaymentPageEvents clickProceedToPay() throws InterruptedException
	{
		logger.info("Click proceed to pay button");
		element.getwebElement("XPATH", ShippingPageElements.proceedToPayButton).isDisplayed();
		Thread.sleep(5000);
		jsClick(element.getwebElement("XPATH", ShippingPageElements.proceedToPayButton));
		logger.pass("Clicked proceed to pay button");
		return new PaymentPageEvents();
	} 
	
	
	/*
	 * Apply discount
	 * Parameters : None
	 * Created By : Sonam
	 */
	public double applyDiscount(String discount) throws InterruptedException
	{
		logger.info("Apply discount");
		element.getwebElement("XPATH", ShippingPageElements.discountInputBox).isDisplayed();
		element.getwebElement("XPATH", ShippingPageElements.discountInputBox).sendKeys(discount);
		element.getwebElement("XPATH", ShippingPageElements.discountApplyButton).isDisplayed();
		element.getwebElement("XPATH", ShippingPageElements.discountApplyButton).click();
		Thread.sleep(5000);
		String discountValue = element.getwebElement("XPATH", ShippingPageElements.discountValue).getText();
	    double discountValueDouble = Double.parseDouble(discountValue.replace("- ₹", ""));
		System.out.println(discountValueDouble);
		logger.pass("Applied discount");
		return discountValueDouble;
	} 

	

}
