package pageObjects;

public interface WizzySearchElements {
	String globalSearchBar = "//input[@class='search-input' and contains(@placeholder,'Search For')] | //input[@class='search-input wizzy-search-input' and contains(@placeholder,'Search For')]";
	String filterResultHeading = "//div[@class='wizzy-search-summary-container']//p";
	String searchedProductTitle="(//p[@class='wizzy-summary-head']//strong[contains(text(),'{Dynamic}')]) ";

}
