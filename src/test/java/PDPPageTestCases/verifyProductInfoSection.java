package PDPPageTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_PDPEvents;

public class verifyProductInfoSection extends BaseTest{

	Tres_PDPEvents Tres_PDPEventsOBJ = new Tres_PDPEvents();
	public static final String productID = "43181143785680";
	public static final String productTitle = "TRESEMMÉ BOND PLEX REPAIR SHAMPOO WITH COMPLEX TECHNOLOGY";
	public static final String productSalesPrice = "₹428";
	public static final String productMRPPrice = "₹475";
	
	@Test 
	public void verifyPDPProductTitleTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product title should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-bond-plex-repair-shampoo-with-complex-technology");
		Tres_PDPEventsOBJ.verifyProductTitle(productID, productTitle);
	}
	
	@Test 
	public void verifyPDPProductPriceTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product title should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-bond-plex-repair-shampoo-with-complex-technology");
		Tres_PDPEventsOBJ.verifyProductPrice(productID, productSalesPrice, productMRPPrice);
	}
	
	@Test 
	public void verifyPDPProductReviewTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product review should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyProductReview(5,2);
	}
}
