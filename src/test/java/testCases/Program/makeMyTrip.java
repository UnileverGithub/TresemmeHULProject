package testCases.Program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTrip {
	@Test
	public void testingTC() throws Exception
	{
		String ele = "//span[text()='{Dynamic}']";
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\WM563BM\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(7000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'webklipper-publisher')]")));
		driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']")).isDisplayed();
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).isDisplayed();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@role='listbox']//li//p[contains(text(),'Chennai')]/../..")).isDisplayed();
		driver.findElement(By.xpath("//ul[@role='listbox']//li//p[contains(text(),'Chennai')]/../..")).click();
		driver.navigate().back();
		
	}

}
