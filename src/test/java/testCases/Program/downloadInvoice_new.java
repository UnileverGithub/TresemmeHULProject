package testCases.Program;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadInvoice_new {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.imavatar.com/devotee/invoice/9432");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		Thread.sleep(4000);
		Thread.sleep(4000);
        WebElement downloadLink = driver.findElement(By.xpath("//a[text()='Download now!']"));
        downloadLink.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", downloadLink);
        
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
