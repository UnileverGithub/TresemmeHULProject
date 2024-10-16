package pageObjects;

import org.openqa.selenium.By;

import base.BaseTest;

public class IndulekhaLoginPageElements extends BaseTest{
	
	protected By btn_Facebook = By.xpath("//div[@id='divButtonFb']/button");
	protected By btn_Google = By.xpath("//div[@id='divButtonGoogle']/button");
	protected By txtbox_email = By.xpath("//input[@type='email' and @name='customer[email]']");
	protected By txtbox_password = By.xpath("//input[@type='password' and @name='customer[password]']");
	protected By btnLogin = By.xpath("//button[@type='submit' and contains(text(),'Login')]");
	protected By lnkSingUp = By.xpath("//form[@id='customer_login']//a[text()='Sign up']");
	
	
}
