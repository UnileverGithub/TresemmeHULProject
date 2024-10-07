package testCases.Program;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginScreen;

public class TestingFirstProgram {
	WebDriver driver;
    LoginScreen loginScreen;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\WM563BM\\Downloads\\chromedriver-win64\\chromedriver.exe");  
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("http://qa.imavatar.com/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//driver.findElement(By.xpath("//input[@name='pincode']")).click();
		WebElement submitEle = driver.findElement(By.xpath("//button[@type='submit']"));
		jsExecutor.executeScript("arguments[0].click();", submitEle);
	//	driver.findElement(By.xpath("//button[@type='submit']/..")).click();
		
	//	WebElement submitEle = driver.findElement(By.xpath("//button[@type='submit']"));
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[text()='Next']")).isDisplayed();
		Thread.sleep(8000);
		WebElement nexttEle = driver.findElement(By.xpath("//button[text()='Next']"));
		jsExecutor.executeScript("arguments[0].click();", nexttEle);
		Thread.sleep(8000);
	    jsExecutor.executeScript("document.getElementsByName('date')[0].value='2023-10-14'");
	    
	    
	    WebElement time = driver.findElement(By.xpath("//input[@type='time']"));
	    jsExecutor.executeScript("arguments[0].value = arguments[1];", time, "13:00");
        	
	}
	
	@Test
	public void loginToImavatar()
	{
		loginScreen = new LoginScreen(driver);
		loginScreen.login();
	}
	
	@AfterTest
	public void aftertest()
	{
	//	driver.quit();
	}

}
