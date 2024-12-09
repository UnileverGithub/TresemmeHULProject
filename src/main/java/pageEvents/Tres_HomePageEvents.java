package pageEvents;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.Tres_HomePageElements;
import utils.Consoleloggers;

public class Tres_HomePageEvents extends Tres_HomePageElements{

	
	Logger log = Consoleloggers.getLogger(IndulekhaHomepageEvents.class);
	
	
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
		driver.findElement(img_heroBannerslider);
		driver.findElement(section_concernProduct);
		driver.findElement(section_topTenProducts);
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
}
