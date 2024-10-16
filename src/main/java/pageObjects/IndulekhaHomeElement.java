package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class IndulekhaHomeElement extends BaseTest{
	//private WebDriver driver;


	protected By btn_okCookie = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	protected By btn_SignUpPopUpNoThanks = By.xpath("//div[contains(@class,'ecomsend__Modal') and text()='No, Thanks']");
	protected By img_indulekhaLogo = By.xpath("//img[@alt='indulekha logo' and @class='header__logo-image']");
	protected By herobanner = By.xpath("//section[@id='shopify-section-template--16785541070893__slideshow']");
	protected By globalHeader = By.xpath("//height-observer[@id='menuHeader']");
	protected By bestPickSection = By.xpath("//div[@id='featured_collection']");
	protected By txt_bestPickHeading = By.xpath("//div[@class='h1 main_heading']");
	protected By bestPickProductCollection = By.xpath("//featured-collections-carousel[@class='featured-collections-carousel']");
	protected By txtbx_pinCode = By.xpath("//div[@class='popup_zipcode-inner']//input[@placeholder='PIN Code']");
	protected By btn_PinCodeSubmit = By.xpath("//div[@class='popup_zipcode-inner']//a[text()='Submit']");
	protected By sideShoppingCart = By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='header_top_div']");
	protected By btn_CheckOut = By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//button[@name='checkout']");
	protected By induProductPage = By.xpath("//body[@id='product']");
	protected By img_induProductPage = By.id("productGalleryWrap");
	protected By txt_PDPProductTitle = By.xpath("//safe-sticky[@class='product-info ']//h1");
	protected By txt_PDPSalesPrice = By.xpath("//safe-sticky[@class='product-info ']//div[@data-block-type='price']//sale-price/span[@class='clubed_price1']");
	protected By btn_offerUpdateDontAllow = By.xpath("//div[@id='moe-push-div' and not(contains(@style,'display: none'))]//button[@id='moe-dontallow_button']");
	protected By linkTrackMyOrder = By.xpath("//a[contains(@class,'track_my_order')]");
	protected By btn_login = By.id("account_icon");
	
	//****************Global Navbar ******************//
	
	
	
	
	
	//*************Dynamic locators********************//
	
	String productCard_ImageDynamic = "//product-card[@product_id='Dynamic']/div[@class='product-card__figure']";
	
	    public IndulekhaHomeElement()
	    {
	    	this.driver = driver ;
	    	PageFactory.initElements(driver,this);
	    }
}

