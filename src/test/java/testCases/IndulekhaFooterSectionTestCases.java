package testCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaHomepageEvents;

public class IndulekhaFooterSectionTestCases extends BaseTest{

	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();
	
	@Test @Ignore
	public void verifyFooterProductLinks()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> scroll till footer section<br>"
				+ "<b>And:</b> verify product links<br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp().privacyPolicy("Decline");
		IndulekhaHomePageEventOBJ.verifyFooterProductLink();
	}
	
	@Test @Ignore
	public void verifyFooterHelpLinks()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> scroll till footer section<br>"
				+ "<b>And:</b> verify help links<br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp().privacyPolicy("Decline");
		IndulekhaHomePageEventOBJ.verifyFooterHelpLink();
	}
	
	@Test
	public void verifyFooterContactUsColumn()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> scroll till footer section<br>"
				+ "<b>And:</b> verify contact us section <br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp().privacyPolicy("Decline");
		IndulekhaHomePageEventOBJ.verifyFooterContactUs();
	}
}
