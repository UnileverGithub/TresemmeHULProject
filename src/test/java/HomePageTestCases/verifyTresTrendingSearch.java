package HomePageTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_HomePageEvents;

public class verifyTresTrendingSearch extends BaseTest{

	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	
	@Test
	public void verifyMenuNavbarLinksOfTresemme()
	{
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify search box should present<br>"
				+ "<b>And:</b>verify trending search options should be present<br>"
				+ "<b>And:</b>verify trending search options navigation<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage()
		.verifyTrendingSearchSuggestionPresence()
		.verifyTrendingSearchSuggestionNavigation();
		
	}
}
