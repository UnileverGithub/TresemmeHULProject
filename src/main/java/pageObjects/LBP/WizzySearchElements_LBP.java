package pageObjects.LBP;

public interface WizzySearchElements_LBP {
	String globalSearchBar = "//input[@id='mob-search']";
	String filterResultHeading = "//div[@class='wizzy-search-summary-container']//p";
	String searchedProductTitle="(//p[@class='wizzy-summary-head']//strong[contains(text(),'{Dynamic}')]) ";

}
