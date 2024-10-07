package pageObjects;

public interface ShoppingCartPageElements {
	String cartSection ="//div[@class='cart-drawer_top_section']//span[text()=' Order details ']";
	String DynamicCartProductName = "//div[contains(text(),'{Dynamic}')]";
	String productQty="//div[@class='ajax-cart-item__quantity']//input[@name='quantity']";
	String checkoutButton ="//a[@class='button custom_ceckout_']";
	String increaseProductQty = "//span[@field='quantity' and contains(@class,'qtyplus')]";
	String decreaseProductQty = "//span[@field='quantity' and contains(@class,'qtyminus')]";
	String qtyValue = "//div[@class='item_pri_qt']//input[@name='quantity']/following-sibling::span";
	String deleteQty = "//div[contains(@class,'custom_cart_remove')]";
	String emptyCartMsg= "//div[text()='Your cart is empty']";
	String closeShoppingCart= "//span[contains(@class,'custom_cart_close')]";
	String cartIcon= "//a[contains(@class,'cart-drawer')]";
	String offerPopUp = "//div[@id='desktopBannerWrapped']";
	String offerLaterButton = "//div[@id='desktopBannerWrapped']//button[@id='moe-dontallow_button']";
	String orderTotalHeading = "//div[text()='Order Total']";
	String orderTotalValue = "//div[text()='Order Total']/following-sibling::div";
	String discountTotalHeading = "//div[text()='(-)Items Discount']";
	String discountValue = "//div[text()='(-)Items Discount']/following-sibling::div";
	String shippingChargeValue = "//div[text()='(+)Shipping Charge']/following-sibling::div";

}
