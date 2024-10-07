package pageEvents.LBP;

import org.testng.Assert;

import base.BaseTest;
import pageEvents.ShippingPageEvents;
import pageObjects.ShoppingCartPageElements;
import pageObjects.LBP.ShoppingCartPageElementsLBP;
import utils.ElementFetch;

public class ShoppingCartPageEventsLBP extends BaseTest{
	ElementFetch element = new ElementFetch();
	/*
	 * Add First item to cart
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP verifyProductIsAdded(String product) throws InterruptedException
	{
		logger.info("Verify selected product is added in Cart");
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.cartSection).isDisplayed();
		highlightElement(element.getwebElement("XPATH", ShoppingCartPageElementsLBP.cartSection));
		logger.pass("Cart section is present");
		System.out.println(product);
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.DynamicCartProductName.replace("{Dynamic}", product)).isDisplayed();
		highlightElement(element.getwebElement("XPATH", ShoppingCartPageElementsLBP.DynamicCartProductName.replace("{Dynamic}", product)));
		logger.pass("Selected product: "+product +" is added in Cart");
		String qty= element.getwebElement("XPATH", ShoppingCartPageElementsLBP.productQty).getAttribute("value");
		Assert.assertEquals(qty, "1", "Qty is matching");
		highlightElement(element.getwebElement("XPATH", ShoppingCartPageElementsLBP.productQty));
		logger.pass("Selected product QTY is 1");
		return this;
	} 
	
	
	/*
	 * Click checkout button
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShippingPageEventsLBP clickCheckoutButton()
	{
		logger.info("Click checkout button");
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.checkoutButton).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.checkoutButton).click();
		logger.pass("Checkout button is clicked");
		return new ShippingPageEventsLBP();
	} 
	
	/*
	 * Update product quantity
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP updateProductQuantity()
	{
		logger.info("Update product quantity");
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.increaseProductQty).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.increaseProductQty).click();
		logger.info("Verify increase product icon");
		/*element.getwebElement("XPATH", ShoppingCartPageElements.qtyValue).isDisplayed();
		String qtyValue = element.getwebElement("XPATH", ShoppingCartPageElements.qtyValue).getAttribute("data-product-quantity");
		System.out.print(qtyValue);
		*/
		String qtyValue= element.getwebElement("XPATH", ShoppingCartPageElementsLBP.productQty).getAttribute("value");
		if(qtyValue.equals("2"))
			logger.pass("Updated quantity to increase 2");
		return this;
	} 
	
	/*
	 * Decrease product quantity
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP decreaseProductQuantity() throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Decrease product quantity");
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.decreaseProductQty).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.decreaseProductQty).click();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.productQty).isDisplayed();
		String qtyValue = element.getwebElement("XPATH", ShoppingCartPageElementsLBP.productQty).getAttribute("value");
		if(qtyValue.equals("1"))
				logger.pass("Quantity has been decreased to 1");
		return this;
	} 
	

	/*
	 * Delete product quantity
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP deleteProductQuantity() throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Delete product quantity");
		Thread.sleep(3000);
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.deleteQty).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.deleteQty).click();
		logger.pass("Product has been deleted from cart");
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.emptyCartMsg).isDisplayed();
		logger.pass("Empty cart message is present: Your cart is empty");
		return this;
	} 
	
	/*
	 * Click cart icon
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP clickCartIcon() throws InterruptedException
	{
		logger.info("Click cart icon");
		Thread.sleep(2000);
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.cartIcon).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.cartIcon).click();
		logger.pass("Clicked cart icon");
		return this;
	} 
	
	
	/*
	 * Close shopping cart
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP closeShoppingCart() throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Close shopping cart");
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.closeShoppingCart).isDisplayed();
		element.getwebElement("XPATH", ShoppingCartPageElementsLBP.closeShoppingCart).click();
		logger.pass("Shopping cart is successfully closed");
		return this;
	} 
	
	
	/*
	 * Verify shipping charge
	 * Parameters : None
	 * Created By : Sonam
	 */
	public ShoppingCartPageEventsLBP verifyShippingCharge()
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
