package pageObjects;

import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class IndulekhaPDPElements extends BaseTest{
	
	
	
	
	
	
	public IndulekhaPDPElements()
    {
    	this.driver = driver ;
    	PageFactory.initElements(driver,this);
    }

}
