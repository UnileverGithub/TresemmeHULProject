package pageObjects;

public interface BundleOfferElements {
	String buy3Banner = "//div[@class='desktop-banner']//img[@alt='Buy 3 at ₹999 | Buy 4 at ₹1299 ']";
	String productCount = "//article[@class='productitem cstm-productitem']";
	String buy3Tag = "//article[@class='productitem cstm-productitem']//p[text()='BUY 3 @ ₹999']";
	String buy4Tag= "(//div[@class='product-block__inner']//span[text()='BUY 4 @ 1799'])[Dynamic]";
	String buildYourBundleHeading="//p[contains(text(),'Buy 3 at ₹999 | Buy 4 at ₹1299')]";
	

}
