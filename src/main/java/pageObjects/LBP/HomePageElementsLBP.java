package pageObjects.LBP;

public interface HomePageElementsLBP {
	String logo = "//img[@alt='Love Beauty & Planet']";
	String accountIcon = "//a[contains(@class,'icon--account')]";
	String cartIcon="//a[@id='cart-icon-bubble']";
	String AddToCart ="(//div[@class='product-form__buttons']//button)[1]";
	String collectionAddToCart = "(//ul[@id='product-grid']//div[@class='product-form__buttons']//button)[1]";
	String productName ="(//div[@id='home-best-selling']//h3//a)[1]";
	String collectionProductName = "(//ul[@id='product-grid']//h3//a)[1]";
	String productBlock ="(//form[@action='/cart/add'])[1]/..";
	
	//offer
	String homepageBanner = "//div[@class='rimage-outer-wrapper desktop-only lazyloaded' and contains(@style,'DTC-BYOB')]";
	String homepageShopNow="(//span[text()='Shop Now'])[4]";
	String bannerText = "//p[text()='Buy any 3 at Rs. 1399/-or ' and text()='buy any 4 Rs. 1799/-']";
	String tickerMsg = "//div[@class='slick-track']//a[not(contains(@class, 'clone'))]//b[contains(text(),'Buy 3 at ₹999 | Buy 4 at ₹1299')]";
	String buy3Link = "//a[contains(text(),'Buy 3 @ 1399')]";
	String shopMenuLink = "//a[@class='menu-bar-link' and contains(text(),'Shop')]";
	String newLaunchesLink = "//a[text()='New Launches']";
	
	String reelHeading="(//img[@class='reelUp_slider_image'])[1]";
	String reelAddToCartSection ="(//div[@class='reelUp_playlist_button_wrapper']//span[text()='ADD TO CART'])[1]/../..";
	String reelAddToCart ="(//div[@class='reelUp_playlist_button_wrapper']//span[text()='ADD TO CART'])[1]";
	String reelProductName ="(//p[@class='reelUp_slider_title'])[1]";
	String spotlightAddToCart = "(//button[contains(@id, 'in_the_spotlight')])[1]";
	String spotlightProductName ="(//div[@class='item home-spotlight']//p)[1]";
	
	String commonFooterLink= "//div[contains(@class,'desktop_only')]//a";

}
