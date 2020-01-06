package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



/**
 * @author Dushyant
 */

public class LoginObject {
	
	public WebDriver driver;
	
	public LoginObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(id="loginLink")
	WebElement loginLink;
	
	@FindBy(name="username")
	WebElement emailId;
	
	@FindBy(id="mob_password")
	WebElement password;
	
	@FindBy(css="#mob_continue_submit")
	WebElement Continue;
	
	@FindBy(xpath="//p[contains(text(),'Log In')]")
	WebElement verifyBefore;
	
	@FindBy(xpath="//a[@id='testHeaderAcc']")
	WebElement menu;
	
	@FindBy(xpath="//div[contains(@class,'mainHeaderWrapper')]//li[1]")
	WebElement verifyAfter;
	
	public void clickOnLoginLink()
	{
		loginLink.click();
	}
	
	public void setEmailId(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void setPassword(String pass)
	{	
		password.sendKeys(pass);
	}
	
	public void submitLogin()
	{
		Continue.click();
	}
	
	public String verifyBeforeLogin()
	{
		return verifyBefore.getText();
	}
	
	public void goToDropdown()
	{
        Actions act = new Actions(driver);
		
		act.moveToElement(menu).build().perform();
	}
	
	public String verifyAfterLogin()
	{
		return verifyAfter.getText();
	}
	
}
