package com.bewkoof.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bewkoof.pageObjects.LoginObject;
import com.bewkoof.pageObjects.LogoutObject;
import com.bewkoof.pageObjects.SignUpObject;

/**
 * @author Dushyant
 */

public class TC_SignUp_DDT_004 extends BaseRoom{
	
	LoginObject lo;
	
	LogoutObject log;
	
	SignUpObject sp;
	
	
	@Test(description = "Sign Up Into Bewakoof ",dataProvider = "Bewakoof Data")
	
	public void createAccountOnBewakoof(String fname,String lname,String number,String mailid,String pas,String code,String gender)
	{
		lo = PageFactory.initElements(driver, LoginObject.class);
		
		log = PageFactory.initElements(driver, LogoutObject.class);
		
		sp = PageFactory.initElements(driver, SignUpObject.class);
		
		lo.clickOnLoginLink();
		
		sp.clickOnSignUpLink();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e0) 
		{
			System.out.println(e0);
		}
		
		sp.clickOnSignUpWithMobile();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		
		Assert.assertTrue(sp.verifyBeforeSignUp().contains("Sign Up")," Invalid Sign Up Page ");
		
		sp.setFirstName(fname);
		
		sp.setLastName(lname);
		
		sp.setMobileNumber(number);
		
		sp.setEmaiId(mailid);
		
		sp.setPassword(pas);
		
		sp.setSex(gender);
		
		 sp.submit(); 
		 
		 try
		  {
			 Thread.sleep(2000);
		  }
		 catch(InterruptedException i)
		  {
			  System.out.println(i);
		   }
		 
		 Boolean Text = driver.getPageSource().contains("Have an account? ");
		 
		if(Text==true)
		{
			   getScreenshot("Signup Failed");
			
			  driver.navigate().refresh();
			  
			  Assert.assertTrue(false," Test Failed Becasue may be mobile number,mailId is already used");
		}
		else {
		 
		 sp.closePopup();
		 
		}
		 
		 try
		  {
			 Thread.sleep(1000);
		  }
		 catch(InterruptedException e1)
		  {
			  System.out.println(e1);
		   }
		
		lo.goToDropdown();
		
		Assert.assertTrue(sp.verifyAfterSignUp().contains("Hi, ")," User Account is not created ");
		
		System.out.println("==========User Account Sucessfully Created==============");
		
		log.logout();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e2) 
		{
			System.out.println(e2);
		}
		
		Assert.assertTrue(log.verifyAfterLogout().contains("Login")," User Not Logout From Application ");
		
		System.out.println("==========User Sucessfully Logout===============");
		
	  }
	  
}
