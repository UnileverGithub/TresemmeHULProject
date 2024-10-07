package pageEvents;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseTest;
import pageObjects.BookingPageElements;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class BookingPageEvents extends BaseTest{
		ElementFetch element = new ElementFetch();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * To close faith and preferred language popUp
		 * Parameters : None
		 * Created By : Sonam
		 */
		public BookingPageEvents clickInvoice() throws InterruptedException
		{
			String mainWindowHandle = driver.getWindowHandle();
			Thread.sleep(4000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		//	js.executeScript("arguments[0].scrollIntoView(true);", element.getwebElement("XPATH", BookingPageElements.invoiceButton));
		//	element.getwebElement("XPATH", BookingPageElements.invoiceButton).isDisplayed();
		//	js.executeScript("arguments[0].click();", element.getwebElement("XPATH", BookingPageElements.invoiceButton));
		//	element.getwebElement("XPATH", BookingPageElements.invoiceButton).click();
			clickDownloadNowLink(mainWindowHandle);
			return this;
		}
		
		public BookingPageEvents clickDownloadNowLink(String mainWindowHandle) throws InterruptedException
		{
			Set<String> allWindowHandles = driver.getWindowHandles();
	        // Loop through the window handles to find the new window
	        for (String windowHandle : allWindowHandles) {
	            if (!windowHandle.equals(mainWindowHandle)) {
	                // Switch to the new window
	                driver.switchTo().window(windowHandle);
	        Thread.sleep(4000);
		//	element.getwebElement("XPATH", BookingPageElements.downloadLink).isDisplayed();
			JavascriptExecutor js = (JavascriptExecutor) driver;
	//		js.executeScript("arguments[0].click();", element.getwebElement("XPATH", BookingPageElements.downloadLink));
	            }
	        }
	        
	        try {
	            Thread.sleep(5000); // Wait for 5 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        // Define the source and destination paths
	        String downloadPath = System.getProperty("user.home") + "/Downloads"; // Default download location
	        String fileName = "Service Invoice.pdf";
	        String destinationPath = System.getProperty("user.home") + "/Downloads/Invoices/" + fileName;

	        // Move the downloaded file to the desired location
	        File sourceFile = new File(downloadPath + "/" + fileName);
	        File destinationFile = new File(destinationPath);

	        try {
	            Path source = sourceFile.toPath();
	            Path destination = destinationFile.toPath();
	            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return this;
		}

}
