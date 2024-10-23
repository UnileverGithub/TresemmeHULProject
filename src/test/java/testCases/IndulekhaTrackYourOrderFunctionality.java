package testCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaHomepageEvents;

public class IndulekhaTrackYourOrderFunctionality extends BaseTest{

	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();
	public final static String orderID = "IN122247";
	public final static String AWBNo = "28493135778550";
	
	@Test 
	public void verifyTrackOrderFromHeader()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> verify track order icon <br>"
				+ "<b>And:</b> click on track order icon <br>"
				+ "<b>And:</b> verify navigation of track order icon <br>"
				+ "<b>And:</b> verify track your order page<br>"
				+ "<b>And:</b> verify safety advisory text<br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ.verifyTrackOrderIcon()
		.clickOnTrackOrderIcon()
		.verifyTrackOrderPage()
		.verifySafetyAdvisory();	
	}
	
	@Test @Ignore
	public void enterAndVerifyValidTrackDetailsWithOrderID()
	{
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ
		.clickOnTrackOrderIcon()
		.enterOrderIDOrAWB(orderID)
		.verifyTrackingDetails(orderID);
	}
	
	@Test @Ignore
	public void enterAndVerifyValidTrackDetailsWithAWB()
	{
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ
		.clickOnTrackOrderIcon()
		.enterOrderIDOrAWB(AWBNo)
		.verifyTrackingDetails(AWBNo);
	}
	
	@Test @Ignore
	public void enterAndVerifyInValidTrackDetailsWithOrderID()
	{
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ
		.clickOnTrackOrderIcon()
		.enterOrderIDOrAWB("8420ccd23")
		.verifyTrackingDetailsForInvalidOrderID("8420ccd23");
	}
}
