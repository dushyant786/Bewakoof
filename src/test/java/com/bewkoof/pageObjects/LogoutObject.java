package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Dushyant
 */

public class LogoutObject {
	
	public WebDriver driver;
	
	public LogoutObject(WebDriver driver)
	{
		this.driver = driver;
	}

	@FindBy(css="#web_logout")
	WebElement logout;
	
	@FindBy(css="#loginLink")
	WebElement verifyAfter;
	
	public void logout()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
			
	    WebElement l =wait.until(ExpectedConditions.visibilityOf(logout));
		
		l.click();
	}
	
	public String verifyAfterLogout()
	{	
		return verifyAfter.getText();
	}
}
