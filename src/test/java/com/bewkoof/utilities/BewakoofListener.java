package com.bewkoof.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bewkoof.testCases.BaseRoom;

/**
 * @author Dushyant
 */

public class BewakoofListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) 
	{
        System.out.println("");
		
		System.out.println(" "+result.getName()+" method is Starting ");	
	 }

	@Override
	public void onTestSuccess(ITestResult result) 
	{
        System.out.println("");
		
		System.out.println(" "+result.getName()+" method is Passed or Success. ");	
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
        System.out.println("");
		
		System.out.println(" "+result.getName()+" method is Failed ");	
		
		BaseRoom screen = new BaseRoom();
		
		screen.getScreenshot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
        System.out.println("");
		
		System.out.println(" "+result.getName()+" method is Skipped ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
        System.out.println("");
		
		System.out.println(" "+result.getName()+" method is Failed but withiin success % ");	
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
        System.out.println("");
		
		System.out.println("");
		
		System.out.println(" "+context.getName()+" Test is Finished ");	
	}
	
}
