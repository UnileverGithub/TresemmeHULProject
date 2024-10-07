package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {
	WebDriver driver;
	public LoginScreen(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 By loginButton = By.xpath("//button[text()='Login']");
	
	public void login()
	{
		driver.findElement(loginButton).click();
	}
		
}
