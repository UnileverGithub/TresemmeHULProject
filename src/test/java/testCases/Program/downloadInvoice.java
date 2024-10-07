package testCases.Program;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageEvents.BookingPageEvents;
import utils.ExcelUtils;

public class downloadInvoice{
	BookingPageEvents booking = new BookingPageEvents();
	ExcelUtils excel = new ExcelUtils("C:\\Users\\WM563BM\\eclipse-workspace\\TestingIMAvatarProject\\src\\main\\resources\\IAmAvatarExcel.xlsx");
	
	@Test
	public void testingDownloadInvoice() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.imavatar.com/devotee/payment-information/9432");
		driver.manage().window().maximize();
		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(8000);
		WebElement invoiceButton = driver.findElement(By.xpath("//button[text()='Invoice']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", invoiceButton);
		invoiceButton.isDisplayed();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", invoiceButton);
		clickDownloadLink(driver, mainWindowHandle);
	}
	
	public void clickDownloadLink(WebDriver driver, String mainWindowHandle) throws Exception
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
        // Loop through the window handles to find the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
        Thread.sleep(4000);
        WebElement downloadLink = driver.findElement(By.xpath("//a[text()='Download now!']"));
        downloadLink.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", downloadLink);
            }
        }
        
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Define source and destination paths
        String downloadPath = System.getProperty("user.home") + "/Downloads"; // Default download location
        String fileName = "Service Invoice.pdf";
        String destinationPath = System.getProperty("user.home") + "/Downloads/Invoices/" + fileName;

        // Move downloaded file to the desired location
        File sourceFile = new File(downloadPath + "/" + fileName);
        File destinationFile = new File(destinationPath);

        try {
            Path source = sourceFile.toPath();
            Path destination = destinationFile.toPath();
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
