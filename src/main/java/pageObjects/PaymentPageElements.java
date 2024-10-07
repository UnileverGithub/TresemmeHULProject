package pageObjects;

public interface PaymentPageElements {
	String paymentPageHeading= "//span[contains(text(),'Payment')]";
	String cashOnDeliverRadioButton = "//input[@id='checkout_payment_gateway_65241972899']";
	String completeOrderButton = "//div[contains(@class,'show')]//button[@id='continue_button']";
	
	String subTotalHeading = "//th[text()='Subtotal']";
	String subTotalValue = "//th[text()='Subtotal']/following-sibling::td//span";
	String discountTotalHeading = "//span[text()='Discount']/following::span[text()='THANKYOU15']";
	String discountValue = "//span[text()='Discount']/following::span[text()='THANKYOU15']/following::span[@data-checkout-discount-amount-target]";
	String shippingChargeValue = "//span[contains(text(),'Shipping')]/../following::td//span[@data-checkout-total-shipping-target]";



}
