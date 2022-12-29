package com.retirement.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.retirement.base.BaseClass;
//import base.BaseClass;
import com.retirement.pageobjects.CalculatorPage;
import com.retirement.utility.Helper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestCalculator extends BaseClass {
	
	Helper helper;
	CalculatorPage calculatorPage;

	@BeforeClass
	public void setup() {
		helper = new Helper();
		calculatorPage = PageFactory.initElements(driver, CalculatorPage.class);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	@Test(enabled=false)
	public void testCalculator() throws InterruptedException {
		
		logger = report.createTest("Fill Data in required field");
		logger.info("Start to fill Data in required field");
		HashMap<String, Object> map = excel.getAllData("Required_Data");

		System.out.println("Current Age: " + String.valueOf(map.get("Relationship status")));
		/*calculatorPage.fillRequiredData(map.get("Current Age"), map.get("Retirement Age"),
				map.get("Current annual income"), map.get("Current retirement savings"),
				map.get("Current retirement contribution"), map.get("Annual retirement contribution increase"));*/
		calculatorPage.fillRequiredData(map.get(calculatorPage.Input_CA), map.get(calculatorPage.Input_RA)
				, map.get(calculatorPage.Input_CAI), map.get(calculatorPage.Input_CRS)
				, map.get(calculatorPage.Input_CRC), map.get(calculatorPage.Input_ARCI));
		logger.pass("Data filled sucessfully");
		TimeUnit.SECONDS.sleep(5);
	}

	@Test(enabled=false)
	public void test2() throws InterruptedException {
		
		driver.navigate().refresh();
		TimeUnit.SECONDS.sleep(5);
		logger = report.createTest("Fill Data in required field");
		logger.info("Start to fill Data in required field");
		
		calculatorPage.fillRequiredData("", "","","","","");
		logger.pass("Data filled sucessfully");
		TimeUnit.SECONDS.sleep(5);
		calculatorPage.verifyHeaderMeaasage();
	}
	@Test
	public void test3() throws InterruptedException {
		driver.navigate().refresh();
		TimeUnit.SECONDS.sleep(5);
		logger = report.createTest("Fill Data in required field");
		logger.info("Start to fill Data in required field");
		HashMap<String, Object> map = excel.getAllData("Required_Data");
		calculatorPage.fillRequiredData(map.get(calculatorPage.Input_CA), ""
				, map.get(calculatorPage.Input_CAI), map.get(calculatorPage.Input_CRS)
				, map.get(calculatorPage.Input_CRC), map.get(calculatorPage.Input_ARCI));
		logger.pass("Data filled sucessfully");
		TimeUnit.SECONDS.sleep(5);
		calculatorPage.verifyErrorMessages();

		
	}
	
	

}
