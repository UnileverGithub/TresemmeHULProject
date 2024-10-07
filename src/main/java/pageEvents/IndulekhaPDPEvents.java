package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.IndulekhaPDPElements;

public class IndulekhaPDPEvents extends IndulekhaPDPElements{

	
	public IndulekhaPDPEvents clickATCFromPDP_Indulekha(String productID)
	{
		logger.info("*********Starting of clickATCFromPDP_Indulekha()**********");
		WebElement btnProductCardImage = driver.findElement(By.xpath("//body[@id='product']//buy-buttons[@product_id='"+productID+"']/button"));
		btnProductCardImage.click();
		logger.info("*********Ending of clickATCFromPDP_Indulekha()**********");
		return this;
	}
	
	
	public IndulekhaPDPEvents verifySkuAddedInCartFromPDP(String skuId)
	{
		logger.info("*********Starting of verifySkuAddedInCart()**********");
		WebElement productNameOnPDP = driver.findElement(By.xpath("//body[@id='product']//buy-buttons[@product_id='"+skuId+"']/parent::div//ancestor::div[@class='product-info__block-list']//h1"));
		String productNameHome = productNameOnPDP.getText();
		WebElement productNameOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//a"));
		String productNameCart = productNameOnCart.getText();
		verifySubStringPresence(productNameCart, productNameHome);
		logger.info("*********Ending of verifySkuAddedInCart()**********");
		return this;
	}
	
	public IndulekhaPDPEvents verifySkuPriceAddedInCart(String skuId)
	{
		logger.info("*********Starting of verifySkuPriceAddedInCart()**********");
		WebElement productPriceOnHome = driver.findElement(By.xpath("//body[@id='product']//buy-buttons[@product_id='"+skuId+"']/parent::div//ancestor::div[@class='product-info__block-list']//sale-price/span[@class='clubed_price1']"));
		String productPriceHome = productPriceOnHome.getAttribute("product_price");
		WebElement productPriceOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//sale-price"));
		String productPriceCart = productPriceOnCart.getText();
		verifySubStringPresence("₹ "+productPriceHome, productPriceCart);	
		logger.info("*********Ending of verifySkuPriceAddedInCart()**********");
		return this;
	}
	
}
