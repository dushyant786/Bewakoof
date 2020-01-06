package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Dushyant
 */

public class ProductCartObject {
	
public WebDriver driver;
	
	public ProductCartObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@id='testProductcard_3']//div[@class='productCardImg false']//img")
	WebElement product;
	
	@FindBy(css="#testCheckCod")
	WebElement pincode;
	
	@FindBy(id="testCodSubmit")
	WebElement check;
	
	@FindBy(xpath="//li[contains(text(),'Expected delivery:')]")
	WebElement available;
	
	@FindBy(css="#addToCart")
	WebElement cart;
	
	@FindBy(xpath="//a[@class='cartIcon']")
	WebElement viewCartButton;
	
	@FindBy(xpath="//b[contains(text(),'My Bag')]")
	WebElement myBag;
	
	public void clickOnProduct()
	{
		product.click();
	}
	
	public void setPincode(String code)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement pin = wait.until(ExpectedConditions.visibilityOf(pincode));
		
		pin.sendKeys(code);
		
		check.click();
	}
	
	public String checkAvailability()
	{
		return available.getText();
	}
	
	public void addToCart()
	{
		cart.click();
	}
	
	public void viewCart()
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(viewCartButton);
		
		viewCartButton.click();
	}
	
	public String verifyProductInCart()
	{
		return myBag.getText();
	}
	
	

}
