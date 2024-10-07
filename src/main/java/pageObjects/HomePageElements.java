package pageObjects;

public interface HomePageElements {
	String sscLogo = "//a[@class='site-logo-link']//img[@title='Simple Skincare' and contains(@class,'desktop')]";
	String accountIcon = "//a[contains(@class,'desktop')]//span[text()='View account']/..";
	String cartIcon="//img[@alt='cart-drawer-img']";
	String AddToCart ="(//form[@action='/cart/add']//button)[1]";
	String productName ="(//form[@action='/cart/add']//button)[1]";
	String productBlock ="(//form[@action='/cart/add'])[1]/..";
	
	//offer
	String homepageBanner = "//div[@class='rimage-outer-wrapper desktop-only lazyloaded' and contains(@style,'DTC-BYOB')]";
	String homepageShopNow="(//span[text()='Shop Now'])[4]";
	String bannerText = "//p[text()='Buy any 3 at Rs. 1399/-or ' and text()='buy any 4 Rs. 1799/-']";
	String tickerMsg = "//div[@class='slick-track']//a[not(contains(@class, 'clone'))]//b[contains(text(),'Buy 3 at ₹999 | Buy 4 at ₹1299')]";
	String buy3Link = "//a[contains(text(),'Buy 3 @ 1399')]";
	String productMenuLink = "//nav[@aria-label='Main']//span[text()='Products']/parent::a";
	String combosLink = "//nav[@aria-label='Main']//ul[@data-navmenu-submenu]//span[text()=' Super Saver Combos']";
	
	
/*	//Dynamic locators
	public static String DynamicBookNowButton(String serviceName) {
		String bookNow="//div[contains(text(),'"+ serviceName+"')]/..//child::button[text()='Book Now']";
		String addToBagButton ="//button[contains(text(),'Add to Bag')]";
        return bookNow;
    }
//	String DynamicBookNowButton = "//div[contains(text(),"+ dynamicValue+")]/..//child::button[text()='Book Now']";
	
	/*
	 if grand total is less than 500
verify this is there:
//div[text()='Sheet Mask Coconut Water & Mimosa Flower - 25 ml']

quantity: //div[@class='item_pri_qt']//input[@name='quantity']
get attribute, value data

price: //div[text()='Aloe Vera & Eucalyptus Body Wash 200ml']/following::div[@class='item_pri_qt']//span[@class='money total__pri']
	 */
}
