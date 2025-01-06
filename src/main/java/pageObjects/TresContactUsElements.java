package pageObjects;

import org.openqa.selenium.By;

import base.BaseTest;

public class TresContactUsElements extends BaseTest{

	
	protected By txt_Heading = By.xpath("//body[@id='Tresemmepage.contact']//h1");
	protected By lnk_TelNo = By.xpath("//body[@id='Tresemmepage.contact']//p[text()='Toll Free Number']/..//a");
	protected By img_TelNoIcon = By.xpath("//body[@id='Tresemmepage.contact']//p[text()='Toll Free Number']/..//div[@class='contact_us_svg']");
	protected By lnk_Email = By.xpath("//body[@id='Tresemmepage.contact']//p[text()='Email Us']/..//a");
	protected By img_EmailIcon = By.xpath("//body[@id='Tresemmepage.contact']//p[text()='Email Us']/..//div[@class='contact_us_svg']");
	protected By txtBox_Name = By.xpath("//body[@id='Tresemmepage.contact']//input[@id='ContactForm-name']");
	protected By txtBox_Email = By.xpath("//body[@id='Tresemmepage.contact']//input[@id='ContactForm-email']");
	protected By txtBox_PhoneNum = By.xpath("//body[@id='Tresemmepage.contact']//input[@id='ContactForm-phone']");
	protected By txtBox_Comment = By.xpath("//body[@id='Tresemmepage.contact']//textarea[@id='ContactForm-body']");
	
	
	
	//*************************     BLOG PAGE    ****************************//
	
	protected By txt_BlogTime = By.xpath("//body[@id='Tresemmearticle.custom']//time");
	protected By btn_Share = By.xpath("//body[@id='Tresemmearticle.custom']//button[@class='share-button__button']");
	protected By topBlogPostSection = By.xpath("//body[@id='Tresemmearticle.custom']//div[@id='article_sidebar']");
	protected By tableOfContentSection = By.xpath("//body[@id='Tresemmearticle.custom']//div[@class='toc_container']");
	protected By img_BlogHeroimage = By.xpath("//body[@id='Tresemmearticle.custom']//div[@class='article-template__hero-adapt media']/img");
}
