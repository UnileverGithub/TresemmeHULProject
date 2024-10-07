package testCases.Program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleTest {
	
	@Test
	public void testingTC() throws Exception
	{
		String ele = "//span[text()='{Dynamic}']";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='app']")));
		driver.findElement(By.xpath(ele.replace("{Dynamic}", "YouTube"))).isDisplayed();
		driver.findElement(By.xpath(ele.replace("{Dynamic}", "YouTube"))).click();
		driver.switchTo().defaultContent();
		driver.navigate().back();
		
	}

}
