package com.bewkoof.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Dushyant
 */

public class SignUpObject {
	
public WebDriver driver;
	
	public SignUpObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(css="#mob_sign_up")
	WebElement signupLink;
	
	@FindBy(xpath="//button[@class='signupWidMobileBtn']")
	WebElement signupWithMobile;
	
	@FindBy(name="fname")
	WebElement firstName;
	
	@FindBy(name="lname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='mobile']")
	WebElement mobileNumber;
	
	@FindBy(name="email")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="referrer_code")
	WebElement referral;
	
	@FindBy(xpath="//span[contains(text(),'Male')]")
	WebElement male;
	
	@FindBy(xpath="//span[contains(text(),'Female')]")
	WebElement female;
	
	@FindBy(xpath="//button[@class='loginSubmit']")
	WebElement submitSignUp;
	
	@FindBy(xpath="//i[@class='close_popup_target icon_close']")
	WebElement popup;
	
	@FindBy(xpath="//p[contains(text(),'Sign Up')]")
	WebElement verifyBefore;
	
	@FindBy(xpath="//div[contains(@class,'mainHeaderWrapper')]//li[1]")
	WebElement verifyAfter;
	
	public void clickOnSignUpLink()
	{
		signupLink.click();
	}
	
	public void clickOnSignUpWithMobile()
	{
		signupWithMobile.click();
	}
	
	public void setFirstName(String Fname)
	{	
		firstName.sendKeys(Fname);	
	 }
	
	public void setLastName(String Lname)
	{	
		lastName.sendKeys(Lname);	
	 }
	
	public void setMobileNumber(String num)
	{	
		mobileNumber.sendKeys(num);	
	 }
	
	public void setEmaiId(String id)
	{	
		emailid.sendKeys(id);	
	 }
	
	public void setPassword(String pas)
	{	
		pass.sendKeys(pas);	
	 }
	
	public void setReferral(String code)
	{	
		referral.sendKeys(code);	
	 }
	
	public void setSex(String sex)
	{	
		if(sex.equalsIgnoreCase("Male"))	
		{
			male.click();
		}
		else if(sex.equalsIgnoreCase("Female"))
		{
			female.click();
		}
		else
		{
			System.out.println(" Invalid Sex(Gender should be either Male or Female");
		}
	 }
	
	public void submit()
	{	
		submitSignUp.click();	
	 }
	
	public void closePopup()
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		wait.until(ExpectedConditions.visibilityOf(popup)).click();
	 }
	
	public String verifyBeforeSignUp()
	{
		return verifyBefore.getText();
	}
	
	public String verifyAfterSignUp()
	{
		return verifyAfter.getText();
	}


}
