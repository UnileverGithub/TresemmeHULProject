package base;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	//public ExtentReports extent = new ExtentReports();
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger;

	@BeforeTest
	public void beforeTestMethod()
	{
	//	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"SDETADDAExtentReport.html");
		sparkReporter = new ExtentSparkReporter("index.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		//extent.setSystemInfo("HostName", "RHELB");
		//extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Indulekha Automation Report");
		sparkReporter.config().setReportName("Automation tests results by Renu");
	}
	

	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browser") public void beforeMethod(String browser, Method
	 * testMethod) { logger = extent.createTest(testMethod.getName());
	 * setupDriver(browser); driver.manage().window().maximize();
	 * driver.get(Constants.url);
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); }
	 */
	 //uncomment this when code need to run thru testng.xml
	
	
	
	
	@BeforeMethod
	public void beforeMethod(Method testMethod)
	//public void beforeMethod()
	{
	//	extent = new ExtentReports();
		logger = extent.createTest(testMethod.getName());
		setupDriver("chrome");
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	

    public void captureScreenshot() {
		String ss = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.BASE64);
		logger.pass("Passed Screenshot: Please click 'Base64 img' link present below", MediaEntityBuilder.createScreenCaptureFromBase64String(ss)
				.build());
    }
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed", ExtentColor.RED));}
		else if(result.getStatus() ==ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Pass", ExtentColor.GREEN));}
	//	driver.quit();  -> remov this line when you want to close browser
	}

	@AfterTest
	public void afterTest()
	{
		extent.flush();
	}


	public void setupDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HX957FH\\Downloads\\chromedriver-win64\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); }
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();}
	}
	
	
	public static void openNewTabForYopMail()
	{
		((JavascriptExecutor) driver).executeScript("window.open('https://yopmail.com/')");
	}
	
	/*
	 * public static void clickJSElement(WebElement element) { ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", element); }
	 * 
	 * //scroll into view public static void scrollIntoView(WebElement element) {
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
	 * element); }
	 */
	public static void switchToIframe(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public static void navigateOutFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	
/*	public static boolean verifyElementIsVisible(String elementType, String element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			switch(elementType)
			{
			case "XPATH":
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				 return true;
			case "ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				return true;
				default:
					return false;
		}
        } catch (org.openqa.selenium.TimeoutException e) {
           return false;
        }
	}
	
	*/
	public static boolean verifyElementIsVisible(String elementType, String element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			if(elementType.equals("XPATH"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				return true;
			}
			else if(elementType.equals("ID"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				return true;
			}
			else
					return false;
        } catch (org.openqa.selenium.TimeoutException e) {
           return false;
        }
	}
	
/*	public static void waitForElementVisibility(String elementType, String element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			switch(elementType)
			{
			case "XPATH":
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			case "ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				default:
					
		}
        } catch (org.openqa.selenium.TimeoutException e) {
           
        }
	}
	
	*/
	
	public static void waitForElementVisibility(String elementType, String element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			if(elementType.equals("XPATH"))
			{
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			}
			else if(elementType.equals("ID"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			
        } catch (org.openqa.selenium.TimeoutException e) {
           
        }
	}
	
	public void navigateToDesiredURL(String url)
	{
		driver.navigate().to(url);
	}
	
	//Capitalize first word
	  public static String capitalizeWords(String input) {
	        String[] words = input.split(" ");
	        StringBuilder result = new StringBuilder();

	        for (String word : words) {
	            if (!word.isEmpty()) {
	                // Capitalize the first letter and append the rest of the word
	                result.append(Character.toUpperCase(word.charAt(0)))
	                      .append(word.substring(1))
	                      .append(" ");
	            } else {
	                // If the word is empty, just add a space
	                result.append(" ");
	            }
	        }

	        // Trim the final result to remove the trailing space
	        return result.toString().trim();
	    }
	
	
	
	
	//highlight element
	public void highlightElement(WebElement element) {
        for (int i = 0; i < 1; i++) {
            // Apply a border to the element
        	((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        	captureScreenshot();
            try {
                Thread.sleep(500); // Pause to visualize the border
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Remove the border
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
            try {
                Thread.sleep(500); // Pause to visualize the removal
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
	
	 public void waitTillElementAppear(WebElement element)
		{
			logger.info("****** Starting of waitTillElementAppear() ******");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("****** Ending of waitTillElementAppear() ******");
		}
	
	 	public void waitTillElementIsClickable(WebElement element)
		{
			logger.info("****** Starting of waitTillElementIsClickable() ******");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info("****** Ending of waitTillElementIsClickable() ******");
		}
		
		public void fluentWaitForElement(WebElement element)
		{
			logger.info("****** Starting of fluentWaitForElement() ******");
			FluentWait wait = new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofSeconds(5));
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info("****** Ending of fluentWaitForElement() ******");
		}
		
		/*
		 * Author: Renu
		 * method: select from dropdown using visibile text
		 * parameters: WebElement, Text as visible text
		 */
		
		public void selectByVisibleText(WebElement element,String text)
		{
			logger.info("****** Starting of selectByVisibleText() ******");
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(text);
			logger.info("****** Ending of selectByVisibleText() ******");
		}
		
		/*
		 * Author: Renu
		 * method: select from dropdown using value 
		 * parameters: WebElement, value
		 */
		
		public void selectByValue(WebElement element,String value)
		{
			logger.info("****** Starting of selectByValue() ******");
			Select dropdown = new Select(element);
			dropdown.selectByValue(value);
			logger.info("****** Ending of selectByValue() ******");
		}
		
		/*
		 * Author: Renu
		 * method: hover to any particular element 
		 * parameters: WebElement
		 */
		
		public void hover(WebElement element)
		{
			logger.info("****** Starting of hover() ******");
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();;
			logger.info("****** Ending of hover() ******");
		}
		
		
		public void verifySubStringPresence(String parentString, String childString)
		{
			logger.info("****** Starting of verifySubStringPresence() ******");
			parentString.contains(childString);
			logger.info("****** Ending of verifySubStringPresence() ******");
		}
		
		
		public void scrollIntoView(WebElement element)
		{
			logger.info("****** Starting of scrollIntoView() ******");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			logger.info("****** Ending of scrollIntoView() ******");
		}
		
		public void zoomOut()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='90%'");
		}
		
		public void scrollDown()
		{
			logger.info("****** Starting of scrollDown() ******");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			logger.info("****** Ending of scrollDown() ******");
		}
		
		
		public void scrollUp()
		{
			logger.info("****** Starting of scrollUp() ******");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-450)", "");
			logger.info("****** Starting of scrollUp() ******");
		}
		
		
		public void jsClick(WebElement element)
		{
			logger.info("****** Starting of jsClick() ******");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			logger.info("****** Ending of jsClick() ******");
		}
		
		public void verifyLeftPositionOfElement(WebElement element1LEFT, WebElement element2RIGHT)
		{
			logger.info("****** Starting of verifyLeftPositionOfElement() ******");
			Point pointOfElement1 = element1LEFT.getLocation();
			int xCordOfElement1 = pointOfElement1.getX();
			Point pointOfElement2 = element2RIGHT.getLocation();
			int xCordOfElement2 = pointOfElement2.getX();
			if(xCordOfElement2>xCordOfElement1)
			{
				logger.info(""+element1LEFT.getAccessibleName()+" is at the left side of "+element2RIGHT.getAccessibleName()+"");
			}
			else 
				logger.fail("Element not present");
			
			logger.info("****** Ending of verifyLeftPositionOfElement() ******");
		}
		
		public void verifyRightPositionOfElement(WebElement element1RIGHT, WebElement element2LEFT)
		{
			logger.info("****** Starting of verifyRightPositionOfElement() ******");
			Point pointOfElement1 = element1RIGHT.getLocation();
			int xCordOfElement1 = pointOfElement1.getX();
			Point pointOfElement2 = element2LEFT.getLocation();
			int xCordOfElement2 = pointOfElement2.getX();
			if(xCordOfElement1>xCordOfElement2)
			{
				logger.info(""+element1RIGHT.getAccessibleName()+" is at the right side of "+element2LEFT.getAccessibleName()+"");
			}
			else 
				logger.fail("Element not prensent");
			
			logger.info("****** Ending of verifyRightPositionOfElement() ******");
		}
		
		public void verifyHeading(String heading)
		{
			WebElement activeBreadcrum = driver.findElement(By.xpath("//h1[text()='"+heading+"']|//h2[text()='"+heading+"']|//h3[text()='"+heading+"']|//div[text()='"+heading+"']|//h1[contains(.,'"+heading+"')]"));
			activeBreadcrum.isDisplayed();
		}
		
		public void verifyPreHeading(String preHeading)
		{
			WebElement activeBreadcrum = driver.findElement(By.xpath("//p[text()='"+preHeading+"']"));
			activeBreadcrum.isDisplayed();
		}
		
		 public void switchToNextTab() {
			    logger.info("****** Starting of switchToNextTab() ******");
		        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tab.get(1));
		        logger.info("****** Ending of switchToNextTab() ******");
		    }
		    
		    public void closeAndSwitchToNextTab() {
		    	logger.info("****** Starting of closeAndSwitchToNextTab() ******");
		    	driver.close();
		        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tab.get(1));
		        logger.info("****** Ending of closeAndSwitchToNextTab() ******");
		    }

		    public void switchToPreviousTab() {
		    	logger.info("****** Starting of switchToPreviousTab() ******");
		        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tab.get(0));
		        logger.info("****** Ending of switchToPreviousTab() ******");
		    }

		    public void closeTabAndReturn() {
		    	logger.info("****** Starting of closeTabAndReturn() ******");
		    	driver.close();
		        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tab.get(0));
		        logger.info("****** Ending of closeTabAndReturn() ******");
		    }

		    public void switchToPreviousTabAndClose() {
		    	logger.info("****** Starting of switchToPreviousTabAndClose() ******");
		        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tab.get(1));
		        driver.close();
		        logger.info("****** Ending of switchToPreviousTabAndClose() ******");
		    }
		    
		    public static boolean checkImageResolution(String imageUrl, int minWidth, int minHeight) {
		        try {
		            URL url = new URL(imageUrl);
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("GET");
		            connection.setConnectTimeout(5000); // Timeout if needed
		            connection.connect();

		            if (connection.getResponseCode() == 200) {
		                // Read image from URL
		                InputStream inputStream = connection.getInputStream();
		                BufferedImage image = ImageIO.read(inputStream);

		                int width = image.getWidth();
		                int height = image.getHeight();

		                // Check if resolution meets the requirement
		                return width >= minWidth && height >= minHeight;
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        return false; // Return false if there was an error
		    }
		    

}