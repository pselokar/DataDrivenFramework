package com.dataDriven.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.dataDriven.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties CONFIG = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/com/dataDriven/excel/testData.xlsx");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setup() throws IOException {
		
		log.debug("Started the session.");
		if(driver == null) {
			BasicConfigurator.configure();
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/com/dataDriven/properties/Config.properties");
			CONFIG.load(fis);
			log.debug("Config properties loaded successfully");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/com/dataDriven/properties/ObjectRepo.properties");
			OR.load(fis);
			log.debug("Object repository properties loaded successfully");
			
			if(CONFIG.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("Launched Chrome browser");
			}
			else if(CONFIG.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.debug("Launched Firefox browser");
			}
		}
		
		driver.get(CONFIG.getProperty("baseUrl"));
		log.debug("Navigate to "+CONFIG.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			log.debug("Quitting the session.");
			driver.quit();
		}
	}
	
	
}
