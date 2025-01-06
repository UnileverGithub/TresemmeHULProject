package pageEvents;

import org.testng.Assert;

import pageObjects.TresContactUsElements;

public class Tres_ContactUsEvents extends TresContactUsElements{

	
	public Tres_ContactUsEvents verifyContactUsTollNoAndEmail()
	{
		waitTillElementAppear(driver.findElement(txt_Heading));
		Assert.assertEquals(driver.findElement(txt_Heading).getText(), "Contact Us");
		driver.findElement(lnk_TelNo).isDisplayed();
		Assert.assertEquals(driver.findElement(lnk_TelNo).getText(), "1800 102 2221");
		driver.findElement(img_TelNoIcon).isDisplayed();
		driver.findElement(lnk_Email).isDisplayed();
		Assert.assertEquals(driver.findElement(lnk_Email).getText(), "lever.care@unilever.com");
		return this;
	}
	
	public Tres_ContactUsEvents verifyContactUsFormFieldPresence()
	{
		waitTillElementAppear(driver.findElement(txtBox_Name));
		waitTillElementAppear(driver.findElement(txtBox_Email));
		waitTillElementAppear(driver.findElement(txtBox_PhoneNum));
		waitTillElementAppear(driver.findElement(txtBox_Comment));
		return this;
	}
}
