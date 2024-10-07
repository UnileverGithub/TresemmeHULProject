package testCases.LBP;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.AllProductEvents;
import pageEvents.LBP.HomePageEventsLBP;
import pageEvents.LBP.ShoppingCartPageEventsLBP;
import pageEvents.LBP.WizzySearchEvents_LBP;
import utils.ExcelUtils;

public class BrokenLinksVerification extends BaseTest{
	
	HomePageEventsLBP homepage = new HomePageEventsLBP();
	ExcelUtils excel = new ExcelUtils("C:\\Users\\WM563BM\\OneDrive - EY\\Documents\\LBP_Links.xlsx");
	
	@Test
	public void brokenLinksVerification() throws InterruptedException
	{
		homepage.verifyLBPlogo()
		.verifyHomePage()
		.verifyBrokenLinks_Footer();
		
        
		
	}


}
