package testCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaHomepageEvents;

public class IndulekhaLoginPageVerification extends BaseTest{

	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();
	public final static String emailAddress = "UnileverTesting01@gmail.com";
	public final static String password = "Testing@123";
	
	@Test 
	public void verifyLoginpage()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> verify login icon <br>"
				+ "<b>And:</b> click on login button <br>"
				+ "<b>And:</b> verify navigation of login button <br>"
				+ "<b>And:</b> verify sign in with facebook button<br>"
				+ "<b>And:</b> verify sign in with google button <br>"
				+ "<b>And:</b>  Verify email textbox should be present <br>"
				+ "<b>And:</b>  verify password textbox should be present <br>"
				+ "<b>And:</b>  verify login button should be present <br>"
				+ "<b>Then:</b> verify sign up link should be present <br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ.clickOnLogin().verifyLoginPageLinks();
	}
	
	@Test @Ignore
	public void verifyLoginWithValidDetails() throws InterruptedException
	{
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> verify login icon <br>"
				+ "<b>And:</b> click on login button <br>"
				+ "<b>And:</b> verify navigation of login button <br>"
				+ "<b>And:</b> enter valid email address<br>"
				+ "<b>And:</b> enter valid password <br>"
				+ "<b>And:</b> click on log in button <br>"
				+ "<b>And:</b> verify my account page should open<br>";
		logger.info(message);
		
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ.clickOnLogin().enterAndVerifyLoginWithValidCred(emailAddress, password);
		
	}
	
	@Ignore
	public void verifyLoginWithInValidEmail() throws InterruptedException
	{
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> verify login icon <br>"
				+ "<b>And:</b> click on login button <br>"
				+ "<b>And:</b> verify navigation of login button <br>"
				+ "<b>And:</b> enter invalid email address<br>"
				+ "<b>And:</b> enter valid password <br>"
				+ "<b>And:</b> click on log in button <br>"
				+ "<b>And:</b> <br>";
		logger.info(message);
		
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ.clickOnLogin().enterAndVerifyLoginWithValidCred(emailAddress, password);
		
	}
}
