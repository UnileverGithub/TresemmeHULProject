package OthersTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_ContactUsEvents;
import pageEvents.Tres_HomePageEvents;

public class ContactUsTestCases extends BaseTest{

	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	Tres_ContactUsEvents Tres_ContactUsEventsOBJ = new Tres_ContactUsEvents();
	
	@Test
	public void verifyContactUsNumberAndEmailUs() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to tresemme homepage <br>"
				+ "<b>When:</b> navigate to contact us page from footer <br>"
				+ "<b>Then:</b> verify that Toll free number section should present<br>"
		        + "<b>Then:</b> verify that Email Us section should present<br>";
		
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.acceptOntrustCookie()
		.ClickOnContactUsLink();
		Tres_ContactUsEventsOBJ.verifyContactUsTollNoAndEmail();
	}
	
	@Test
	public void verifyContactUsFieldPresence() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to tresemme homepage <br>"
				+ "<b>When:</b> navigate to contact us page from footer <br>"
				+ "<b>Then:</b> verify that Name, Email, Phone number and comment sectio should present<br>";;
		
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.acceptOntrustCookie()
		.ClickOnContactUsLink();
		Tres_ContactUsEventsOBJ.verifyContactUsFormFieldPresence();
	}
	
}
