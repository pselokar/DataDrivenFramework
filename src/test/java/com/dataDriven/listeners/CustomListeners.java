package com.dataDriven.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.dataDriven.utilities.CommonUtil;


public class CustomListeners implements ITestListener {
	public void onTestStart(ITestResult result) {  
		// TODO Auto-generated method stub
	}  
	  
	public void onTestSuccess(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Success of test cases and its details are : "+result.getName());  
	}  
	  
	public void onTestFailure(ITestResult result) {  
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			CommonUtil.captureScreenshot();
			// Create path for screenshot link
			String screenshotlink = "Screenshots/"+CommonUtil.screenshotFileName;
			Reporter.log("Test case failed; Capturing Screenshot..");
			Reporter.log("<a href= \""+screenshotlink+"\"  target=\"_blank\">Screenshot</a>");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}  
	  
	public void onTestSkipped(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	public void onStart(ITestContext context) {  
		// TODO Auto-generated method stub  
	}  
	  
	public void onFinish(ITestContext context) {  
		// TODO Auto-generated method stub  
	}
}
