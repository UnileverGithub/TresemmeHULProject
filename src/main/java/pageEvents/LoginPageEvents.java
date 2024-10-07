package pageEvents;

import java.util.Set;

import base.BaseTest;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents extends BaseTest{
	ElementFetch element = new ElementFetch();
	
	/*
	 * Login to IAmAvatar web application
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String loginToImAvatar() throws Exception
	{
		String email="testersneha07@yopmail.com";
		//logger.info("Click login button");
		element.getwebElement("XPATH", LoginPageElements.loginButton).click();
		//logger.info("Verify login heading");
		String value= element.getwebElement("XPATH", LoginPageElements.loginHeading).getText();
		String mainWindowHandle = driver.getWindowHandle();
	//	logger.info("Heading is present as" +value);
		element.getwebElement("XPATH", LoginPageElements.emailInputBox).sendKeys(email);
	//	logger.info("Entered value as: 9990609199");
		element.getwebElement("XPATH", LoginPageElements.termsAndConditionCheckbox).click();
	//	logger.info("Clicked Terms & Conditions checkbox");
		element.getwebElement("XPATH", LoginPageElements.continueButton).click();
		BaseTest.openNewTabForYopMail();
		Thread.sleep(5000);
		Thread.sleep(5000);
		String otp= getOTP(mainWindowHandle,email);
		System.out.print(otp); 
	//	logger.info("Clicked continue button");
//		BaseTest.selectDate(element.getwebElement("XPATH", LoginPageElements.date));	
		return otp;
		
	}
	
	/*
	 * Get OTP for logged in user
	 * Parameters : Window_Ids and user email_id
	 * Created By : Sonam
	 */
	public String getOTP(String mainWindowHandle, String email)
	{
		String otp="" ;
		Set<String> allWindowHandles = driver.getWindowHandles();
        // Loop through the window handles to find the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                // Perform actions in the new window
                element.getwebElement("XPATH", LoginPageElements.otpInputbox).isDisplayed();
                element.getwebElement("XPATH", LoginPageElements.otpInputbox).sendKeys(email);
                element.getwebElement("XPATH", LoginPageElements.otpConfirmButton).click();
                BaseTest.switchToIframe(element.getwebElement("XPATH", LoginPageElements.inboxIframe));
                element.getwebElement("XPATH", LoginPageElements.otpHeading).isDisplayed();
                element.getwebElement("XPATH", LoginPageElements.otpHeading).click();
                BaseTest.navigateOutFromFrame();
                BaseTest.switchToIframe(element.getwebElement("XPATH", LoginPageElements.bodyIframe));
                otp = element.getwebElement("XPATH", LoginPageElements.otpValue).getText();
                BaseTest.navigateOutFromFrame();
                driver.close();
                // Switch back to the main window
                driver.switchTo().window(mainWindowHandle);
            }
        }
		return otp;
    }
	
}
