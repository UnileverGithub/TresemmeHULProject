package pageEvents;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.IndulekhaHomeElement;
import utils.Consoleloggers;

public class IndulekhaHomepageEvents extends IndulekhaHomeElement{

	IndulekhaHomeElement IndulekhaHomeElementOBJ = new IndulekhaHomeElement();
	IndulekhaLoginPageEvents IndulekhaLoginPageEventsOBJ;
	Logger log = Consoleloggers.getLogger(IndulekhaHomepageEvents.class);
	
	/*
	 * Author: Renu
	 * method: to accept cookie law
	 */
	public IndulekhaHomepageEvents acceptCookiePopUp()
	{
		if(driver.findElement(btn_okCookie).isDisplayed())
			driver.findElement(btn_okCookie).click();
		return this;
	}
	
	public IndulekhaHomepageEvents privacyPolicy(String acceptOrDecline)
	{
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@id='shopify-pc__banner']//button[text()='"+acceptOrDecline+"']"));
		privacyPolicy.click();
		return this;
	}

	/*
	 * Author: Renu
	 * method: verify indulekha home page
	 */
	public IndulekhaHomepageEvents verifyIndulekhaHomePage()
	{
		logger.info("*********Starting of verifyIndulekhaHomePage()**********");
		//waitTillElementAppear(driver.findElement(btn_SignUpPopUpNoThanks));
		//driver.findElement(btn_SignUpPopUpNoThanks).click();
		waitTillElementAppear(driver.findElement(img_indulekhaLogo));
		driver.findElement(img_indulekhaLogo).isDisplayed();
		logger.pass("Brand logo is present");
		driver.findElement(herobanner).isDisplayed();
		log.info(driver.findElement(herobanner)+"is present");
		driver.findElement(globalHeader).isDisplayed();
		logger.info("*********Ending of verifyIndulekhaHomePage()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: navigate to best pickup section
	 */
	public IndulekhaHomepageEvents gotoBestPickSection()
	{
		logger.info("*********Starting of gotoBestPickSection()**********");
		driver.findElement(bestPickSection).isDisplayed();
		scrollIntoView(driver.findElement(bestPickSection));
		logger.pass("Best pick up section is present");
		Assert.assertEquals(driver.findElement(txt_bestPickHeading).getText(), "Best Picks For You");
		driver.findElement(bestPickProductCollection).isDisplayed();
		logger.info("*********Ending of gotoBestPickSection()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: clicking on ATC from homepage
	 * parameters: skuID
	 */
	public IndulekhaHomepageEvents clickOnAddToCart(String skuID)
	{
		logger.info("*********Starting of clickOnAddToCart()**********");
		WebElement bestPickProductSection = driver.findElement(By.xpath("//featured-collections-carousel[@class='featured-collections-carousel']//product-card[@product_id='"+skuID+"']"));
		hover(bestPickProductSection);
		WebElement btn_addToCart = driver.findElement(By.xpath("//featured-collections-carousel[@class='featured-collections-carousel']//product-card[@product_id='"+skuID+"']//button[text()='Add to cart']"));
		waitTillElementIsClickable(btn_addToCart);
		hover(btn_addToCart);
		btn_addToCart.click();
		logger.pass("Clicked on best pick add to cart");
		logger.info("*********Ending of clickOnAddToCart()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: click on product image from best pick section
	 * parameters:skuID 
	 */
	public IndulekhaHomepageEvents clickOnProductFromBestpick(String skuID)
	{
		logger.info("*********Starting of clickOnProductFromBestpick()**********");
		WebElement bestPickProductSection = driver.findElement(By.xpath("//featured-collections-carousel[@class='featured-collections-carousel']//product-card[@product_id='"+skuID+"']"));
		hover(bestPickProductSection);
		bestPickProductSection.click();
		logger.info("*********Ending of clickOnProductFromBestpick()**********");
		return this;
	}
	

	public IndulekhaHomepageEvents enterZipCode(String zipcode)
	{
		logger.info("*********Starting of enterZipCode()**********");
		if(driver.findElement(bestPickProductCollection).isDisplayed())
		{
			driver.findElement(bestPickProductCollection).clear();
			driver.findElement(txtbx_pinCode).sendKeys(zipcode);
			driver.findElement(btn_PinCodeSubmit).click();
		}
		logger.info("*********Ending of enterZipCode()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: verify shopping cart is open or not
	 */
	public IndulekhaHomepageEvents verifyShoppingCartShouldOpen()
	{
		logger.info("*********Starting of verifyShoppingCartShouldOpen()**********");
		waitTillElementAppear(driver.findElement(sideShoppingCart));
		driver.findElement(sideShoppingCart).isDisplayed();
		driver.findElement(btn_CheckOut).isDisplayed();
		if(!(driver.findElement(btn_CheckOut).isDisplayed()))
			logger.fail("Shopping cart is not opening");
		logger.info("*********Ending of verifyShoppingCartShouldOpen()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: this method will retreive the sku price from home page
	 * parameter : skuID
	 */
	public String getSkuPrice(String skuID)
	{
		logger.info("*********Starting of getSkuPrice()**********");
		WebElement btn_addToCart = driver.findElement(By.xpath("(//h2[text()='Bestsellers']/parent::div/div//a[@product-id='"+skuID+"'])[1]"));
		String productPrice = btn_addToCart.getAttribute("product-price");
		logger.info("*********Ending of getSkuPrice()**********");
		return productPrice;
	}
	
	/*
	 * Author: Renu
	 * method: this method will verify if the same sku is getting added from homepage or not
	 * parameter: skuID
	 */
	public IndulekhaHomepageEvents verifySkuAddedInCart(String skuId)
	{
		logger.info("*********Starting of verifySkuAddedInCart()**********");
		WebElement productNameOnHome = driver.findElement(By.xpath("//div[@id='featured_collection']//product-card[@product_id='"+skuId+"']"));
		String productNameHome = productNameOnHome.getAttribute("product_title");
		WebElement productNameOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//a"));
		String productNameCart = productNameOnCart.getText();
		logger.pass("Added " +productNameHome+ " into the cart");
		verifySubStringPresence(productNameCart, productNameHome);
		logger.info("*********Ending of verifySkuAddedInCart()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: verify shopping cart for single product
	 * parameter: skuID, productName, productPrice
	 */
	public IndulekhaHomepageEvents verifyCartForSingleProduct(String skuId,String productName, String productPrice)
	{
		logger.info("*********Starting of verifyCartForSingleProduct()**********");
		WebElement productNameOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//a"));
		String productNameCart = productNameOnCart.getText();
		verifySubStringPresence(productNameCart, productName);
		WebElement productPriceOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//sale-price"));
		String productPriceCart = productPriceOnCart.getText();
		verifySubStringPresence("₹ "+productPrice, productPriceCart);
		logger.info("*********Ending of verifyCartForSingleProduct()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: this method will verify if sku price added in cart is having same price 
	 * paramter: product ID
	 */
	public IndulekhaHomepageEvents verifySkuPriceAddedInCart(String skuId)
	{
		logger.info("*********Starting of verifySkuPriceAddedInCart()**********");
		WebElement productPriceOnHome = driver.findElement(By.xpath("//div[@id='featured_collection']//product-card[@product_id='"+skuId+"']"));
		String productPriceHome = productPriceOnHome.getAttribute("product_price");
		WebElement productPriceOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//sale-price"));
		String productPriceCart = productPriceOnCart.getText();
		verifySubStringPresence("₹ "+productPriceHome, productPriceCart);	
		logger.info("*********Ending of verifySkuPriceAddedInCart()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: this method will click on the checkout button from shopping cart
	 */
	public IndulekhaHomepageEvents clickOnCheckout()
	{
		logger.info("*********Starting of clickOnCheckout()**********");
		waitTillElementIsClickable(driver.findElement(btn_CheckOut));
		driver.findElement(btn_CheckOut).click();
		logger.info("*********Ending of clickOnCheckout()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: this method will verify the basic things of PDP page
	 * just to check if it is navigated to PDP page or not
	 */
	public IndulekhaHomepageEvents verifyInduPDPPage()
	{
		logger.info("*********Starting of verifyInduPDPPage()**********");
		waitTillElementAppear(driver.findElement(induProductPage));
		driver.findElement(induProductPage).isDisplayed();
		driver.findElement(img_induProductPage).isDisplayed();
		logger.info("*********Ending of verifyInduPDPPage()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will click on the ATC button from PDP page
	 * parameter : data variant ID
	 */
	public IndulekhaHomepageEvents clickOnATCFromPDPIndu(String dataVariantID)
	{
		logger.info("*********Starting of clickOnATCFromPDPIndu()**********");
		WebElement btn_ATCButton = driver.findElement(By.xpath("//buy-buttons[@id='add-to-cart-button-"+dataVariantID+"']"));
		btn_ATCButton.click();
		logger.info("*********Ending of clickOnATCFromPDPIndu()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method is verify that page is navigated to collection page
	 */ 
	public IndulekhaHomepageEvents verifyCollectionPageUrl(String collectionPage)
	{
		logger.info("*********Starting of getProductTitleFromCollection()**********");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.indulekha.co.in/collections/"+collectionPage.toLowerCase()+"");
		logger.info("*********Ending of getProductTitleFromCollection()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: this method will retrieve the product title from collection page
	 * parameter: product ID
	 */
	public String getProductTitleFromCollection(String productID)
	{
		logger.info("*********Starting of getProductTitleFromCollection()**********");
		WebElement btnCollectionProduct = driver.findElement(By.xpath("//body[@id='collection']//product-card[@product_id='"+productID+"']"));
		String productTitle = btnCollectionProduct.getAttribute("product_title");
		logger.info("*********Ending of getProductTitleFromCollection()**********");
		return productTitle;
		
	}
	
	/*
	 * Author: Renu
	 * method: this method will retrieve the product price from collection page
	 * parameter: product ID
	 */
	public String getProductPriceFromCollection(String productID)
	{
		logger.info("*********Starting of getProductPriceFromCollection()**********");
		WebElement btnCollectionProduct = driver.findElement(By.xpath("//body[@id='collection']//product-card[@product_id='"+productID+"']"));
		String productSkuPrice = btnCollectionProduct.getAttribute("product_price");
		logger.info("*********Ending of getProductPriceFromCollection()**********");
		return productSkuPrice;
		
	}
	
	
	/*
	 * Author: Renu
	 * method: this method will click on collection ATC button
	 * parameter: product ID
	 */
	public IndulekhaHomepageEvents clickCollectionATC(String productID)
	{
		logger.info("*********Starting of clickCollectionATC()**********");
		WebElement btnATCCollection = driver.findElement(By.xpath("//body[@id='collection']//product-card[@product_id='"+productID+"']//button[text()='Add to cart']"));
		logger.pass(btnATCCollection.getAccessibleName() +"is present on the page.");
		hover(btnATCCollection);
		btnATCCollection.click();
		logger.info("*********Ending of clickCollectionATC()**********");
		return this;
	}
	
	
	public IndulekhaHomepageEvents clickOnProductCardImage(String productID)
	{
		logger.info("*********Starting of clickOnProductCardImage()**********");
		WebElement btnProductCardImage = driver.findElement(By.xpath("//product-card[@product_id='"+productID+"']/div[@class='product-card__figure']"));
		btnProductCardImage.click();
		logger.info("*********Ending of clickOnProductCardImage()**********");
		return this;
	}
	
	
	/*
	 * Author: Renu
	 * method: click on global navbar
	 * parameters: category which could be all_products, hair_concerns,
	 * understanding_hair_loss, faqs, hair_quiz, track_order
	 */
	
	public IndulekhaHomepageEvents clickOnGlobalNavbarCategory(String category)
	{
		logger.info("*********Starting of clickOnGlobalNavbarCategory()**********");
		WebElement navbarCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']"));
		logger.pass(navbarCategory.getAccessibleName() +"is present on the page.");
		if(driver.findElements(btn_offerUpdateDontAllow).size()>0)
		{
			driver.findElement(btn_offerUpdateDontAllow).click();
		}
		navbarCategory.click();
		logger.info("*********Ending of clickOnGlobalNavbarCategory()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: click on global navbar subcategory
	 * parameters: category and subcategory which could be 
	 * all_products : Oil, Shampoo, Soap, Combos
	 * hair_concerns : Hairfall , Dandruff
	 */
	public IndulekhaHomepageEvents clickOnGlobalNavbarSubCategory(String category, String subcategory)
	{
		logger.info("*********Starting of clickOnGlobalNavbarCategory()**********");
		if(driver.findElements(btn_offerUpdateDontAllow).size()>0)
		{
			driver.findElement(btn_offerUpdateDontAllow).click();
		}
		WebElement navbarSubCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']//a[text()='"+subcategory+"']"));
		logger.pass(navbarSubCategory.getAccessibleName() +"is present on the page.");
		navbarSubCategory.click();
		logger.info("*********Ending of clickOnGlobalNavbarCategory()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: click on Add to cart from collection
	 * parameters: productID (sku id)
	 */
	public IndulekhaHomepageEvents clickOnATCFromInduCollection(String productID)
	{
		logger.info("*********Starting of clickOnATCFromInduCollection()**********");
		WebElement navbarSubCategory = driver.findElement(By.xpath("//body[@id='collection']//product-card[@product_id='"+productID+"']//button[text()='Add to cart']"));
		navbarSubCategory.isDisplayed();
		logger.pass(navbarSubCategory.getAccessibleName() +"is present on the page.");
		navbarSubCategory.click();
		hover(navbarSubCategory);
		return this;
	}
	
	
	/*
	 * Author: Renu
	 * method: verify that same sku is getting added from collection page
	 * parameters: productID (sku id) and sku title
	 */
	public IndulekhaHomepageEvents verifySkuAddedInCartForCollection(String skuId,String skuTitle)
	{
		logger.info("*********Starting of verifySkuAddedInCart()**********");
		WebElement productNameOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//a"));
		String productNameCart = productNameOnCart.getText();
		logger.pass("Added " +skuTitle+ " into the cart");
		verifySubStringPresence(productNameCart, skuTitle);
		logger.info("*********Ending of verifySkuAddedInCart()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: verify that same sku price is getting added from collection page
	 * parameters: productID (sku id) and sku price
	 */
	public IndulekhaHomepageEvents verifySkuPriceAddedInCartForCollection(String skuId, String skuPrice)
	{
		logger.info("*********Starting of verifySkuPriceAddedInCart()**********");
		WebElement productPriceOnCart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer' and @style='display: block;']//div[@class='cart-drawer__items']/div[@product_id='"+skuId+"']//div[@class='line-item-info']//sale-price"));
		String productPriceCart = productPriceOnCart.getText();
		verifySubStringPresence("₹ "+skuPrice, productPriceCart);	
		logger.info("*********Ending of verifySkuPriceAddedInCart()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: verify navigation of all product list
	 * parameters: category and subcategory
	 */
	public IndulekhaHomepageEvents verifyAllProductHeaderLinks(String category)
	{
		logger.info("*********Starting of verifyAllProductHeaderLinks()**********");
		String[] allProductDropdown = {"Oil","Shampoo","Soap","Combos"} ;
		String[] allProductLink = {"https://www.indulekha.co.in/collections/oil","https://www.indulekha.co.in/collections/shampoo","https://www.indulekha.co.in/collections/soap","https://www.indulekha.co.in/collections/combo_product"};
		scrollDown();
		for (int i = 0; i < allProductDropdown.length; i++) 
		{
			WebElement navbarCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']"));
			logger.pass(navbarCategory.getAccessibleName() +"is present on the page.");
			navbarCategory.click();
			WebElement navbarSubCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']//a[text()='"+allProductDropdown[i]+"']"));
			navbarSubCategory.click();
			Assert.assertEquals(driver.getCurrentUrl(), allProductLink[i]);
		}
		logger.info("*********Ending of verifyAllProductHeaderLinks()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: verify navigation of Hair concern links
	 * parameters: category and subcategory
	 */
	public IndulekhaHomepageEvents verifyHairConcernHeaderLinks(String category)
	{
		logger.info("*********Starting of verifyHairConcernHeaderLinks()**********");
		String[] hairConcernDropdown = {"Hairfall ","Dandruff"} ;
		String[] hairConcernLink = {"https://www.indulekha.co.in/collections/hairfall","https://www.indulekha.co.in/collections/svetakutaja-range"};
		scrollDown();
		for (int i = 0; i < hairConcernDropdown.length; i++) 
		{
			WebElement navbarCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']"));
			logger.pass(navbarCategory.getAccessibleName() +"is present on the page.");
			navbarCategory.click();
			WebElement navbarSubCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']//a[text()='"+hairConcernDropdown[i]+"']"));
			navbarSubCategory.click();
			Assert.assertEquals(driver.getCurrentUrl(), hairConcernLink[i]);
		}
		logger.info("*********Ending of verifyHairConcernHeaderLinks()**********");
		return this;
	}
	
	public IndulekhaHomepageEvents verifyAnnoucementBanner()
	{
		driver.findElement(annoucementBanner).isDisplayed();
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: verify NavBar links
	 * parameters: category and url
	 */
	public IndulekhaHomepageEvents verifyNavBarLinks(String category, String Url)
	{
		logger.info("*********Starting of verifyNavBarLinks()**********");
		WebElement navbarCategory = driver.findElement(By.xpath("//height-observer[@id='menuHeader']//nav/ul/li[@id='"+category+"']"));
		logger.pass(navbarCategory.getAccessibleName() +"is present on the page.");
		if(category.contains("Hair Quiz"))
		{
			navbarCategory.click();
			Assert.assertEquals(driver.getCurrentUrl(), Url);
		}
		else
		{
			navbarCategory.click();
			Assert.assertEquals(driver.getCurrentUrl(), Url);
		}
		driver.findElement(img_indulekhaLogo).click();
		logger.info("*********Ending of verifyNavBarLinks()**********");
		return this;
		
	}
	
	/*
	 * Author: Renu
	 * method: click on login button
	 */
	public IndulekhaLoginPageEvents clickOnLogin()
	{
		logger.info("*********Starting of clickOnLogin()**********");
		verifyLeftPositionOfElement(driver.findElement(lnk_CartIcon), driver.findElement(btn_login));
		driver.findElement(btn_login).isDisplayed();
		driver.findElement(btn_login).click();
		logger.info("*********Ending of clickOnLogin()**********");
		return new IndulekhaLoginPageEvents();
	}
	
	/*
	 * Author: Renu
	 * method: this method will verify trackorderIcon on the top of page
	 */
	public IndulekhaHomepageEvents verifyTrackOrderIcon()
	{
		logger.info("*********Starting of verifyTrackOrderIcon()**********");
		driver.findElement(linkTrackMyOrder).isDisplayed();
		verifyLeftPositionOfElement(driver.findElement(linkTrackMyOrder), driver.findElement(btn_login));
		logger.info("*********Ending of verifyTrackOrderIcon()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: this method will click on tracak your order link from global navbar
	 */
	public IndulekhaHomepageEvents clickOnTrackOrderIcon()
	{
		logger.info("*********Starting of clickOnTrackOrderIcon()**********");
		waitTillElementIsClickable(driver.findElement(linkTrackMyOrder));
		driver.findElement(linkTrackMyOrder).click();
		logger.info("*********Ending of clickOnTrackOrderIcon()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify track order page
	 */
	public IndulekhaHomepageEvents verifyTrackOrderPage()
	{
		logger.info("*********Starting of verifyTrackOrderPage()**********");
		verifyHeading("Track Your Order");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.indulekha.co.in/pages/track-order-page");
		driver.findElement(txt_OrderIDOrAWBNo).isDisplayed();
		driver.findElement(txtbx_TrackingID).isDisplayed();
		driver.findElement(btn_SubmitTrackingID).isDisplayed();
		logger.info("*********Ending of verifyTrackOrderPage()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will enter OrderId 
	 * parameters: OrderID
	 */
	public IndulekhaHomepageEvents enterOrderIDOrAWB(String OrderID)
	{
		logger.info("*********Starting of enterOrderIDOrAWB()**********");
		waitTillElementIsClickable(driver.findElement(txtbx_TrackingID));
		driver.findElement(txtbx_TrackingID).sendKeys(OrderID);
		driver.findElement(btn_SubmitTrackingID).click();
		logger.info("*********Ending of enterOrderIDOrAWB()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify tracking details after entering orderID
	 * parameters: OrderID
	 */
	public IndulekhaHomepageEvents verifyTrackingDetails(String OrderID)
	{
		logger.info("*********Starting of verifyTrackingDetails()**********");
		waitTillElementAppear(driver.findElement(trackDetailSection));
		driver.findElement(trackDetailSection).isDisplayed();
		driver.findElement(trackBody).isDisplayed();
		driver.findElement(txt_shippedVia).isDisplayed();
		driver.findElement(txt_deliveryStatus).isDisplayed();
		driver.findElement(txt_Deliverydate).isDisplayed();
		Assert.assertEquals(driver.findElement(txt_trackHead).getText(), "Tracking Order No (Order Id or AWB No) - "+OrderID);
		logger.info("*********Ending of verifyTrackingDetails()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify tracking details for invalid order ID
	 * parameters: OrderID
	 */
	public IndulekhaHomepageEvents verifyTrackingDetailsForInvalidOrderID(String OrderID)
	{
		logger.info("*********Starting of verifyTrackingDetailsForInvalidOrderID()**********");
		driver.findElement(txt_NoTrackIDDes).isDisplayed();
		waitTillElementAppear(driver.findElement(txt_NoTrackIDDes));
		Assert.assertEquals(driver.findElement(txt_NoTrackIDDes).getText(), "Please Enter the correct Order Id or Awb Number");
		logger.info("*********Ending of verifyTrackingDetailsForInvalidOrderID()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify safety advisory
	 */
	public IndulekhaHomepageEvents verifySafetyAdvisory()
	{
		logger.info("*********Starting of verifySafetyAdvisory()**********");
		waitTillElementAppear(driver.findElement(txt_SafetyAdvisory));
		driver.findElement(txt_SafetyAdvisory).isDisplayed();
		verifySubStringPresence(driver.findElement(txt_SafetyAdvisory).getText(), "Safety Advisory");
		verifySubStringPresence(driver.findElement(txt_SafetyAdvisory).getText(), "Cyber crime, particularly fraudulent communications through phone, SMS, WhatsApp, emails, etc. with third parties impersonating as a genuine organization or brand to financially dupe consumers is on the rise.");
		verifySubStringPresence(driver.findElement(txt_SafetyAdvisory).getText(), "Unilever does not request for payment for purchase of our products outside our platform for any promotional activity. We also do not request for payments to participate in any contest, luck draw, free gifts. Hence, we request all consumers to be cautious in the event of any such communications. You can reach out to our customer care listed on our platform to verify any suspicious activity.");
		verifySubStringPresence(driver.findElement(txt_SafetyAdvisory).getText(), "Note: You can also report any suspected fraudulent telecommunications on Chakshu Portal, to the Department of Telecommunications (DOT).");
		logger.info("*********Ending of verifySafetyAdvisory()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify all social media icons 
	 */
	public IndulekhaHomepageEvents verifySocialMediaIcons() throws InterruptedException
	{
		logger.info("*******Starting of the verifySocialMediaIcons() method******");
		driver.findElement(img_FloatingWhatsapp).isDisplayed();
		waitTillElementIsClickable(driver.findElement(img_FloatingWhatsapp));
		hover(driver.findElement(img_FloatingWhatsapp));
		driver.findElement(img_FloatingWhatsapp).click();
		switchToNextTab();
		System.out.println("current url" +driver.getCurrentUrl());
		verifySubStringPresence(driver.getCurrentUrl(), "https://api.whatsapp.com/send/");
		//Assert.assertEquals("Navigating to wrong page",driver.getCurrentUrl(), "https://api.whatsapp.com/send/?phone=919029003150&text=Hey%2C+Let%E2%80%99s+chat+about+Indulekha+.&type=phone_number&app_absent=0");
		closeTabAndReturn();
		logger.pass("Navigated to whatsapp Page");
		driver.findElement(lnk_facebookIcon).isDisplayed();
		waitTillElementIsClickable(driver.findElement(lnk_facebookIcon));
		hover(driver.findElement(lnk_facebookIcon));
		driver.findElement(lnk_facebookIcon).click();
		switchToNextTab();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/IndulekhaCare/");
		closeTabAndReturn();
		logger.pass("Navigated to facebook Page");
		driver.findElement(lnk_TwitterIcon).isDisplayed();
		waitTillElementIsClickable(driver.findElement(lnk_TwitterIcon));
		hover(driver.findElement(lnk_TwitterIcon));
		waitTillElementAppear(driver.findElement(btn_SignUpPopUpNoThanks));
		driver.findElement(btn_SignUpPopUpNoThanks).click();
		driver.findElement(lnk_TwitterIcon).click();
		switchToNextTab();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/i/flow/login?redirect_after_login=%2FIndulekhaCare");
		closeTabAndReturn();
		logger.pass("Navigated to twitter Page");
		driver.findElement(lnk_InstaIcon).isDisplayed();
		waitTillElementIsClickable(driver.findElement(lnk_InstaIcon));
		hover(driver.findElement(lnk_InstaIcon));
		driver.findElement(lnk_InstaIcon).click();
		switchToNextTab();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.instagram.com/accounts/login/?next=https%3A%2F%2Fwww.instagram.com%2Findulekha_care%2F%3Futm_medium&is_from_rle");
		closeTabAndReturn();
		logger.pass("Navigated to Instagram Page");
		driver.findElement(lnk_YoutubeIcon).isDisplayed();
		waitTillElementIsClickable(driver.findElement(lnk_YoutubeIcon));
		hover(driver.findElement(lnk_YoutubeIcon));
		driver.findElement(lnk_YoutubeIcon).click();
		switchToNextTab();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/channel/UC6JF4BuDlDMpN6e_uJ54t9A");
		closeTabAndReturn();
		logger.pass("Navigated to Youtube Page");
		driver.findElement(lnk_BebeIcon).isDisplayed();
		waitTillElementIsClickable(driver.findElement(lnk_BebeIcon));
		hover(driver.findElement(lnk_BebeIcon));
		driver.findElement(lnk_BebeIcon).click();
		switchToNextTab();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bebeautiful.in/");
		closeTabAndReturn();
		logger.pass("Navigated to Bebeautiful Page");
		logger.info("*********Ending of verifySocialMediaIcons()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify product links present in footer section
	 */
	public IndulekhaHomepageEvents verifyFooterProductLink()
	{
		logger.info("*********Starting of verifyFooterProductLink()**********");
		HashMap<String,String> footerProductLinks = new HashMap<String,String>();
		footerProductLinks.put("Indulekha Bringha Hair Oil", "https://www.indulekha.co.in/products/bringha-ayurvedic-hair-growth-oil-100ml");
		footerProductLinks.put("Indulekha Bringha Hair Shampoo", "https://www.indulekha.co.in/products/bringha-ayurvedic-hairfall-shampoo-200ml");
		footerProductLinks.put("Indulekha Bringha Hair  Lepam", "https://www.indulekha.co.in/products/indulekha-bringha-hair-strengthening-lepam-200ml");
		footerProductLinks.put("Indulekha Svetakutaja (Dandruff Treatment) Hair Shampoo", "https://www.indulekha.co.in/products/ayurvedic-dandruff-treatment-shampoo-580ml");
		footerProductLinks.put("Indulekha Svetakutaja (Dandruff Treatment) Hair Oil", "https://www.indulekha.co.in/products/svetakutaja-ayurvedic-anti-dandruff-oil-100ml");
		scrollIntoView(driver.findElement(footerSection));
		if(driver.findElement(btn_SignUpPopUpNoThanks).isDisplayed())
		{
			waitTillElementAppear(driver.findElement(btn_SignUpPopUpNoThanks));
			driver.findElement(btn_SignUpPopUpNoThanks).click();
		}
		for(Entry<String, String> entry: footerProductLinks.entrySet()) {
			scrollIntoView(driver.findElement(footerSection));
			WebElement productLinks =	driver.findElement(By.xpath("//div[@id='bottomFooter']//p[text()='Product Links']/../ul/li/a[text()='"+entry.getKey()+"']"));
			waitTillElementIsClickable(productLinks);
			productLinks.click();
			Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
			driver.navigate().back();	 
		}	
		logger.info("*********Ending of verifyFooterProductLink()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify help links present in footer section
	 */
	public IndulekhaHomepageEvents verifyFooterHelpLink()
	{
		logger.info("*********Starting of verifyFooterHelpLink()**********");
		HashMap<String,String> footerHelpLinks = new HashMap<String,String>();
		footerHelpLinks.put("Testimonials", "https://www.indulekha.co.in/pages/testimonial");
		footerHelpLinks.put("Enquiry & Info", "https://www.indulekha.co.in/pages/contact-us");
		footerHelpLinks.put("Sitemap", "https://www.indulekha.co.in/pages/site-map-new");
		footerHelpLinks.put("Return Policy", "https://www.indulekha.co.in/pages/return-policy");
		footerHelpLinks.put("Refund Policy", "https://www.indulekha.co.in/policies/refund-policy");
		footerHelpLinks.put("Shipping Policy", "https://www.indulekha.co.in/pages/shipping-policy");
		footerHelpLinks.put("Cookie Notice", "https://www.unilevernotices.com/cookie-notices/india-english.html");
		scrollIntoView(driver.findElement(footerSection));
		if(driver.findElement(btn_SignUpPopUpNoThanks).isDisplayed())
		{
			waitTillElementAppear(driver.findElement(btn_SignUpPopUpNoThanks));
			driver.findElement(btn_SignUpPopUpNoThanks).click();
		}
		for(Entry<String, String> entry: footerHelpLinks.entrySet()) {
			scrollIntoView(driver.findElement(footerSection));
			WebElement productLinks =	driver.findElement(By.xpath("//div[@id='bottomFooter']//p[text()='Help']/../ul/li/a[text()='"+entry.getKey()+"']"));
			waitTillElementIsClickable(productLinks);
			productLinks.click();
			Assert.assertEquals(entry.getValue(), driver.getCurrentUrl());
			driver.navigate().back();	 
		}	
		WebElement productLinks =	driver.findElement(By.xpath("//div[@id='bottomFooter']//p[text()='Help']/../ul/li/a[contains(.,'FAQ')]"));
		waitTillElementIsClickable(productLinks);
		productLinks.click();
		Assert.assertEquals("https://www.indulekha.co.in/pages/faqs", driver.getCurrentUrl());
		logger.info("*********Ending of verifyFooterHelpLink()**********");
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: This method will verify contact us section present in footer section
	 */
	public IndulekhaHomepageEvents verifyFooterContactUs()
	{
		logger.info("*********Starting of verifyFooterContactUss()**********");
		waitTillElementAppear(driver.findElement(footerSocialMedia));
		driver.findElement(footerSocialMedia).isDisplayed();
		String phoneNo = driver.findElement(footerTelNumber).getText();
		String mailID = driver.findElement(footerMailID).getText();
		String timingDetails = driver.findElement(footerTimingDetails).getText();
		Assert.assertEquals(phoneNo, "1800-102-2221");
		logger.info(driver.findElement(footerTelNumber).getText()+"is present");
		highlightElement(driver.findElement(footerTelNumber));
		logger.info(driver.findElement(footerMailID).getText()+"is present");
		highlightElement(driver.findElement(footerMailID));
		logger.info(driver.findElement(footerTimingDetails).getText()+"is present");
		highlightElement(driver.findElement(footerTimingDetails));
		Assert.assertEquals(mailID, "lever.care@unilever.com");
		Assert.assertEquals(timingDetails, "Monday – Sunday\n"+"( except public holiday )\n"+"Time - 09.00 am - 06.00 pm");
		logger.info("*********Ending of verifyFooterContactUs()**********");
		return this;
	}
}
