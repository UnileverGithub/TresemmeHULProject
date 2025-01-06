package pageEvents;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.Tres_HomePageElements;
import utils.Consoleloggers;

public class Tres_HomePageEvents extends Tres_HomePageElements{

	
	Logger log = Consoleloggers.getLogger(IndulekhaHomepageEvents.class);
	
	
	public Tres_HomePageEvents acceptOntrustCookie()
	{
		List<WebElement> onetrustCookie = driver.findElements(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		if(onetrustCookie.size()>0)
		{
			driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		}
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to verify band logo
	 */
	public Tres_HomePageEvents brandLogoVerification()
	{
		driver.findElement(img_TresLogo).isDisplayed();
		verifyLeftPositionOfElement(driver.findElement(img_TresLogo), driver.findElement(list_HairCare));
		driver.findElement(img_TresLogo).click();
		assertEquals(driver.getCurrentUrl(), "https://www.tresemme.in/");
		return this;
	}
	
	public Tres_HomePageEvents verifyTresHomePage()
	{
		driver.findElement(img_heroBannerslider).isDisplayed();
		driver.findElement(section_concernProduct).isDisplayed();
		driver.findElement(section_topTenProducts).isDisplayed();
		return this;
	}
	
	public Tres_HomePageEvents clickOnNavMenuCategory(String category)
	{
		WebElement navbarCategory = driver.findElement(By.xpath("//nav[@id='header_nav-dropdown-cstm']//details/summary/span[text()='"+category+"']|//nav[@id='header_nav-dropdown-cstm']//a[@id='HeaderMenu-tres-style']/span[text()='"+category+"']"));
		navbarCategory.click();
		return this;
	}
	
	public Tres_HomePageEvents clickOnNavMenuSubCategory(String category, String subCategory)
	{
		WebElement navbarSubCategory = driver.findElement(By.xpath("//nav[@id='header_nav-dropdown-cstm']//details//span[text()='"+category+"']/parent::summary/following-sibling::ul/li[contains(.,'"+subCategory+"')]"));
		navbarSubCategory.click();
		return this;
	}
	
	public Tres_HomePageEvents verifyMenuNavigation(String category)
	{
		if(category.equalsIgnoreCase("Hair Care"))
		{
			HashMap<String,String> menuNavLinks = new HashMap<String,String>();
			menuNavLinks.put("Shampoo", "https://www.tresemme.in/collections/shampoo");
			menuNavLinks.put("Conditioner", "https://www.tresemme.in/collections/conditioner");
			menuNavLinks.put("Hair Mask", "https://www.tresemme.in/collections/hair-mask");
			menuNavLinks.put("Hair Serum", "https://www.tresemme.in/collections/hair-serum");
			menuNavLinks.put("Combo", "https://www.tresemme.in/collections/hair-care-combo");
			for(Entry<String, String> entry: menuNavLinks.entrySet())
			{
				clickOnNavMenuCategory(category);
				clickOnNavMenuSubCategory(category, entry.getKey());
				Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
				verifyThatCollectionIsNotEmpty();
				driver.findElement(img_TresLogo).click();
			}	
		}
		else if(category.equalsIgnoreCase("Hair Goals"))
		{
			HashMap<String,String> menuNavLinks = new HashMap<String,String>();
			menuNavLinks.put("Hydrated Hair", "https://www.tresemme.in/collections/hydrated-hair");
			menuNavLinks.put("Smooth & Frizz-Free Hair", "https://www.tresemme.in/collections/smooth-frizz-free-hair");
			menuNavLinks.put("Smooth & Strong Hair", "https://www.tresemme.in/collections/smooth-strong-hair");
			menuNavLinks.put("Hair Repair Treatment", "https://www.tresemme.in/collections/hair-repair-treatment");
			menuNavLinks.put("Hair Styling", "https://www.tresemme.in/collections/hair-styling");
			for(Entry<String, String> entry: menuNavLinks.entrySet())
			{
				clickOnNavMenuCategory(category);
				clickOnNavMenuSubCategory(category, entry.getKey());
				Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
				verifyThatCollectionIsNotEmpty();
				driver.findElement(img_TresLogo).click();
			}	
		}
		else if(category.equalsIgnoreCase("TRES Style"))
		{
			clickOnNavMenuCategory(category);
			Assert.assertEquals(driver.getCurrentUrl(),"https://www.tresemme.in/blogs/style-with-tresemme");
			verifyHeading("Style With TRESemme");
			List<WebElement> tresStyleArticle = driver.findElements(By.xpath("//div[@class='blog-articles ']//div[@class='card__content']"));
			 if (tresStyleArticle.size() > 1) {
		            log.info("More than 1 article is present");
		        } else {
		            log.error("Only one or no Article present");
		        }
		}
		return this;
	}
	
	public Tres_HomePageEvents verifyThatCollectionIsNotEmpty()
	{
		List<WebElement> collectionItems = driver.findElements(By.xpath("//div[@id='ProductGridContainer']//ul/li"));
		collectionItems.get(0).isDisplayed();
		 if (collectionItems.size() > 1) {
	            log.info("Collection has more than 1 item in it");
	        } else {
	            log.error("Collection has less than 1 sku in it");
	        }
		return this;
	}
	
	public Tres_HomePageEvents verifyThatWizzySearchResultIsNotEmpty()
	{
		List<WebElement> collectionItems = driver.findElements(By.xpath("//div[@class='wizzy-search-results']//ul/li"));
		 if (collectionItems.size() > 1) {
	            log.info("Wizzy search result has more than 1 item in it");
	        } else {
	            log.error("Wizzy search result has less than 1 sku in it");
	        }
		return this;
	}
	
	public Tres_HomePageEvents clickOnSearchBox()
	{
		driver.findElement(txtbx_SearchBox).isDisplayed();
		driver.findElement(txtbx_SearchBox).click();
		waitTillElementAppear(driver.findElement(div_wizzySearch));
		return this;
	}
	
	public Tres_HomePageEvents sendTextInSearchBox(String keyword)
	{
		driver.findElement(txtbx_SearchBox).clear();
		waitTillElementIsClickable(driver.findElement(txtbx_SearchBox));
		driver.findElement(txtbx_SearchBox).sendKeys(keyword);
		driver.findElement(txtbx_SearchBox).sendKeys(Keys.ENTER);
		return this;
	} 
	
	public Tres_HomePageEvents verifyTrendingSearchSuggestionPresence()
	{
		clickOnSearchBox();
		driver.findElement(div_wizzySearch).isDisplayed();
		driver.findElement(div_WizzySearchSuggestion).isDisplayed();
		driver.findElement(div_WizzySearchTopProduct).isDisplayed();
		return this;
	}
	
	public Tres_HomePageEvents verifyTrendingSearchSuggestionNavigation()
	{
		HashMap<String,String> trendingOptions = new HashMap<String,String>();
		trendingOptions.put("Shampoos", "https://www.tresemme.in/pages/search?q=shampoos");
		trendingOptions.put("Conditioners", "https://www.tresemme.in/pages/search?q=conditioners");
		trendingOptions.put("Serums", "https://www.tresemme.in/pages/search?q=serums");
		trendingOptions.put("Masks", "https://www.tresemme.in/pages/search?q=masks");
		trendingOptions.put("Combos", "https://www.tresemme.in/pages/search?q=combos");
		for(Entry<String, String> entry: trendingOptions.entrySet())
		{
			clickOnSearchBox();
			driver.findElement(div_wizzySearch).isDisplayed();
			driver.findElement(div_WizzySearchSuggestion).isDisplayed();
			WebElement navbarSubCategory = driver.findElement(By.xpath("//div[@class='wizzy-autocomplete-suggestions']/ul/li/a[contains(.,'"+entry.getKey()+"')]"));
			navbarSubCategory.click();
			Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
			verifyThatWizzySearchResultIsNotEmpty();
		}
		return this;
	}
	
	public Tres_HomePageEvents verifyValidSearchText(String keyword)
	{
		driver.findElement(txt_searchResult).isDisplayed();
		verifySubStringPresence(driver.findElement(txt_searchResult).getText(), keyword);
		verifyLeftPositionOfElement(driver.findElement(filterSection), driver.findElement(div_SearchResult));
		verifyThatWizzySearchResultIsNotEmpty();
		List<WebElement> searchResultTitles = driver.findElements(By.xpath("//div[@class='card__content']//h3[@class='card__heading h5']/a"));
		for(int i=0;i<15;i++)
		{
			verifySubStringPresence(searchResultTitles.get(i).getText(), keyword.toUpperCase());
		}
		return this;
	}
	
	public Tres_HomePageEvents verifyInvalidSearchResultPage(String inValidKeyWord)
	{
		driver.findElement(txt_EmptySearchResultSummary).isDisplayed();
		driver.findElement(icon_EmptySearchResultIcon).isDisplayed();
		driver.findElement(txt_EmptySearchResultContent).isDisplayed();
		Assert.assertEquals(driver.findElement(txt_EmptySearchResultSummary).getText(),"You searched for "+inValidKeyWord);
		verifyThatWizzySearchResultIsNotEmpty();
		return this;
	}
	
	public Tres_HomePageEvents verifyHeroBanner()
	{
		driver.findElement(img_heroBannerslider).isDisplayed();
		driver.findElement(img_heroBannerTresSerum).click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.tresemme.in/collections/tresemme-serums");
		verifyThatCollectionIsNotEmpty();
		driver.findElement(img_TresLogo).click();
		driver.findElement(btn_herobannerSwiperNext).isDisplayed();
		driver.findElement(btn_herobannerSwiperPrev).isDisplayed();
		return this;
	}
	
	public Tres_HomePageEvents veirfyFooterLogoTres()
	{
		driver.findElement(img_TresLogoFooter).isDisplayed();
		acceptOntrustCookie();
		scrollIntoView(driver.findElement(img_TresLogoFooter));
		scrollUp();
		driver.findElement(img_TresLogoFooter).click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.tresemme.in/");
		return this;
	}
	
	public Tres_HomePageEvents verifyFooterSectionLinks(String category)
	{
		if(category.equalsIgnoreCase("Product Links"))
		{
			HashMap<String,String> footerProductLink = new HashMap<String,String>();
			footerProductLink.put("Shampoo", "https://www.tresemme.in/collections/shampoo");
			footerProductLink.put("Conditioner", "https://www.tresemme.in/collections/conditioner");
			footerProductLink.put("Mask", "https://www.tresemme.in/collections/hair-mask");
			footerProductLink.put("Serum", "https://www.tresemme.in/collections/hair-serum");
			footerProductLink.put("Combo", "https://www.tresemme.in/collections/hair-care-combo");
			for(Entry<String, String> entry: footerProductLink.entrySet())
			{
				scrollIntoView(driver.findElement(img_TresLogoFooter));
				scrollUp();
				WebElement footerProductlink = driver.findElement(By.xpath("//footer[@id='footer_cstm']//h2[text()='"+category+"']/following-sibling::ul/li/a[contains(text(),'"+entry.getKey()+"')]"));
				footerProductlink.click();
				Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
				verifyThatCollectionIsNotEmpty();
			}
		}
		
		else if(category.equalsIgnoreCase("Quick Links"))
		{
			HashMap<String,String> footerQuickLink = new HashMap<String,String>();
			footerQuickLink.put("Contact Us", "https://www.tresemme.in/pages/contact");
			footerQuickLink.put("Hair Care", "https://www.tresemme.in/collections/all");
			footerQuickLink.put("About Us", "https://www.tresemme.in/pages/our-vision");
			footerQuickLink.put("Legal Disclaimer", "https://www.tresemme.in/pages/legal-disclaimer");
			
			for(Entry<String, String> entry: footerQuickLink.entrySet())
			{
				scrollIntoView(driver.findElement(img_TresLogoFooter));
				scrollUp();
				WebElement footerQuicklink = driver.findElement(By.xpath("//footer[@id='footer_cstm']//h2[text()='"+category+"']/following-sibling::ul/li/a[contains(text(),'"+entry.getKey()+"')]"));
				footerQuicklink.click();
				Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
			}
			
			WebElement footerQuickAccessabilitylink = driver.findElement(By.xpath("//footer[@id='footer_cstm']//h2[text()='Quick Links']/following-sibling::ul/li/a[contains(text(),'Accessibility')]"));
			footerQuickAccessabilitylink.click();
			Assert.assertEquals("https://notices.unilever.com/general/en/accessibility/", driver.getCurrentUrl());
		}
		if(category.equalsIgnoreCase("Legal"))
		{
			HashMap<String,String> footerLegalLink = new HashMap<String,String>();
			footerLegalLink.put("Privacy Notice", "https://www.unilevernotices.com/privacy-notices/india-english.html");
			footerLegalLink.put("Cookie Notice", "https://www.unilevernotices.com/cookie-notices/india-english.html");
			footerLegalLink.put("Terms & Conditions", "https://www.tresemme.in/pages/terms-conditions");
			footerLegalLink.put("Terms of Use", "https://www.tresemme.in/pages/terms-of-use");
			footerLegalLink.put("Terms of Service", "https://www.tresemme.in/pages/terms-of-service");
			footerLegalLink.put("Return policy", "https://www.tresemme.in/pages/return-policy");
			footerLegalLink.put("Refund policy", "https://www.tresemme.in/policies/refund-policy");
			for(Entry<String, String> entry: footerLegalLink.entrySet())
			{
				scrollIntoView(driver.findElement(img_TresLogoFooter));
				scrollUp();
				WebElement footerProductlink = driver.findElement(By.xpath("//footer[@id='footer_cstm']//h2[text()='"+category+"']/following-sibling::ul/li/a[contains(text(),'"+entry.getKey()+"')]"));
				footerProductlink.click();
				Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
				driver.navigate().back();
			}
		}
		
		return this;
	}
	
	public Tres_HomePageEvents verifySocialMediaFooterLinks()
	{
		String [] socialMedia = {"Facebook","Instagram","YouTube"};
		for(String media : socialMedia)
		{
			try
			{
				WebElement footerSocialMedialink = driver.findElement(By.xpath("//div[@class='footer_social_icons']//span[text()='"+media+"']/parent::a"));
				footerSocialMedialink.isDisplayed();
				footerSocialMedialink.click();
				if(media.equalsIgnoreCase("Facebook"))
					Assert.assertEquals("https://www.facebook.com/TresemmeIndia/", driver.getCurrentUrl());
				else if(media.equalsIgnoreCase("Instagram"))
					Assert.assertEquals("https://www.instagram.com/accounts/login/?next=https%3A%2F%2Fwww.instagram.com%2Ftresemmeindia%2F&is_from_rle", driver.getCurrentUrl());
				else if(media.equalsIgnoreCase("YouTube"))
					Assert.assertEquals("https://www.youtube.com/user/TresemmeIndia", driver.getCurrentUrl());
				
				driver.navigate().back();
					
			}
			catch (Exception e) 
			{
				System.out.println("Element not found for: " + media);
			}
					
		}
		return this;
	}
	
	public Tres_HomePageEvents verifySafetyCautionNotice()
	{
		String safetyCautionText = driver.findElement(txt_SafetyNotice).getText();
		verifySubStringPresence(safetyCautionText, "Safety Advisory");
		verifySubStringPresence(safetyCautionText, "Please Be Aware: Cyber crime, particularly fraudulent communications through phone, SMS, WhatsApp, emails, etc. with third parties impersonating as a genuine organization or brand to financially dupe consumers is on the rise.");
		verifySubStringPresence(safetyCautionText, "Unilever does not request for payment for purchase of our products outside our platform for any promotional activity. We also do not request for payments to participate in any contest, lucky draw, free gifts. Hence, we request all consumers to be cautious in the event of any such communications. You can reach out to our customer care listed on our platform to verify any suspicious activity.");
		verifySubStringPresence(safetyCautionText, "Note: You can also report any suspected fraudulent telecommunications on Chakshu Portal, to the Department of Telecommunications (DOT).");
		return this;
	}
	
	public Tres_HomePageEvents ClickOnContactUsLink()
	{
		waitTillElementIsClickable(driver.findElement(lnk_ContactUs));
		scrollIntoView(driver.findElement(lnk_ContactUs));
		scrollUp();
		driver.findElement(lnk_ContactUs).click();
		return this;
	}
}
