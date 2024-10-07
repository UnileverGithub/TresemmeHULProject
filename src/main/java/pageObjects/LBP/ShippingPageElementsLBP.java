package pageObjects.LBP;

public interface ShippingPageElementsLBP {
	String shippingPage="//div[@id='chk__out']";
	String emailInputBox="//label[text()='Email']//following-sibling::input";
	String pincodeInputBox="//label[text()='Delivery Pincode*']//following-sibling::input";
	String firstnameInputBox="//label[text()='First name']//following-sibling::input";
	String lastnameInputBox="//label[text()='Last name']//following-sibling::input";
	String addressInputBox="//label[contains(text(),'Flat, House no.')]//following-sibling::input";
	String addressTwoInputBox="//label[contains(text(),'Apartment, suite,')]//following-sibling::input";
	String phoneNumberInputBox ="//label[text()='Phone']//following-sibling::input";
	String proceedToPayButton="//button[@id='continue_button']";
	String shippingProductName ="//th[@class='product__description']//span[contains(@class,'product__description__name')]";
	String discountInputBox = "//input[@placeholder='Discount code']";
	String discountApplyButton = "//button[@id='checkout_submit']";
	String discountValue = "//span[text()='Discount']/following::span[text()='THANKYOU15']/following::span[@data-checkout-discount-amount-target]";

}
