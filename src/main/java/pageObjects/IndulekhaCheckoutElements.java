package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class IndulekhaCheckoutElements extends BaseTest{

	
	protected By txtbx_email = By.xpath("//input[@id='email']");
	protected By txtbx_firstName = By.xpath("//input[@id='TextField0']");
	protected By txtbx_lastName = By.xpath("//input[@id='TextField1']");
	protected By txtbx_address = By.xpath("//input[@id='shipping-address1']");
	protected By txtbx_city = By.xpath("//input[@name='city']");
	protected By ddl_state = By.xpath("//select[@id='Select1']");
	protected By txtbx_pinCode = By.xpath("//input[@name='postalCode' and @id='TextField4']");
	protected By txtbx_phoneNo = By.xpath("//input[@name='phone' and @id='TextField5']");
	protected By lnk_returnToCart = By.xpath("//span[text()='Return to cart']/ancestor::a");
	protected By btn_PayNow = By.xpath("//button[@id='checkout-pay-button']");
	protected By paymentIFrame = By.xpath("//iframe[@class='razorpay-checkout-frame']");
	
	
	 
    public IndulekhaCheckoutElements()
	    {
	    	PageFactory.initElements(driver,this);
	    }
}

