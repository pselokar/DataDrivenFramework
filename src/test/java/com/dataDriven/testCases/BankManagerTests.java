package com.dataDriven.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import com.dataDriven.base.TestBase;
import com.dataDriven.utilities.CommonUtil;

public class BankManagerTests extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException {
		log.debug("Login as bank manager and validating Add customer button");
		
		driver.findElement(By.cssSelector(OR.getProperty("bankManagerLoginBtnCss"))).click();
		Assert.assertTrue(CommonUtil.isElementPresent(By.cssSelector(OR.getProperty("addCustomerBtnCss"))), "Element is not found..");
	}
	
	@Test
	public void loginAsBankManager1() throws InterruptedException {
		log.debug("Login as bank manager and validating Add customer button");
		Thread.sleep(5000);
		Assert.fail("Failing forecfully");
	}
	
	@Test
	public void loginAsBankManager2() throws InterruptedException {
		log.debug("Login as bank manager and validating Add customer button");
		Thread.sleep(5000);
		Assert.fail("Failing forecfully");
	}
	
}
