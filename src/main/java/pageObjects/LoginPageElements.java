package pageObjects;

public interface LoginPageElements {
	String loginButton = "//button[text()='Login']";
	String loginHeading ="//div[text()='Login / Register']";
	String emailInputBox = "//input[@name='login']";
	String termsAndConditionCheckbox = "//input[@type='checkbox']";
	String continueButton = "//button[text()='Continue']";
	String date = "//input[@type='date']";
	
	//otp
	String otpInputbox ="//input[@id='login']";
	String otpConfirmButton="//button[@title='Check Inbox @yopmail.com']";
	String otpHeading= "(//body[@class='bodyinbox yscrollbar']//div[text()='OTP to Login'])[1]";
	String otpValue= "//h2[contains(text(),'Use OTP')]//span";
	String inboxIframe ="//iframe[@id='ifinbox']";
	String bodyIframe = "//iframe[@id='ifmail']";

	
}
