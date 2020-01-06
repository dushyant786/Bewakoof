package com.bewkoof.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bewkoof.pageObjects.LoginObject;
import com.bewkoof.pageObjects.LogoutObject;

/**
 * @author Dushyant
 */

public class TC_LoginTest_001 extends BaseRoom {
	
	LoginObject li;
	
	LogoutObject log;
	
	
	@Test(priority=0)
	
	public void loginIntoBewakoof()
	{
		li = PageFactory.initElements(driver, LoginObject.class); 
		
		li.clickOnLoginLink();
		logger.info("Click on login link for entering login details");
		
		Assert.assertEquals(li.verifyBeforeLogin(),"Log In"," User can't fill details because Invalid page");
		
		li.setEmailId("dushyantshekhawat87@gmail.com");
		logger.info("Entered user credential ");
		
		li.submitLogin();
		logger.info("Submit/hit on login button");
		
		li.setPassword("Milkyway@9206@");
		
		li.submitLogin();
		
		try
		{
			Thread.sleep(1000);
			logger.info("Wait for 1 sec after logged in");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		li.goToDropdown();
		logger.info("Click on dropdown menu for assertions after login");
		
		Assert.assertEquals(li.verifyAfterLogin(),"Hi, Dushyant"," User Not logged In--Invalid Credential");
		
		System.out.println("================Welcome! You Logged In===============");
	}
	
	@Test(priority=1,dependsOnMethods = "loginIntoBewakoof")
			
	public void logoutFromApplication()
	{
		li = PageFactory.initElements(driver, LoginObject.class);
		
		li.goToDropdown();
		logger.info("Again click on dropdown menu for logout");
		
		log = PageFactory.initElements(driver, LogoutObject.class);
		
		log.logout();
		logger.info("Logout from Bewakoof Application");
		
		try
		{
			Thread.sleep(1000);
			logger.info("Wait for 1 sec after logout");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		Assert.assertEquals(log.verifyAfterLogout(),"Login"," User is Still Logged In Please Logout ");
		
		System.out.println("================User Logout Successfully===============");
	}
	
	

}
