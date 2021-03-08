package com.dataDriven.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dataDriven.base.TestBase;
import com.dataDriven.utilities.CommonUtil;

public class AddCustomerTests extends TestBase{

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode) {
		log.debug("Add new customer: "+firstName+ " "+lastName);
		driver.findElement(By.cssSelector(OR.getProperty("addCustomerBtnCss"))).click();
		
		driver.findElement(By.cssSelector(OR.getProperty("firstNameFormInputCss"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastNameFormInputCss"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCodeFormInputCss"))).sendKeys(postCode);
		
		driver.findElement(By.cssSelector(OR.getProperty("formSubmitBtnCss"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Assert.assertTrue(CommonUtil.isElementPresent(By.cssSelector(OR.getProperty("addCustomerBtnCss"))), "Element is not found..");
	}
	
	@DataProvider
	public Object[][] getData(){
		log.debug("Get the data from dataprovider");
		
		String sheetName = "AddCustomerTests";
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum = 2; rowNum <= rows; rowNum++) {
			for(int colNum=0; colNum < cols; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
}
