package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.IndulekhaHomepageEvents;

public class IndulekhaHomePageHeaderNavbar extends BaseTest{
	
	IndulekhaHomepageEvents IndulekhaHomePageEventOBJ = new IndulekhaHomepageEvents();

	@Test
	public void verifyHeadernavigationLinks()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> click on all product dropdown <br>"
				+ "<b>And:</b>  verify links under all product category<br>"
				+ "<b>And:</b>  click on hair concerns category<br>"
				+ "<b>then:</b> verify subcategory under hair concerns category<br>"
				+ "<b>And:</b> 	verify understanding hair loss category<br>"
				+ "<b>And:</b>  verify FAQs category<br>"
				//+ "<b>And:</b>  verify hair quiz category<br>"
				//+ "<b>And:</b>  verify Track order link<br>"
				+ "<b>And:</b>  verify Announcement banner<br>";
		logger.info(message);
		
		navigateToDesiredURL("https://www.indulekha.co.in/");
		IndulekhaHomePageEventOBJ.verifyIndulekhaHomePage().acceptCookiePopUp()
		.verifyAllProductHeaderLinks("all_products")
		.verifyHairConcernHeaderLinks("hair_concerns")
		.verifyNavBarLinks("understanding_hair_loss", "https://www.indulekha.co.in/pages/understanding-hair-loss")
		.verifyNavBarLinks("faqs", "https://www.indulekha.co.in/pages/faqs")
		//.verifyNavBarLinks("hair_quiz", "https://hairquiz.indulekha.co.in/")
		//.verifyNavBarLinks("track_order", "https://www.indulekha.co.in/pages/track-order-page")
		.verifyAnnoucementBanner();
		
	}
}
