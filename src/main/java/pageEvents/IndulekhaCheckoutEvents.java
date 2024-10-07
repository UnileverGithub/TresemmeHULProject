package pageEvents;


import pageObjects.IndulekhaCheckoutElements;

public class IndulekhaCheckoutEvents extends IndulekhaCheckoutElements{

	
	public IndulekhaCheckoutEvents verifyCheckoutPageIsPresent()
	{
		logger.info("******* Starting of verifyCheckoutPageIsPresent() ******");
		waitTillElementAppear(driver.findElement(txtbx_email));
		driver.findElement(txtbx_email).isDisplayed();
		driver.findElement(btn_PayNow).isDisplayed();
		logger.info("****** Ending of verifyCheckoutPageIsPresent()******");
		return this;
	}
	
	public IndulekhaCheckoutEvents enterContactInfoOnIndulekha(String email,String firstName, String lastName,String address, String City, String state,String pincode, String phone )
    {
		logger.info("****** Starting of enterContactInfoOnIndulekha()******");
    	waitTillElementAppear(driver.findElement(txtbx_email));
    	driver.findElement(txtbx_email).clear();
    	driver.findElement(txtbx_email).sendKeys(email);
    	driver.findElement(txtbx_firstName).sendKeys(firstName);
    	driver.findElement(txtbx_lastName).sendKeys(lastName);
    	driver.findElement(txtbx_address).sendKeys(address);
    	driver.findElement(txtbx_city).sendKeys(City);
    	selectByVisibleText(driver.findElement(ddl_state), state);
    	driver.findElement(txtbx_pinCode).sendKeys(pincode);
    	driver.findElement(txtbx_phoneNo).sendKeys(phone);
    	logger.info("****** Ending of enterContactInfoOnIndulekha()******");
    	return this;
    }
	
	public IndulekhaCheckoutEvents clickOnPayNow() throws InterruptedException
	{
		logger.info("Enter shiping detail");
		waitTillElementIsClickable(driver.findElement(btn_PayNow));
		hover(driver.findElement(btn_PayNow));
		Thread.sleep(4000);
		driver.findElement(btn_PayNow).click();
		Thread.sleep(9000);
		driver.switchTo().frame(driver.findElement(paymentIFrame));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://api.razorpay.com/v1/checkout/hosted"))
		{
			logger.info("Navigated to payment page");
		}
		else
			logger.fail("Not Navigated to payment page");
		logger.info("Enter shiping detail");
		return this;
		
	}
}

