package pageObjects;

public interface AllProductElements {
	String allProductHeading = "//p[contains(text(),'All products')]";
	String productTitle = "//p[contains(@class,'productitem--title')]//a";
	String productTitleValue = "(//p[contains(@class,'productitem--title')]//a)[Dynamic]";
	
	//ASQ
	String paginationASQ = "//li[@class='pagination-custom__num']";
	String productDeatil_ASQ= "//div[contains(@class,'ProductTTl  ')]//p";
	String cookieSection = "//button[@id='onetrust-accept-btn-handler']";

}
