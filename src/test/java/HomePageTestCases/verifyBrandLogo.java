package HomePageTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_HomePageEvents;

public class verifyBrandLogo extends BaseTest{

	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	
	
	@Test
	public void verifyBrandLogoOfTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify logo should present on top left<br>"
				+ "<b>And:</b> verify logo should navigate to HomePage<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().brandLogoVerification();
	}
}
