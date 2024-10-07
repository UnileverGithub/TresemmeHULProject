package pageEvents.LBP;

import org.openqa.selenium.Keys;

import base.BaseTest;
import pageEvents.WizzySearchEvents;
import pageObjects.WizzySearchElements;
import pageObjects.LBP.WizzySearchElements_LBP;
import utils.ElementFetch;

public class WizzySearchEvents_LBP extends BaseTest{
	ElementFetch element = new ElementFetch();
	
	/*
	 * Verify Global Search Bar
	 * Parameters : None
	 * Created By : Sonam
	 */
	public WizzySearchEvents_LBP verifyGlobalSearchBar() throws InterruptedException
	{
		Thread.sleep(3000);
		logger.info("Verify global search bar");
		element.getwebElement("XPATH", WizzySearchElements_LBP.globalSearchBar).isDisplayed();
		logger.info("Global search bar is present");
		return this;
	} 
	
	/*
	 * Search products using wizzy search bar
	 * Parameters : None
	 * Created By : Sonam
	 */
	public WizzySearchEvents_LBP searchProduct(String productName) throws InterruptedException
	{
		logger.info("Search for product: "+productName);
		element.getwebElement("XPATH", WizzySearchElements_LBP.globalSearchBar).click();
		Thread.sleep(2000);
		element.getwebElement("XPATH", WizzySearchElements_LBP.globalSearchBar).sendKeys(productName);
		Thread.sleep(3000);
		element.getwebElement("XPATH", WizzySearchElements_LBP.globalSearchBar).sendKeys(Keys.ENTER);
		return this;
	} 
	
	
	/*
	 * Verify searched Result Page
	 * Parameters : None
	 * Created By : Sonam
	 */
	public Integer verifySearchedProductPage() throws InterruptedException
	{
		logger.info("Verify searched product is present");
		String filterText= element.getwebElement("XPATH", WizzySearchElements.filterResultHeading).getText();
		System.out.println(filterText);
		logger.pass("Searched product "+filterText);
		String number = filterText.replaceAll("\\D+", "");
        System.out.println("Numeric number: " + number);
        int productCountInt = Integer.parseInt(number);
		return productCountInt;
	} 
	
	
	/*
	 * Verify searched Result product title
	 * Parameters : None
	 * Created By : Sonam
	 */
	public WizzySearchEvents_LBP verifySearchedProductTitles(int productCount, String productName) throws InterruptedException
	{
		for (int i=0; i<productCount ; i++)
		{
			element.getwebElements("XPATH", WizzySearchElements.searchedProductTitle.replace("{Dynamic}", productName)).get(i).isDisplayed();
			logger.pass("Searched product title contains product name as: "+productName);
			String productTitle= element.getwebElements("XPATH", WizzySearchElements.searchedProductTitle.replace("{Dynamic}", productName)).get(i).getText();
			logger.pass("Searched product complete title is: "+productTitle);
		}
		return this;
	} 
	

}
