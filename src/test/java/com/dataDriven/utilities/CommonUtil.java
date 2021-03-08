package com.dataDriven.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dataDriven.base.TestBase;

public class CommonUtil extends TestBase{

	public static String screenshotFileName;
	
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException err) {
			return false;
		}
	}
	
	public static void captureScreenshot() throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotFileName = "Screenshot_"+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println("Screenshot file name: "+screenshotFileName);
		// Don't need to create folder and file
		File DestFile = new File(System.getProperty("user.dir")+"/target/surefire-reports/html/Screenshots/"+screenshotFileName);
		
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
