package pageObjects.LBP;

public interface ShoppingCartPageElementsLBP {
	String cartSection ="//h2[@class='drawer__heading cart-heading']";
	String DynamicCartProductName = "//td[@class='cart-item__details']//a[contains(text(),'{Dynamic}')]";
	String productQty="//td[@class='cart-item__quantity ']//input[@class='quantity__input']";
	String checkoutButton ="//button[@id='CartDrawer-Checkout']";
	String increaseProductQty = "//td[@class='cart-item__quantity ']//button[@name='plus']";
	String decreaseProductQty = "//td[@class='cart-item__quantity ']//button[@name='minus']";
	String qtyValue = "//div[@class='item_pri_qt']//input[@name='quantity']/following-sibling::span";
	String deleteQty = "//button[contains(@class,'cart-remove-button')]";
	String emptyCartMsg= "//h2[text()='Your cart is empty']";
	String closeShoppingCart= "//button[@class='drawer__close']";
	String cartIcon= "//a[contains(@class,'cart-drawer')] | //a[@id='cart-icon-bubble']";
	String offerPopUp = "//div[@id='desktopBannerWrapped']";
	String offerLaterButton = "//div[@id='desktopBannerWrapped']//button[@id='moe-dontallow_button']";
	String orderTotalHeading = "//div[text()='Order Total']";
	String orderTotalValue = "//div[text()='Order Total']/following-sibling::div";
	String discountTotalHeading = "//div[text()='(-)Items Discount']";
	String discountValue = "//div[text()='(-)Items Discount']/following-sibling::div";
	String shippingChargeValue = "//div[text()='(+)Shipping Charge']/following-sibling::div";
}
