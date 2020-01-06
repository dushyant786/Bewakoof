/**
 * 
 */
package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Dushyant
 */

public class HomeObject {

public WebDriver driver;
	
	public HomeObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[@class='active']//img | //div[@class='col-xs-2 mainHeaderCols bewakoofLogoDiv']//a//img")
	WebElement homeLink;
	
	public void goTOHomePage()
	{
        Actions act = new Actions(driver);
		
		act.moveToElement(homeLink);
		
		homeLink.click();
	 }

}
