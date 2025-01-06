package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import pageObjects.IndulekhaHomeElement;
import pageObjects.IndulekhaLoginPageElements;

public class IndulekhaLoginPageEvents extends IndulekhaLoginPageElements{
	
	IndulekhaHomeElement IndulekhaHomeElementOBJ = new IndulekhaHomeElement();
	
	/*
	 * Author: Renu
	 * method: verifyLoginPageLinks
	 */
	public IndulekhaLoginPageEvents verifyLoginPageLinks()
	{
		driver.findElement(txtbox_email).isDisplayed();
		logger.info("Email textbox is present");
		driver.findElement(txtbox_password).isDisplayed();
		logger.info("Passport textbox is present");
		driver.findElement(btnLogin).isDisplayed();
		logger.info("Login button is present");
		driver.findElement(lnkSingUp).isDisplayed();
		logger.info("Sign up is present");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: enterAndVerifyLoginWithValidCred
	 */
	public IndulekhaLoginPageEvents enterAndVerifyLoginWithValidCred(String email, String password) throws InterruptedException
	{
		waitTillElementAppear(driver.findElement(txtbox_email));
		waitTillElementIsClickable(driver.findElement(txtbox_email));
		waitTillElementAppear(driver.findElement(btnLogin));
		driver.findElement(txtbox_email).sendKeys(email);
		driver.findElement(txtbox_password).sendKeys(password);
		waitTillElementIsClickable(driver.findElement(btnLogin));
		Thread.sleep(7000);
		//driver.findElement(btnLogin).sendKeys(Keys.ENTER);
		jsClick(driver.findElement(btnLogin));
		//driver.findElement(btnLogin).jsC();
		Assert.assertEquals(driver.getTitle(), "Account");
		verifyHeading("Your account");
		return this;
	}
	
}
