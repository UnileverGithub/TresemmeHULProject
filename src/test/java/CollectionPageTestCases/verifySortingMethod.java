package CollectionPageTestCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_CollectionEvents;
import pageEvents.Tres_HomePageEvents;

public class verifySortingMethod extends BaseTest{

	Tres_CollectionEvents Tres_CollectionEventsOBJ = new Tres_CollectionEvents();
	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	
	@Test @Ignore
	public void verifyCollectionSortingAToZMethod() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to Collection page of tresemme <br>"
				+ "<b>When:</b> verify tresemme collection page should display <br>"
				+ "<b>Then:</b> click on sort by<br>"
		        + "<b>Then:</b> select sort by A to Z<br>"
		        + "<b>Then:</b> verify sort by A to Z is working fine<br>";
		
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.clickOnNavMenuCategory("Hair Care")
		.clickOnNavMenuSubCategory("Hair Care", "Shampoo")
		.verifyThatCollectionIsNotEmpty();
		Tres_CollectionEventsOBJ.selectSortByOption("title-ascending")
		.validateSortingAtoZ();
	}
	
	
	@Test @Ignore
	public void verifyCollectionSortingHighToLowMethod() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to Collection page of tresemme <br>"
				+ "<b>When:</b> verify tresemme collection page should display <br>"
				+ "<b>Then:</b> click on sort by<br>"
		        + "<b>Then:</b> select sort by high to low price<br>"
		        + "<b>Then:</b> verify sort by high to low price is working fine<br>";
		
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.clickOnNavMenuCategory("Hair Care")
		.clickOnNavMenuSubCategory("Hair Care", "Conditioner")
		.verifyThatCollectionIsNotEmpty();
		Tres_CollectionEventsOBJ.selectSortByOption("price-descending")
		.validateSortingHighToLowPrice();
	}
	
	
	@Test
	public void verifyCollectionSortingLowToHighMethod() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to Collection page of tresemme <br>"
				+ "<b>When:</b> verify tresemme collection page should display <br>"
				+ "<b>Then:</b> click on sort by<br>"
		        + "<b>Then:</b> select sort by low to high price<br>"
		        + "<b>Then:</b> verify sort by low to high price is working fine<br>";
		
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.clickOnNavMenuCategory("Hair Care")
		.clickOnNavMenuSubCategory("Hair Care", "Conditioner")
		.verifyThatCollectionIsNotEmpty();
		Tres_CollectionEventsOBJ
		.selectSortByOption("price-ascending")
		.validateSortingLowToHighPrice();
	}
}
