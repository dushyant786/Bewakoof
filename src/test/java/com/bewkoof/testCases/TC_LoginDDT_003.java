/**
 * 
 */
package com.bewkoof.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.bewkoof.pageObjects.LoginObject;
import com.bewkoof.pageObjects.LogoutObject;

/**
 * @author Dushyant
 */

public class TC_LoginDDT_003 extends BaseRoom {
	
	LoginObject lo;
	
	LogoutObject log;
	
	@Test(priority=0,description = "User Login Into Application",dataProvider = "Bewakoof Data")
	
	public void loginIntoBewakoof(String id,String pass)
	{
		lo = PageFactory.initElements(driver, LoginObject.class);
		
		lo.clickOnLoginLink();
		
		Assert.assertEquals(lo.verifyBeforeLogin(),"Log In","User Not At Login Page");
		
		lo.setEmailId(id);
		   
		lo.submitLogin();
		
		try
		  {
			 Thread.sleep(1000);
		    }
		catch(Exception e3) 
		  {
			  System.out.println(e3);
			}
		   
		Boolean v1 = driver.getPageSource().contains("Password");
		   
		   if(v1==true)
		   {
			   lo.setPassword(pass);
			   
			   lo.submitLogin();
			   
			   try
				  {
					 Thread.sleep(1000);
				    }
				catch(Exception e2) 
				  {
					  System.out.println(e2);
					}
			   
			   Boolean v2 = driver.getPageSource().contains("Log In");
				
			   if(v2==true)
			   {
				    driver.navigate().refresh();
					
					Assert.assertTrue(false," Test Failed Because Password is not Matched(Invalid Password");
			   }
			   else
			   {
				   lo.goToDropdown();
					
				   Assert.assertTrue(lo.verifyAfterLogin().contains("Hi, "),"Invalid Credentials");
					
				   System.out.println(" Given User Logged In Sucessfully ");
			   }
		   }
		   else
		   {
			   driver.navigate().refresh();
				
			   Assert.assertTrue(false," Test Failed Because Email is not Correct(Invalid Email Id");
		   }
		
		log = PageFactory.initElements(driver, LogoutObject.class);
		
		log.logout();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e1) 
		{
			System.out.println(e1);
		}
		
		if(log.verifyAfterLogout().contains("Login"))
		{
			Assert.assertTrue(true);
			
			System.out.println("================User Logout Successfully===============");
		}
		else
		{
			Assert.assertTrue(false," User is still on login page, Please Logout ");
		}
		
	  }
				
}
