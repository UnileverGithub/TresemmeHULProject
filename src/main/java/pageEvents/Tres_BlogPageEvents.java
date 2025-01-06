package pageEvents;

import org.testng.Assert;

import pageObjects.TresContactUsElements;

public class Tres_BlogPageEvents extends TresContactUsElements{

	
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
}
