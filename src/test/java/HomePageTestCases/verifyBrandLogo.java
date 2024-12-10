package HomePageTestCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_HomePageEvents;

public class verifyBrandLogo extends BaseTest{

	Tres_HomePageEvents Tres_HomePageEventsOBJ = new Tres_HomePageEvents();
	
	
	@Test @Ignore
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
	
	@Test @Ignore
	public void verifyHeroBannerOfTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify herobanner should be present<br>"
				+ "<b>Then:</b> verify herobanner should be naviate to its respective page<br>"
				+ "<b>And:</b> verify navigation carousal should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().verifyHeroBanner();
	}
	
	@Test
	public void verifyFooterLogoInTresemme()
	{
		
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify logo in footer should be present<br>"
				+ "<b>Then:</b> verify footer logo should navigate to home page<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/");
		Tres_HomePageEventsOBJ.verifyTresHomePage().veirfyFooterLogoTres();
	}
}
