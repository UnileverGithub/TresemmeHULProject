package PDPPageTestCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.Tres_PDPEvents;

public class verifyProductSummarySection extends BaseTest{

	Tres_PDPEvents Tres_PDPEventsOBJ = new Tres_PDPEvents();
	
	@Test @Ignore
	public void verifyPDPProductDescriptionTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product Description summary should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyProductAccordian("Description");
	}
	
	@Test @Ignore
	public void verifyPDPProductHowToUseTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product How to use should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyProductAccordian("How to use");
	}
	
	@Test @Ignore
	public void verifyPDPProductIngredientsTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product How to use should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyProductAccordian("Ingredients");
	}
	
	@Test @Ignore
	public void verifyPDPProductDetailsTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product detail should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyProductAccordian("Product Details");
	}
	
	@Test @Ignore
	public void verifyPDPProductLegalMandateTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product detail should be present<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyLegalMandatory();
	}
	
	@Test @Ignore
	public void verifyPDPProductWriteReviewTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product write review section <br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyWriteReviewSection(4);
	}
	
	@Test @Ignore
	public void verifyPDPProductShareOnLinksTresemme()
	{
		
		String message = "<b>Given:</b> go to product page of tresemme <br>"
				+ "<b>When:</b> verify tresemme product page should displayed <br>"
				+ "<b>Then:</b> verify product share on links should be working fine <br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-gloss-ultimate-hair-serum-100ml");
		Tres_PDPEventsOBJ.verifyShareOnLinks();
	}
	

	@Test
	public void verifyBuyOnlineFunctionality()
	{
		String message = "<b>Given:</b> go to tresemme site <br>"
				+ "<b>When:</b> verify tresemme home page should display <br>"
				+ "<b>Then:</b> verify buy online should open pop up having different vendors<br>"
				+ "<b>Then:</b> verify different ecommerce links should redirect to its respective page<br>";
		logger.info(message);
		navigateToDesiredURL("https://www.tresemme.in/products/tresemme-bond-plex-repair-shampoo-with-complex-technology");
		Tres_PDPEventsOBJ.verifyCommerceConnectorBrandsLinks();
	}
}
