package com.bewkoof.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bewkoof.pageObjects.HomeObject;
import com.bewkoof.pageObjects.LoginObject;
import com.bewkoof.pageObjects.LogoutObject;
import com.bewkoof.pageObjects.ProductCartObject;
import com.bewkoof.pageObjects.SearchObject;

/**
 * @author Dushyant
 */

public class TC_ProductCartTest_002 extends BaseRoom{
	
    LoginObject li;
    
    SearchObject so;
    
    ProductCartObject pco;

	LogoutObject log;
	
	HomeObject ho;
	
	
	@Test(priority=0)
	
	public void loginIntoBewakoof()
	{
		li = PageFactory.initElements(driver, LoginObject.class); 
		
		li.clickOnLoginLink();
		logger.info("Click on login link for entering login details");
		
		Assert.assertEquals(li.verifyBeforeLogin(),"Log In"," User can't fill details because Invalid page");
		
		li.setEmailId("dushyantshekhawat87@gmail.com");
		logger.info("User Entered Email ");
		
		li.submitLogin();
		logger.info("Submit/hit on login button");
		
		li.setPassword("Milkyway@9206@");
		logger.info("User Entered Password ");
		
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
	
		System.out.println("================Welcome! You Logged In===============");
	}
	
    @Test(priority=1)
	
	public void searchProduct()
	{
		so = PageFactory.initElements(driver, SearchObject.class); 
		
		so.searchProductByText("mobile cover");
		
		Assert.assertTrue(so.verifyAfterSearched().contains("Search Results For :"),"Product Searched Failed");
		
		System.out.println("================Product Searched Sucessfully===============");
		
	 }
    
    @Test(priority=2)
	
   	public void productAddToCart()
   	{
   		pco = PageFactory.initElements(driver, ProductCartObject.class); 
   		
   		pco.clickOnProduct();
   		
   		pco.setPincode("302012");
   		
   		if(pco.checkAvailability().contains("Expected delivery:"))
   		{
   			Assert.assertTrue(true);
   			
            System.out.println("Product is Available");
   			
   			pco.addToCart();
   		}
   		else
   		{
   			Assert.assertTrue(false,"Currently Product is not Available at your location");
   		}
   		
   		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e1) 
		{
			System.out.println(e1);
		}
   		
   		pco.viewCart();
   		
   		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
   		
   		Assert.assertEquals(pco.verifyProductInCart(),"My Bag","User is not at Cart Page");
   		
   		System.out.println("================Product Added To Cart Sucessfully===============");
   	  }
		
    @Test(priority=3)
	
	public void goToHome()
	{
		ho = PageFactory.initElements(driver, HomeObject.class);
		
		ho.goTOHomePage();
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("Online Fashion Shopping for Men, Women, Accessories - Bewakoof.com"))
		{	
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false,"User Not At Home Page--Invalid Page");
		}
		
		System.out.println("================Sucessfully Back To HomePage===============");
	}
    
	
	@Test(priority=4,dependsOnMethods = "loginIntoBewakoof")
			
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
		
		System.out.println("================User Logout Sucessfully===============");
	}

}
