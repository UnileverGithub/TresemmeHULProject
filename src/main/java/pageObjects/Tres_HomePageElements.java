package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Tres_HomePageElements extends BaseTest{


	protected By img_TresLogo = By.xpath("//img[@alt='Tresemme India']");
	protected By img_TresLogoFooter = By.xpath("//footer[@id='footer_cstm']//div/a/img[contains(@srcset,'tresemmelogo.png')]");
	protected By img_heroBannerslider = By.xpath("//div[@id='custom-slideshow-container-cstm']");
	protected By img_heroBannerTresSerum = By.xpath("//div[@id='custom-slideshow-container-cstm']//a[contains(@href,'collections/tresemme-serums')]/div");
	protected By btn_herobannerSwiperNext = By.xpath("//div[@id='custom-slideshow-container-cstm']//div[@aria-label='Next slide']");
	protected By btn_herobannerSwiperPrev = By.xpath("//div[@id='custom-slideshow-container-cstm']//div[@aria-label='Previous slide']");
	protected By section_concernProduct = By.xpath("//section[@id='concern-products-wrapper-cstm']");
	protected By section_topTenProducts = By.xpath("//section[@id='custom-feature-collection-cstm']");
	protected By list_HairCare = By.xpath("//summary[@id='HeaderMenu-hair-care']");
	protected By txtbx_SearchBox = By.xpath("//input[@id='Search-In-Modal']");
	protected By div_wizzySearch = By.xpath("//div[contains(@class,'wizzy-autocomplete-wrapper')]");
	protected By div_WizzySearchSuggestion = By.xpath("//div[contains(@class,'wizzy-autocomplete-wrapper')]//div[@class='wizzy-autocomplete-suggestions']");
	protected By div_WizzySearchTopProduct = By.xpath("//div[contains(@class,'wizzy-autocomplete-wrapper')]//div[@class='wizzy-autocomplete-top-products']");
	protected By txt_searchResult = By.xpath("//div[@class='wizzy-search-summary-container']");
	protected By filterSection = By.xpath("//div[@class='wizzy-search-filters-left']");
	protected By div_SearchResult = By.xpath("//div[@class='wizzy-search-results']");
	protected By txt_SearchResultTitle = By.xpath("//div[@class='card__content']//h3[@class='card__heading h5']/a");
	protected By txt_EmptySearchResultSummary = By.xpath("//div[@class='wizzy-empty-results-summary']");
	protected By icon_EmptySearchResultIcon = By.xpath("//div[@class='wizzy-empty-results-icon']");
	protected By txt_EmptySearchResultContent = By.xpath("//div[@class='wizzy-empty-results-content']");
	protected By txt_SafetyNotice = By.xpath("//div[@id='caution_notice_wrapper_cstm']");
	protected By lnk_ChakshuPortal = By.xpath("//div[@id='caution_notice_wrapper_cstm']//a[text()='Chakshu Portal']");
	
}
