package com.retirement.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.retirement.base.BaseClass;
import com.retirement.pageobjects.CalculatorPage;

public class TestCalculator extends BaseClass {

	@Test
	public void testCalculator() {
		
		logger = report.createTest("Fill Data in required field");
		CalculatorPage calculatorPage = PageFactory.initElements(driver, CalculatorPage.class);
		logger.info("Start to fill Data in required field");
		Double curAge = excel.getNumericData("Required_Data", 0, 1);
		Double retAge = excel.getNumericData("Required_Data", 1, 1);
		Double curIncome = excel.getNumericData("Required_Data", 2, 1);
		Double curTotSaving = excel.getNumericData("Required_Data", 4, 1);
		Double curAnnuSaving = excel.getNumericData("Required_Data", 5, 1);
		Double savIncrRate = excel.getNumericData("Required_Data", 6, 1);
		
		calculatorPage.fillRequiredData(curAge, retAge, curIncome, curTotSaving, curAnnuSaving, savIncrRate);
		
		logger.pass("Data filled sucessfully");
	}

	

}
