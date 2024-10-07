package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.AllProductEvents;
import pageEvents.HomePageEvents;
import pageEvents.ShoppingCartPageEvents;
import utils.ExcelUtils;

public class AllProductDataVerification extends BaseTest{
	
	HomePageEvents homepage = new HomePageEvents();
	ShoppingCartPageEvents cart = new ShoppingCartPageEvents();
	ExcelUtils excel = new ExcelUtils("C:\\Users\\WM563BM\\Downloads\\UV Squad all active product.xlsx");
	AllProductEvents allProduct = new AllProductEvents();
	
	@Test
	public void verifyAllProductSection() throws InterruptedException
	{
		navigateToDesiredURL("https://www.a-squad.in/collections/a-squad-all-products");
		String[] websiteData = allProduct.verifyAllProductPage()
		.getAllProductTitle_A_squad();
		String[] allProductData = excel.getColumnData("Sheet1", 0);
		for (String data : allProductData) {
            System.out.println(data);
        }
		allProduct.matchAllProductPage(allProductData, websiteData);
	}

	

}
