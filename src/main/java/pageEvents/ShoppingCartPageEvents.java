package pageEvents;

import org.testng.Assert;

import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.ShoppingCartPageElements;
import pageObjects.LBP.HomePageElementsLBP;
import pageObjects.LBP.ShoppingCartPageElementsLBP;
import utils.ElementFetch;

public class ShoppingCartPageEvents extends BaseTest{
	ElementFetch element = new ElementFetch();
	/*
	 * Add First item to cart
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents verifyProductIsAdded(String product) throws InterruptedException
	{
		logger.info("Verify selected product is added in Cart");
		clickCartIcon();
		element.getwebElement("XPATH", ShoppingCartPageElements.cartSection).isDisplayed();
		highlightElement(element.getwebElement("XPATH", ShoppingCartPageElements.cartSection));
		logger.pass("Cart section is present");
		System.out.println(product);
		element.getwebElement("XPATH", ShoppingCartPageElements.DynamicCartProductName.replace("{Dynamic}", product)).isDisplayed();
		highlightElement(element.getwebElement("XPATH", ShoppingCartPageElements.DynamicCartProductName.replace("{Dynamic}", product)));
		logger.pass("Selected product: "+product +" is added in Cart");
		String qty= element.getwebElement("XPATH", ShoppingCartPageElements.productQty).getAttribute("value");
		Assert.assertEquals(qty, "1", "Qty is matching");
		highlightElement(element.getwebElement("XPATH", ShoppingCartPageElements.cartSection));
		logger.pass("Selected product QTY is 1");
		return this;
	} 
	
	
	/*
	 * Click checkout button
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShippingPageEvents clickCheckoutButton()
	{
		logger.info("Click checkout button");
		element.getwebElement("XPATH", ShoppingCartPageElements.checkoutButton).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElements.checkoutButton).click();
		logger.pass("Checkout button is clicked");
		return new ShippingPageEvents();
	} 
	
	/*
	 * Update product quantity
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents updateProductQuantity()
	{
		logger.info("Update product quantity");
		element.getwebElement("XPATH", ShoppingCartPageElements.increaseProductQty).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElements.increaseProductQty).click();
		logger.info("Verify increase product icon");
		/*element.getwebElement("XPATH", ShoppingCartPageElements.qtyValue).isDisplayed();
		String qtyValue = element.getwebElement("XPATH", ShoppingCartPageElements.qtyValue).getAttribute("data-product-quantity");
		System.out.print(qtyValue);
		*/
		String qtyValue= element.getwebElement("XPATH", ShoppingCartPageElements.productQty).getAttribute("value");
		if(qtyValue.equals("2"))
			logger.pass("Updated quantity to increase 2");
		return this;
	} 
	
	/*
	 * Decrease product quantity
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents decreaseProductQuantity() throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Decrease product quantity");
		element.getwebElement("XPATH", ShoppingCartPageElements.decreaseProductQty).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElements.decreaseProductQty).click();
		element.getwebElement("XPATH", ShoppingCartPageElements.productQty).isDisplayed();
		String qtyValue = element.getwebElement("XPATH", ShoppingCartPageElements.productQty).getAttribute("value");
		if(qtyValue.equals("1"))
				logger.pass("Quantity has been decreased to 1");
		return this;
	} 
	

	/*
	 * Delete product quantity
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents deleteProductQuantity() throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Delete product quantity");
		Thread.sleep(3000);
		element.getwebElement("XPATH", ShoppingCartPageElements.deleteQty).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElements.deleteQty).click();
		logger.pass("Product has been deleted from cart");
		element.getwebElement("XPATH", ShoppingCartPageElements.emptyCartMsg).isDisplayed();
		logger.pass("Empty cart message is present: Your cart is empty");
		return this;
	} 
	
	/*
	 * Click cart icon
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents clickCartIcon() throws InterruptedException
	{
		logger.info("Click cart icon");
		Thread.sleep(2000);
		if(element.getwebElement("XPATH", ShoppingCartPageElementsLBP.offerPopUp).isDisplayed())
		{
			element.getwebElement("XPATH", ShoppingCartPageElements.offerLaterButton).click();
		}
		element.getwebElement("XPATH", ShoppingCartPageElements.cartIcon).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElements.cartIcon).click();
		logger.pass("Clicked cart icon");
		return this;
	} 
	
	
	/*
	 * Close shopping cart
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents closeShoppingCart() throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Close shopping cart");
		element.getwebElement("XPATH", ShoppingCartPageElements.closeShoppingCart).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElements.closeShoppingCart).click();
		logger.pass("Shopping cart is successfully closed");
		return this;
	} 
	
	
	/*
	 * Verify shipping charge
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEvents verifyShippingCharge()
	{
		logger.info("Verify shipping charge");
		element.getwebElement("XPATH", ShoppingCartPageElements.orderTotalHeading).isDisplayed();
		String orderTotal = element.getwebElement("XPATH", ShoppingCartPageElements.orderTotalValue).getText();
		int orderTotalInt = Integer.parseInt(orderTotal.replace("₹", ""));
		logger.info("Order total amount is: "+orderTotalInt);
		element.getwebElement("XPATH", ShoppingCartPageElements.discountTotalHeading).isDisplayed();
		String discount = element.getwebElement("XPATH", ShoppingCartPageElements.discountValue).getText();
		int discountInt= Integer.parseInt(discount.replace("₹", ""));
		logger.info("Discount amount is: "+discountInt);
		int newTotal = orderTotalInt - discountInt;
		logger.info("New total amount is: "+newTotal);
		String shippingCharge = element.getwebElement("XPATH", ShoppingCartPageElements.shippingChargeValue).getText();
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
