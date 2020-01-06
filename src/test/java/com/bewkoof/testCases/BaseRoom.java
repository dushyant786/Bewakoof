/**
 * 
 */
package com.bewkoof.testCases;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.bewkoof.utilities.ReadDataFromExcelFile;

/**
 * @author Dushyant
 */

public class BaseRoom {
	
	public static WebDriver driver;
	
	public String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	
	public String firefoxPath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
	
	public String iePath = System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe";
	
	public static Logger logger;
	

	public void chromeInitialization()
	{
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(opt);
	}
	
	public void firefoxInitialization()
	{
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		
		FirefoxOptions opt = new FirefoxOptions();
		
		opt.addPreference("dom.webnotifications.enabled", false);
		
		driver = new FirefoxDriver(opt);
	 }
	
	public void ieInitialization()
	{
		System.setProperty("webdriver.ie.driver", iePath);
		
		InternetExplorerOptions opt = new InternetExplorerOptions();
		
		driver = new InternetExplorerDriver(opt);
	 }
	
@BeforeClass(description = "Launch Browser")
	
	@Parameters("MyBrowser")
	
	public void launchBrowser(String MyBrowser) 
	{
        logger = Logger.getLogger("MavenTesting");	
        
        PropertyConfigurator.configure("log4j.properties");
	  
	   if(MyBrowser.equalsIgnoreCase("Chrome"))   
	   {
		  chromeInitialization();
		  logger.info("Chrome is launched");
		
          driver.manage().window().maximize();
          logger.info("Chrome is maximized");
		
		  System.out.println("============"+MyBrowser+" Browser Launched============");
		  
		  driver.get("https://www.bewakoof.com/");
		  logger.info("Opened given URL");
			
		  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			
		  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			
		  System.out.println("=========== Bewakoof is Started==========");  
	    }
	else if(MyBrowser.equalsIgnoreCase("Firefox"))
	     {
		    firefoxInitialization();
		    
		    System.out.println("============"+MyBrowser+" Browser Launched============");
		    
		    driver.get("https://www.bewakoof.com/");
			
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			
			System.out.println("=========== Bewakoof is Started==========");	
		 }
	else if(MyBrowser.equalsIgnoreCase("IE"))
    {
	    ieInitialization();
	    
	    System.out.println("============"+MyBrowser+" Browser Launched============");
	    
	    driver.get("https://www.bewakoof.com/");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		System.out.println("=========== Bewakoof is Started==========");
	  }
	  else
	    {
		    try
		    {
				throw new Exception("Please Provide Valid Supported Browser");
			}
		    catch (Exception e) 
		    {
				System.out.println(e);
	        }
	     }
	}  
	
	@AfterClass(description = "Close Browser")
	
	@Parameters("MyBrowser")
	
	public void closeBrowser(String MyBrowser)
	{
		driver.quit();
		
		System.out.println("============"+MyBrowser+" Closed============");
	 }
	
	public void getScreenshot(String methodName)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  // Time Stamp
		
		try
		{
		TakesScreenshot sh = (TakesScreenshot)driver;
		
		File src = sh.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./Screenshots/"+methodName+"-"+timestamp+".png"));
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("=====Screenshot is Taken=====");
	}
	
	 @DataProvider(name="Bewakoof Data")
	 
	 public Object[][] loginData(Method m) 
	 {
		 ReadDataFromExcelFile ex = new ReadDataFromExcelFile("C:\\Users\\hp\\workspace\\MavenTesting\\TestData\\BewakoofData.xlsx");
		 
		 Object[][] data = null;
		 
		if(m.getName().equalsIgnoreCase("loginIntoBewakoof"))
		{
		 
		int Row = ex.getRowCount(0);
		
		int Col = ex.getColumnCount(0);
		
		data = new Object[Row][Col];
		
		for(int i=1;i<=Row;i++)
		 {
			for(int j=0;j<Col;j++)
			{
				data[i-1][j] = ex.getData(0, i, j);
			 }
		   }
		
		 }
		else if(m.getName().equalsIgnoreCase("createAccountOnBewakoof"))
		{
		 
		int Row = ex.getRowCount(1);
		
		int Col = ex.getColumnCount(1);
		
		data = new Object[Row][Col];
		
		for(int i=1;i<=Row;i++)
		 {
			for(int j=0;j<Col;j++)
			{
				data[i-1][j] = ex.getData(1, i, j);
			 }
		   }
		
		 }
		 
		 return data;
		 
	 }
}
