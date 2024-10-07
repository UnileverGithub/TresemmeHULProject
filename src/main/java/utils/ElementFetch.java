package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

/*
public class ElementFetch {
	public WebElement getwebElement(String indentifierType, String identifierValue)
	{
		switch(indentifierType)
		{
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
			
			default:
		return null;
	}
	}
	
*/	
	public class ElementFetch {
		public WebElement getwebElement(String indentifierType, String identifierValue)
		{
			if(indentifierType.equals("XPATH"))
			return BaseTest.driver.findElement(By.xpath(identifierValue));
			else if(indentifierType.equals("ID"))
				return BaseTest.driver.findElement(By.id(identifierValue));
			else
			return null;
		}
	
	
/*	
	public List<WebElement> getwebElements(String indentifierType, String identifierValue)
	{
		switch(indentifierType)
		{
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
			
			default:
		return null;
	}
	}
*/
		
		public List<WebElement> getwebElements(String indentifierType, String identifierValue)
		{
			if(indentifierType.equals("XPATH"))
				return BaseTest.driver.findElements(By.xpath(identifierValue));
			else if(indentifierType.equals("ID"))
				return BaseTest.driver.findElements(By.id(identifierValue));
			else 
			return null;
		}
}
