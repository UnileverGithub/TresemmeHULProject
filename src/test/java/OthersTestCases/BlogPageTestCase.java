package OthersTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_BlogPageEvents;

public class BlogPageTestCase extends BaseTest{

	Tres_BlogPageEvents Tres_HomePageEventsOBJ = new Tres_BlogPageEvents();
	public static final int widthRatio = 843;
	public static final int heightRatio = 422;
	
	@Test
	public void verifyBlogPage() throws InterruptedException
	{
		
		String message = "<b>Given:</b> go to tresemme blog page <br>"
				+ "<b>Then:</b> verify blog page title presence<br>"
				+ "<b>Then:</b> verify blog page published date presence<br>"
				+ "<b>Then:</b> verify blog page image presence<br>"
				+ "<b>Then:</b> verify blog page top blog post section presence<br>"
				+ "<b>Then:</b> verify table of content section presence<br>";
		
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/blogs/style-with-tresemme/unlocking-the-power-of-hair-serums-getting-the-most-out-of-your-hair-savior");
		verifyHeading("Unlocking the Power of Hair Serums: Getting the Most Out of Your Hair Saviour");
		Tres_HomePageEventsOBJ.verifyBlogPage(widthRatio,heightRatio);
		
	}
	
}
