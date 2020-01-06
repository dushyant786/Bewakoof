package com.bewkoof.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Dushyant
 */

public class SearchObject {
	
public WebDriver driver;
	
	public SearchObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//form//input[@placeholder='Search by product, category or collection']")
	WebElement searchBox;
	
	@FindBy(xpath="//h1[contains(text(),'Search Results For :')]")
	WebElement verifyAfter;
	
	
	public void searchProductByText(String product)
	{	
		searchBox.sendKeys(product +Keys.ENTER);
		
	 }
	
	public String verifyAfterSearched()
	{
		return verifyAfter.getText();
	}

}
