package HomePageTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_HomePageEvents;

public class verifyMenuNavbar extends BaseTest{


	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	
	
	@Test
	public void verifyMenuNavbarLinksOfTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify logo should present on top left<br>"
				+ "<b>And:</b>verify that menu category and subcategory should work properly<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().verifyMenuNavigation("Hair Care");
		Tres_HomePageEventsOBJ.verifyMenuNavigation("Hair Goals")
		.verifyMenuNavigation("TRES Style");
	}
	
}
