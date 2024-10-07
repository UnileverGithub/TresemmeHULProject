package pageEvents;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseTest;
import pageObjects.AllProductElements;
import pageObjects.BundleOfferElements;
import utils.ElementFetch;
import utils.ExcelUtils;

public class AllProductEvents extends BaseTest{
	ElementFetch element = new ElementFetch();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/*
	 * verifyAllProductPage
	 * Parameters : None
	 * Created By : Sonam
	 */
	public AllProductEvents verifyAllProductPage() throws InterruptedException
	{
		logger.info("Verfiy All Product Page");
		Thread.sleep(5000);
	//	element.getwebElement("XPATH", AllProductElements.allProductHeading).isDisplayed();
		captureScreenshot();
		logger.pass("Buy3 BundleBanner is present");
		return this;
	}
	
	/*
	 * verifyAllProductPage
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String[] getAllProductTitle_SSC() throws InterruptedException
	{
		logger.info("getAllProductTitle");
		Thread.sleep(5000);
		String value;
		int size= element.getwebElements("XPATH", AllProductElements.productTitle).size();
		String[] allElement = new String[size];
		for (int i=0;i<size; i++)
		{
			value= element.getwebElements("XPATH", AllProductElements.productTitle).get(i).getAttribute("aria-label");			allElement[i] = value;
		}
		
		for (String value1 : allElement) {
            System.out.println("values from website: "+value1);
        }
		logger.pass("getAllProductTitle");
		return allElement;
	}
	
	/*
	 * verifyAllProductPage
	 * Parameters : None
	 * Created By : Sonam
	 */
	public String[] getAllProductTitle_A_squad() throws InterruptedException
	{
		logger.info("getAllProductTitle");
		Thread.sleep(5000);
		String value;
		int size= element.getwebElements("XPATH", AllProductElements.productDeatil_ASQ).size();
		int size1;
		String[] allElement = new String[47];
		for (int i=0;i<size; i++)
		{
			value= element.getwebElements("XPATH", AllProductElements.productDeatil_ASQ).get(i).getText();			
			allElement[i] = value;
		}
		if(element.getwebElement("XPATH", AllProductElements.paginationASQ).isDisplayed())
		{
			element.getwebElement("XPATH", AllProductElements.cookieSection).click();
			Thread.sleep(5000);
			jsClick(element.getwebElement("XPATH", AllProductElements.paginationASQ));
			//cli(element.getwebElement("XPATH", AllProductElements.paginationASQ));
		//	element.getwebElement("XPATH", AllProductElements.paginationASQ).click();
			size1= element.getwebElements("XPATH", AllProductElements.productDeatil_ASQ).size();
			for (int i=0;i<size1; i++)
			{
				String value1= element.getwebElements("XPATH", AllProductElements.productDeatil_ASQ).get(i).getText();			
				allElement[size++] = value1;
			}
		}
		for (String value1 : allElement) {
            System.out.println("values from website: "+value1);
        }
		logger.pass("getAllProductTitle");
		return allElement;
	}
	
	
	/*
	 * verifyAllProduct data matches with excel
	 * Parameters : None
	 * Created By : Sonam
	 */
	public AllProductEvents verifyAllProductPage(String[] excelData, String[] websiteProductData) throws InterruptedException
	{
		logger.info("Verfiy All Product Page");
		boolean value = matchAllProductPage(excelData,websiteProductData );
		if(value==false)
		{
		String[] mismatchedData = new String[excelData.length];
		 int mismatchIndex = 0;
		 for (String data : excelData) {
	            if (!Arrays.asList(websiteProductData).contains(data)) {
	                mismatchedData[mismatchIndex++] = data;
	            }
	            for (String nonMatchingProduct : mismatchedData) {
	                System.out.println(nonMatchingProduct);
	                Thread.sleep(2000);
	                captureScreenshot();
	            }
		 }
		}
		 return this;
		 
	}
	
	
	
	/*
	 * verifyAllProduct data matches with excel
	 * Parameters : None
	 * Created By : Sonam
	 */
	public boolean matchAllProductPage(String[] excelData, String[] websiteProductData) throws InterruptedException
	{
		logger.info("Verfiy All Product Page");
		boolean matchValue = false;
		String[] matchedData = new String[excelData.length];
		 int matchIndex = 0;
		 for (String data : excelData) {
	            if (Arrays.asList(websiteProductData).contains(data))
	            {
	            	matchedData[matchIndex++] = data;
	            	logger.pass("This product is present in website: "+ data);
	            	Thread.sleep(2000);
	            	captureScreenshot();
	            	matchValue = true;
	            	
	            }
	            else if(!(Arrays.asList(websiteProductData).contains(data)))
	            {
	            	matchValue = false;
	                logger.fail("This data is not present in website: "+data);
	            }
	        }
		return matchValue;
		 
	}
	

}
