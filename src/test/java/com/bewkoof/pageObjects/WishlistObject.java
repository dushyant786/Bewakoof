package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Dushyant
 */

public class WishlistObject {
	
public WebDriver driver;
	
	public WishlistObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(css="#testWishButton")
	WebElement wishlist;
	
	@FindBy(xpath="//button[@id='testWishButtonFilled']")
	WebElement checking;
	
	@FindBy(css="#testHeadWish")
	WebElement wishlistPage;
	
	@FindBy(xpath="//div[text()='WISHLIST']")
	WebElement verify;
	
	
	public void addToWishlist()
	{
		wishlist.click();
	 }
	
	public Boolean checkItemAddedToWishlist()
	{
		return checking.isDisplayed();
	 }
	 
	public void goToWishlistPage()
	{
		wishlistPage.click();
	}
	
	public String verifyWishlistPage()
	{
		return verify.getText();
	}

}
