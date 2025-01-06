package pageEvents;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.Tres_PDPElements;
import utils.Consoleloggers;

public class Tres_PDPEvents extends Tres_PDPElements{

	Logger log = Consoleloggers.getLogger(Tres_PDPEvents.class);
	
	
	/*
	 * Author: Renu
	 * method: to verifyProductTitle
	 * parameters: productId, productTitle
	 */
	public Tres_PDPEvents verifyProductTitle(String productID,String productTitle)
	{
		driver.findElement(txt_productInfoSection).isDisplayed();
		driver.findElement(img_productImage).isDisplayed();
		WebElement productTitleText = driver.findElement(By.xpath("//button[@id='buyOnlineCstm' and @product_id='"+productID+"']/parent::product-info//h1[@class='pdp_title']"));
		String txt_ProductTitle = productTitleText.getText();
		assertEquals(txt_ProductTitle, productTitle);
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to verifyProductPrice
	 * parameters: productId, productSalesPrice, productMRPPrice
	 */
	public Tres_PDPEvents verifyProductPrice(String productID, String productSalesPrice, String productMRPPrice)
	{
		driver.findElement(txt_productInfoSection).isDisplayed();
		driver.findElement(img_productImage).isDisplayed();
		WebElement productSalesPriceLoc = driver.findElement(By.xpath("//button[@id='buyOnlineCstm' and @product_id='"+productID+"']/parent::product-info//div[@class='price__sale']/span[contains(@class,'price-item--sale')]"));
		String txt_ProductSales = productSalesPriceLoc.getText();
		assertEquals(txt_ProductSales, productSalesPrice);
		WebElement productMRPPriceLoc = driver.findElement(By.xpath("//button[@id='buyOnlineCstm' and @product_id='"+productID+"']/parent::product-info//div[@class='price__sale']//s[contains(@class,'price-item--regular')]"));
		String txt_ProductMRP = productMRPPriceLoc.getText();
		assertEquals(txt_ProductMRP, productMRPPrice);
		assertEquals(driver.findElement(txt_TaxInclusion).getText(), "Inclusive of all Taxes");
		return this;
	}
	
	
	/*
	 * Author: Renu
	 * method: to verifyProductReview
	 * parameters: rating, numberOfReviews
	 */
	public Tres_PDPEvents verifyProductReview(int rating, int numberOfReviews)
	{
		driver.findElement(txt_productInfoSection).isDisplayed();
		driver.findElement(img_productImage).isDisplayed();
		String txt_ProductReview = driver.findElement(txt_Rating).getText();
		verifySubStringPresence(txt_ProductReview, rating+".0");
		verifySubStringPresence(txt_ProductReview, numberOfReviews+" Verified Reviews");
		verifySubStringPresence(txt_ProductReview, "Write a review");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to verifyProductAccordian
	 * parameters: section
	 */
	public Tres_PDPEvents verifyProductAccordian(String section)
	{
		driver.findElement(txt_productInfoSection).isDisplayed();
		driver.findElement(img_productImage).isDisplayed();
		WebElement productGridItems = driver.findElement(By.xpath("//body[@id='Tresemmeproduct']//div[@class='grid__item']//h3[contains(.,'"+section+"')]/parent::summary"));
		WebElement productGridItemContent = driver.findElement(By.xpath("//body[@id='Tresemmeproduct']//div[@class='grid__item']//h3[contains(.,'"+section+"')]/parent::summary/following-sibling::div[contains(@class,'accordion__content')]"));
		if(section.equalsIgnoreCase("Description"))
		{
			String ariaAttribute = productGridItems.getAttribute("aria-expanded");
			assertEquals(ariaAttribute, "true");
			productGridItemContent.isDisplayed();
			log.info("Description section is present");
		}
		else if(section.equalsIgnoreCase("How to use"))
		{
			String ariaAttribute = productGridItems.getAttribute("aria-expanded");
			assertEquals(ariaAttribute, "false");
			productGridItems.click();
			productGridItemContent.isDisplayed();
			assertEquals(productGridItems.getAttribute("aria-expanded"), "true");
		}
		else if(section.equalsIgnoreCase("Ingredients"))
		{
			String ariaAttribute = productGridItems.getAttribute("aria-expanded");
			assertEquals(ariaAttribute, "false");
			productGridItems.click();
			productGridItemContent.isDisplayed();
			assertEquals(productGridItems.getAttribute("aria-expanded"), "true");
		}
		else if(section.equalsIgnoreCase("Product Details"))
		{
			String ariaAttribute = productGridItems.getAttribute("aria-expanded");
			assertEquals(ariaAttribute, "false");
			productGridItems.click();
			productGridItemContent.isDisplayed();
			assertEquals(productGridItems.getAttribute("aria-expanded"), "true");
		}
		return this;
	}
	
	
	/*
	 * Author: Renu
	 * method: to verifyLegalMandatory
	 */
	public Tres_PDPEvents verifyLegalMandatory()
	{
		driver.findElement(txt_productInfoSection).isDisplayed();
		driver.findElement(img_productImage).isDisplayed();
		driver.findElement(lnk_ProductDetail).click();
		String legalMandate = driver.findElement(txt_ProductDetailSection).getText();
		verifySubStringPresence(legalMandate, "Company Name : Hindustan Unilever Ltd.");
		verifySubStringPresence(legalMandate, "Company Address : Hindustan Unilever Ltd, Unilever House, B D Sawant Marg, Chakala Andheri East - 400099.");
		verifySubStringPresence(legalMandate, "Country of Origin : India");
		verifySubStringPresence(legalMandate, "Expiry date: 24 Months from date of manufacture.");
		verifySubStringPresence(legalMandate, "Net Quantity:");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to verifyWriteReviewSection
	 * parameters: reviewStar
	 */
	public Tres_PDPEvents verifyWriteReviewSection(int reviewStar)
	{
		driver.findElement(txt_productInfoSection).isDisplayed();
		driver.findElement(img_productImage).isDisplayed();
		driver.findElement(lnk_WriteAReview).click();
		waitTillElementIsClickable(driver.findElement(lnk_WriteReview));
		driver.findElement(lnk_WriteReview).click();
		WebElement productRating = driver.findElement(By.xpath("//form[@class='jdgm-form']//span[@class='jdgm-form__rating']//a[@aria-label='"+reviewStar+" stars']"));
		productRating.click();
		driver.findElement(txtbx_ReviewTitle).sendKeys("Title for Testing");
		driver.findElement(txtbx_ReviewBody).sendKeys("This is a testing process and testing it if review section is working or not.");
		driver.findElement(txtbx_ReviewerName).sendKeys("Unilever Tester");
		driver.findElement(txtbx_ReviewerEmailID).sendKeys("HULTester123@test.com");
		driver.findElement(lnk_Term).click();
		switchToNextTab();
		assertEquals(driver.getCurrentUrl(), "https://judge.me/terms");
		closeTabAndReturn();
		driver.findElement(lnk_Privacy).click();
		switchToNextTab();
		assertEquals(driver.getCurrentUrl(), "https://judge.me/privacy");
		closeTabAndReturn();
		driver.findElement(lnk_Content).click();
		switchToNextTab();
		assertEquals(driver.getCurrentUrl(), "https://judge.me/content-policy");
		closeTabAndReturn();
		driver.findElement(btn_SubmitReview).isDisplayed();
		driver.findElement(lnk_CancelReview).isDisplayed();
		driver.findElement(img_ReviewMedia).isDisplayed();
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to verifyShareOnLinks
	 */
	public Tres_PDPEvents verifyShareOnLinks()
	{
		driver.findElement(lnk_Whatsapp).isDisplayed();
		driver.findElement(lnk_Whatsapp).click();
		verifySubStringPresence(driver.getCurrentUrl(), "https://api.whatsapp.com/send");
		driver.navigate().back();
		driver.findElement(lnk_Facebook).click();
		verifySubStringPresence(driver.getCurrentUrl(), "https://www.facebook.com/");
		driver.navigate().back();
		driver.findElement(lnk_Twitter).click();
		verifySubStringPresence(driver.getCurrentUrl(), "https://x.com/intent");
		driver.navigate().back();
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to verifyShareOnLinks
	 */
	public Tres_PDPEvents verifyCommerceConnectorBrandsLinks()
	{
		driver.findElement(btn_BuyOnlne).click();
		String [] eCommerceWebsites = {"Myntra","Flipkart","Amazon","Nykaa","Purplle"};
		for(String eCommerce : eCommerceWebsites)
		{
			try
			{
				WebElement footerSocialMedialink = driver.findElement(By.xpath("//div[@class='commerceConnector_content']//p[text()='"+eCommerce+"']/parent::div"));
				footerSocialMedialink.isDisplayed();
				footerSocialMedialink.click();
				if(eCommerce.equalsIgnoreCase("Myntra"))
				{
					switchToNextTab();
					verifySubStringPresence(driver.getCurrentUrl(), "https://www.myntra.com/");
					closeTabAndReturn();
				}
				else if(eCommerce.equalsIgnoreCase("Flipkart"))
				{
					switchToNextTab();
					verifySubStringPresence(driver.getCurrentUrl(), "https://www.flipkart.com/");
					closeTabAndReturn();
				}
				else if(eCommerce.equalsIgnoreCase("Amazon"))
				{
					switchToNextTab();
					verifySubStringPresence(driver.getCurrentUrl(), "https://www.amazon.in/");
					closeTabAndReturn();
				}
				else if(eCommerce.equalsIgnoreCase("Nykaa"))
				{
					switchToNextTab();
					verifySubStringPresence(driver.getCurrentUrl(), "https://www.nykaa.com/");
					closeTabAndReturn();
				}
				else if(eCommerce.equalsIgnoreCase("Purplle"))
				{
					switchToNextTab();
					verifySubStringPresence(driver.getCurrentUrl(), "https://www.purplle.com/");
					closeTabAndReturn();
				}
					
			}
			catch (Exception e) 
			{
				System.out.println("Element not found for: " + eCommerce);
			}
					
		}
		return this;
	}
	
	
}
