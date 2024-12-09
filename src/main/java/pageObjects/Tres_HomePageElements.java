package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Tres_HomePageElements extends BaseTest{


	protected By img_TresLogo = By.xpath("//img[@alt='Tresemme India']");
	protected By img_heroBannerslider = By.xpath("//div[@id='custom-slideshow-container-cstm']");
	protected By section_concernProduct = By.xpath("//section[@id='concern-products-wrapper-cstm']");
	protected By section_topTenProducts = By.xpath("//section[@id='custom-feature-collection-cstm']");
	protected By list_HairCare = By.xpath("//summary[@id='HeaderMenu-hair-care']");
	protected By txtbx_SearchBox = By.xpath("//input[@id='Search-In-Modal']");
	protected By div_wizzySearch = By.xpath("//div[contains(@class,'wizzy-autocomplete-wrapper')]");
	protected By div_WizzySearchSuggestion = By.xpath("//div[contains(@class,'wizzy-autocomplete-wrapper')]//div[@class='wizzy-autocomplete-suggestions']");
	protected By div_WizzySearchTopProduct = By.xpath("//div[contains(@class,'wizzy-autocomplete-wrapper')]//div[@class='wizzy-autocomplete-top-products']");
	
}
