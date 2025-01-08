package pageObjects;

import org.openqa.selenium.By;

import base.BaseTest;

public class Tres_PDPElements extends BaseTest{

	protected By txt_productInfoSection = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info");
	protected By img_productImage = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info/../..//media-gallery");
	protected By txt_TaxInclusion = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info//div[contains(@class,'product__tax')]");
	protected By txt_Rating = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info//div[@id='review_btn']");
	protected By lnk_WriteAReview = By.xpath("//div[@id='review_btn']//span[text()='Write a review ']");
	protected By lnk_ProductDetail = By.xpath("//body[@id='Tresemmeproduct']//div[@class='grid__item']//h3[contains(.,'Product Details')]/..");
	protected By txt_ProductDetailSection = By.xpath("//body[@id='Tresemmeproduct']//div[@class='grid__item']//h3[contains(.,'Product Details')]/parent::summary/following-sibling::div");
	protected By lnk_WriteReview = By.xpath("//div[@id='judgeme_product_reviews']//a[text()='Write a review']");
	protected By txtbx_ReviewTitle = By.xpath("//form[@class='jdgm-form']//input[@name='review_title']");
	protected By txtbx_ReviewBody = By.xpath("//form[@class='jdgm-form']//textarea[@name='review_body']");
	protected By txtbx_ReviewerName = By.xpath("//form[@class='jdgm-form']//input[@name='reviewer_name']");
	protected By txtbx_ReviewerEmailID = By.xpath("//form[@class='jdgm-form']//input[@name='reviewer_email']");
	protected By lnk_Term = By.xpath("//form[@class='jdgm-form']//a[text()='terms']");
	protected By lnk_Privacy = By.xpath("//form[@class='jdgm-form']//a[text()='privacy']");
	protected By lnk_Content = By.xpath("//form[@class='jdgm-form']//a[text()='content']");
	protected By btn_SubmitReview = By.xpath("//form[@class='jdgm-form']//input[@value='Submit Review']");
	protected By lnk_CancelReview = By.xpath("//form[@class='jdgm-form']//a[text()='Cancel review']");
	protected By img_ReviewMedia = By.xpath("//form[@class='jdgm-form']//input[@name='media']");
	protected By lnk_Whatsapp = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info//div[contains(@class,'share_button')]//div/p[@class='whatsapp_share_social_icon']");
	protected By lnk_Facebook = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info//div[contains(@class,'share_button')]//div/p[@class='facebook_share_social_icon']");
	protected By lnk_Twitter = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info//div[contains(@class,'share_button')]//div/p[@class='twitter_share_social_icon']");
	protected By btn_BuyOnlne = By.xpath("//button[@id='buyOnlineCstm']/parent::product-info//button[@id='buyOnlineCstm']");
	protected By productPage = By.xpath("//body[@id='Tresemmeproduct']");
	
}
