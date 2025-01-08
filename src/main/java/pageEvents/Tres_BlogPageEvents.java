package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.TresContactUsElements;

public class Tres_BlogPageEvents extends TresContactUsElements{

	Tres_PDPEvents Tres_PDPEventsOBJ = new Tres_PDPEvents();
	
	public Tres_BlogPageEvents verifyBlogPage(int widthRatio, int heightRatio)
	{
		waitTillElementAppear(driver.findElement(txt_BlogTime));
		driver.findElement(txt_BlogTime).isDisplayed();
		waitTillElementAppear(driver.findElement(btn_Share));
		driver.findElement(btn_Share).isDisplayed();
		waitTillElementAppear(driver.findElement(topBlogPostSection));
		driver.findElement(topBlogPostSection).isDisplayed();
		waitTillElementAppear(driver.findElement(tableOfContentSection));
		driver.findElement(tableOfContentSection).isDisplayed();
		waitTillElementAppear(driver.findElement(img_BlogHeroimage));
		int width = driver.findElement(img_BlogHeroimage).getRect().getWidth();
        int height = driver.findElement(img_BlogHeroimage).getRect().getHeight();
        Assert.assertEquals(width, widthRatio);
        Assert.assertEquals(height, heightRatio);
       return this;
	}
	
	public Tres_BlogPageEvents verifyBlogProductTile(String skuID,String title)
	{
		WebElement productImg = driver.findElement(By.xpath("//div[@id='"+skuID+"']//div[@class='card__media  ']//img"));
		WebElement productTitle = driver.findElement(By.xpath("//div[@id='"+skuID+"']//h3[@class='card__heading h5']/a"));
		productImg.isDisplayed();
		productTitle.isDisplayed();
		Assert.assertTrue(productTitle.getText().equalsIgnoreCase(title), "Title is not same");
		productTitle.click();
		Tres_PDPEventsOBJ.verifyProductPage();
		navigateToDesiredURL("https://www.tresemme.in/blogs/style-with-tresemme/unlocking-the-power-of-hair-serums-getting-the-most-out-of-your-hair-savior");
		driver.navigate().refresh();
		WebElement btn_ViewProduct = driver.findElement(By.xpath("//div[@id='"+skuID+"']//button[@id='buyOnlineCstm']"));
		btn_ViewProduct.isDisplayed();
		btn_ViewProduct.click();
		Tres_PDPEventsOBJ.verifyProductPage();
		return this;
	}
}
