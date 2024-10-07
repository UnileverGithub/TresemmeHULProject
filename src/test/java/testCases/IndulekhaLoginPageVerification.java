package testCases;

import base.BaseTest;

public class IndulekhaLoginPageVerification extends BaseTest{

	public void verifyLoginpage()
	{
		
		String message = "<b>Given:</b> go to indulekha site <br>"
				+ "<b>When:</b> verify indulekha home page should display <br>"
				+ "<b>Then:</b> verify login icon <br>"
				+ "<b>And:</b> click on login button <br>"
				+ "<b>And:</b> verify navigation of login button <br>"
				+ "<b>And:</b> verify sign in with facebook button<br>"
				+ "<b>And:</b> verify sign in with google button <br>"
				+ "<b>And:</b>  Verify email textbox should be present <br>"
				+ "<b>And:</b>  verify password textbox should be present <br>"
				+ "<b>And:</b>  verify login button should be present <br>"
				+ "<b>Then:</b> verify sign up link should be present <br>";
		logger.info(message);
		
	}
}
