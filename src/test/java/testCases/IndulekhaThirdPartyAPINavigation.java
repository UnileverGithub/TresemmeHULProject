package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaHomepageEvents;

public class IndulekhaThirdPartyAPINavigation extends BaseTest{

	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();
	
	@Test
	public void verifyThirdPartyAPINavigation() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> verify flying whatsapp icon <br>"
				+ "<b>And:</b> verify facebook icon from footer <br>"
				+ "<b>And:</b> verify twitter icon from footer<br>"
				+ "<b>And:</b> verify instagram icon from footer<br>"
				+ "<b>And:</b> verify youtube icon from footer<br>"
				+ "<b>And:</b> verify bebe icon from footer<br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp();
		IndulekhaHomePageEventOBJ.verifySocialMediaIcons();
	}
}
