package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.IndulekhaHomeElement;

public class IndulekhaHomepageEvents extends IndulekhaHomeElement{

	IndulekhaHomeElement IndulekhaHomeElementOBJ = new IndulekhaHomeElement();
	IndulekhaLoginPageEvents IndulekhaLoginPageEventsOBJ;
	
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
	
	public IndulekhaHomepageEvents verifyNavBarLinks(String category, String Url)
	{
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
		driver.navigate().back();
		return this;
	}
	
	public IndulekhaLoginPageEvents clickOnLogin()
	{
		verifyLeftPositionOfElement(driver.findElement(linkTrackMyOrder), driver.findElement(btn_login));
		driver.findElement(btn_login).isDisplayed();
		driver.findElement(btn_login).click();
		return new IndulekhaLoginPageEvents();
	}
	
}
