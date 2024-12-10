package HomePageTestCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_HomePageEvents;

public class verifySearchFunctionality extends BaseTest{

	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	public static final String validKeyword = "shampoo";
	public static final String inValidKeyword = "laptop";
	public static final String specialChar= "&&$$@#R4";
	
	@Test @Ignore
	public void verifyValidSearchForTres()
	{
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify search box should present<br>"
				+ "<b>And:</b>enter invalid text in search box<br>"
				+ "<b>And:</b>verify invalid result text should be present<br>"
				+ "<b>And:</b>verify collections for bestseller should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage()
		.clickOnSearchBox()
		.sendTextInSearchBox(validKeyword)
		.verifyValidSearchText(validKeyword);
	}
	
	
	@Test @Ignore
	public void verifyInValidSearchForTres()
	{
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify search box should present<br>"
				+ "<b>And:</b>enter special characters in search box<br>"
				+ "<b>And:</b>verify invalid result text should be present<br>"
				+ "<b>And:</b>verify filter section should be present on left side<br>"
				+ "<b>And:</b>verify search related product should present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage()
		.clickOnSearchBox()
		.sendTextInSearchBox(inValidKeyword)
		.verifyInvalidSearchResultPage(inValidKeyword);
	}
	
	
	@Test
	public void verifySpecialCharacterSearchForTres()
	{
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify search box should present<br>"
				+ "<b>And:</b>enter valid text in search box<br>"
				+ "<b>And:</b>verify result text should be present<br>"
				+ "<b>And:</b>verify collections for bestseller should be present";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage()
		.clickOnSearchBox()
		.sendTextInSearchBox(specialChar)
		.verifyInvalidSearchResultPage(specialChar);
	}
}
