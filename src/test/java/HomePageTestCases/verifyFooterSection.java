package HomePageTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_HomePageEvents;

public class verifyFooterSection extends BaseTest{

	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	
	@Test 
	public void verifyFooterProductLinksTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify footer section product links<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().acceptOntrustCookie()
		.verifyFooterSectionLinks("Product Links");
	}
	
	
	@Test
	public void verifyFooterQuickLinksTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify footer section quick links<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().acceptOntrustCookie()
		.verifyFooterSectionLinks("Quick Links");
	}
	
	@Test
	public void verifyFooterLegalLinksTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify footer section legal links<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().acceptOntrustCookie()
		.verifyFooterSectionLinks("Legal");
	}
	
	@Test 
	public void verifyFooterSocialLinksTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify footer section social media links<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().acceptOntrustCookie()
		.verifySocialMediaFooterLinks();
	}
	
	@Test
	public void verifySafetyCaution()
	{
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify footer section safety caution<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().acceptOntrustCookie()
		.verifySafetyCautionNotice();
	}
	
}
