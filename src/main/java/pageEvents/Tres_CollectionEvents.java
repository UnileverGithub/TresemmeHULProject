package pageEvents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.Tres_CollectionElements;
import utils.Consoleloggers;

public class Tres_CollectionEvents extends Tres_CollectionElements{
	
	Logger log = Consoleloggers.getLogger(Tres_CollectionEvents.class);
	
	
	/*
	 * Author: Renu
	 * method: to selectSortByOption
	 * parameters: value = "best-selling", "title-ascending","title-descending", "price-ascending", "price-descending","created-ascending","created-descending"
	 */
	public Tres_CollectionEvents selectSortByOption(String value) throws InterruptedException
	{
		waitTillElementIsClickable(driver.findElement(dropdown_SortBy));
		driver.findElement(dropdown_SortBy).click();
		Thread.sleep(2000);
		WebElement dropList = driver.findElement(By.xpath("//form[@id='FacetSortForm']//select[@id='SortBy']//option[@value='"+value+"']"));
		//jsClick(dropList);
		dropList.click();
		Thread.sleep(2000);
		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to validateSortingAtoZ
	 * parameters: productId, productTitle
	 */
	public Tres_CollectionEvents validateSortingAtoZ()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='ProductGridContainer']//div[@class='card__content']//h3")); // Update with the correct selector

        // Extract text from elements into a list
        List<String> actualList = new ArrayList<>();
        for (WebElement element : elements) {
            actualList.add(element.getText());
        }

        // Create a copy of the list and sort it alphabetically
        List<String> sortedList = new ArrayList<>(actualList);
        Collections.sort(sortedList);

        // Validate if the actual list is equal to the sorted list
        if (actualList.equals(sortedList)) {
            System.out.println("The list is sorted alphabetically (A-Z).");
        } else {
            System.out.println("The list is NOT sorted alphabetically.");
        }
		return this;
	}
	
	
	/*
	 * Author: Renu
	 * method: to validateSortingZtoA
	 * 
	 */
	public Tres_CollectionEvents validateSortingZtoA()
	{
		List<WebElement> titleElements = driver.findElements(By.xpath("//div[@id='ProductGridContainer']//div[@class='card__content']//h3")); // Update with the correct selector
		 List<String> actualTitles = new ArrayList<>();
         for (WebElement titleElement : titleElements) {
             actualTitles.add(titleElement.getText().trim());
         }

         // Print the extracted titles
         System.out.println("Actual Titles:");
         actualTitles.forEach(System.out::println);

         // Create a copy of the list and sort it in Z-A order
         List<String> expectedTitles = new ArrayList<>(actualTitles);
         expectedTitles.sort(Collections.reverseOrder());

         // Print the expected sorted titles
         System.out.println("\nExpected Titles (Z-A):");
         expectedTitles.forEach(System.out::println);

         // Validate if the titles are sorted in Z-A order
         if (actualTitles.equals(expectedTitles)) {
             System.out.println("\nThe titles are sorted in Z-A order.");
         } else {
            Assert.fail("\\nThe titles are NOT sorted in Z-A order.");
         }

		return this;
	}
	
	
	/*
	 * Author: Renu
	 * method: to validateSortingHighToLowPricw
	 * 
	 */
	public Tres_CollectionEvents validateSortingHighToLowPrice()
	{
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[@id='ProductGridContainer']//div[@class='card__content']//div[@class='price__container']//span/s[contains(@class,'price-item')]")); // Replace with actual locator

         // Extract prices into a list
         List<Double> actualPrices = new ArrayList<>();
         for (WebElement priceElement : priceElements) {
             String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim(); // Remove ₹ symbol and commas
             actualPrices.add(Double.parseDouble(priceText));
         }

         // Print the extracted prices
         System.out.println("Actual Prices:");
         actualPrices.forEach(System.out::println);

         // Create a copy of the list and sort it in descending order
         List<Double> expectedPrices = new ArrayList<>(actualPrices);
         expectedPrices.sort(Collections.reverseOrder());

         // Print the expected sorted prices
         System.out.println("\nExpected Prices (Sorted High to Low):");
         expectedPrices.forEach(System.out::println);

         // Validate if the prices are sorted in High to Low order
         if (actualPrices.equals(expectedPrices)) {
             System.out.println("\nThe prices are correctly sorted from High to Low.");
         } else {
             Assert.fail("\\nThe prices are not correctly sorted from High to Low.");
         }

		return this;
	}
	
	/*
	 * Author: Renu
	 * method: to validateSortingHighToLowPricw
	 * 
	 */
	public Tres_CollectionEvents validateSortingLowToHighPrice()
	{
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[@id='ProductGridContainer']//div[@class='card__content']//div[@class='price__regular']//span[contains(@class,'price-item')]")); // Replace with actual locator

         // Extract prices into a list
         List<Double> actualPrices = new ArrayList<>();
         for (WebElement priceElement : priceElements) {
             String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim(); // Remove ₹ symbol and commas
             actualPrices.add(Double.parseDouble(priceText));
         }

         // Print the extracted prices
         System.out.println("Actual Prices:");
         actualPrices.forEach(System.out::println);

         // Create a copy of the list and sort it in descending order
         List<Double> expectedPrices = new ArrayList<>(actualPrices);
         Collections.sort(expectedPrices); 

         // Print the expected sorted prices
         System.out.println("\nExpected Prices (Sorted High to Low):");
         expectedPrices.forEach(System.out::println);

         // Validate if the prices are sorted in High to Low order
         if (actualPrices.equals(expectedPrices)) {
             System.out.println("\nThe prices are correctly sorted from High to Low.");
         } else {
             Assert.fail("\nThe prices are NOT sorted from Low to High.");
         }

		return this;
	}
}
