package pageEvents;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseTest;
import pageObjects.BundleOfferElements;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class BundleOfferEvents extends BaseTest{
	ElementFetch element = new ElementFetch();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/*
	 * verifyBuy3BundleBanner
	 * Parameters : None
	 * Created By : Sonam
	 */
	public BundleOfferEvents verifyBuy3BundleBanner() throws InterruptedException
	{
		logger.info("Verfiy BundleBanner");
		Thread.sleep(5000);
		element.getwebElement("XPATH", BundleOfferElements.buy3Banner).isDisplayed();
		logger.pass("Buy3 BundleBanner is present");
		return this;
	}
	
	/*
	 * verifyBundleBannerHeading
	 * Parameters : None
	 * Created By : Sonam
	 */
	public BundleOfferEvents verifyBundleBannerHeading() throws InterruptedException
	{
		logger.info("Verfiy BundleBanner Heading");
		Thread.sleep(5000);
		element.getwebElement("XPATH", BundleOfferElements.buildYourBundleHeading).isDisplayed();
		logger.pass("Bundle banner heading is present");
		return this;
	}
	
	/*
	 * verifyBuy3Buy4Tag
	 * Parameters : None
	 * Created By : Sonam
	 */
	public BundleOfferEvents verifyBuy3Tag() throws InterruptedException
	{
		logger.info("Verfiy verifyBuy3Buy4Tag");
		Thread.sleep(5000);
		int count = element.getwebElements("XPATH", BundleOfferElements.productCount).size();
		System.out.print(count);
		for(int i=0;i<count;i++)
		{	
			element.getwebElements("XPATH", BundleOfferElements.buy3Tag).get(i);
			System.out.print("tag is present: "+i);
		}
		logger.pass("Bundle banner heading is present");
		return this;
	}
	
	
	/*
	 * verifyBuy3Buy4Tag
	 * Parameters : None
	 * Created By : Sonam
	 */
	public BundleOfferEvents verifyBuy4Tag() throws InterruptedException
	{
		logger.info("Verfiy verifyBuy4Tag");
		Thread.sleep(5000);
		int count = element.getwebElements("XPATH", BundleOfferElements.productCount).size();
		System.out.print(count);
		for(int i=0;i<count;i++)
		{	
			element.getwebElements("XPATH", BundleOfferElements.buy4Tag).get(i);
			System.out.print("tag is present: "+i);
		}
		logger.pass("Bundle banner heading is present");
		return this;
	}

}
