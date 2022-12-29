package com.retirement.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.retirement.dataProvider.ConfigDataProvider;
import com.retirement.dataProvider.ExcelDataProvider;
import com.retirement.utility.BrowserFactory;
import com.retirement.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File("./Reports/Retirement_Calculator"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());

	}
	
//	@AfterClass
//	public void tearDown() {
//		BrowserFactory.quitBrowser(driver);

//	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build()); 
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build()); 

		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build()); 

		}
		
		
		report.flush();
	}
	}


