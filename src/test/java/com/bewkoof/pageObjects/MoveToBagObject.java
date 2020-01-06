package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Dushyant
 */

public class MoveToBagObject {
	
public WebDriver driver;
	
	public MoveToBagObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@id='testWishlistProduct_3']//button[contains(@class,'addToBag')][contains(text(),'MOVE TO BAG')]")
	WebElement bag;
	
	@FindBy(xpath="//h1[contains(text(),'Search Results For :')]")
	WebElement verifyAfter;
	
	public void  moveToBag()
	{
		bag.click();
	 } 

}
