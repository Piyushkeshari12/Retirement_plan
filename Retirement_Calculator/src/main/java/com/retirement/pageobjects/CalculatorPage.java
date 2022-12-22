package com.retirement.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage {
	WebDriver driver;

	public CalculatorPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "current-age")
	WebElement currentAge;
	@FindBy(id = "retirement-age")
	WebElement retirementAge;
	@FindBy(xpath = "//input[@id='current-income']")
	WebElement currentIncome;
	@FindBy(id = "spouse-income")
	WebElement spouseIncome;
	@FindBy(xpath = "//input[@id='current-total-savings']")
	WebElement currentTotalSavings;
	@FindBy(id = "current-annual-savings")
	WebElement currentAnnualSavings;
	@FindBy(xpath = "//input[@id='savings-increase-rate']")
	WebElement savingsIncreaseRate;
	@FindBy(id = "yes-social-benefits")
	WebElement yesSocialBenefits;
	@FindBy(id = "no-social-benefits")
	WebElement noSocialBenefits;
	@FindBy(xpath = "//button[text()='Calculate']")
	WebElement calculate;
	@FindBy(xpath = "(//button[text()='Clear form']")
	WebElement clearForm;
	@FindBy(id = "single")
	WebElement single;
	@FindBy(id = "married")
	WebElement married;
	@FindBy(id = "social-security-override")
	WebElement socialSecurityOverride;
	@FindBy(xpath = "//a[text()='Adjust default values']")
	WebElement adjustDefaultValues;
	@FindBy(id = "additional-income")
	WebElement additionalIncome;
	@FindBy(id = "retirement-duration")
	WebElement retirementDuration;
	@FindBy(id = "include-inflation")
	WebElement includeInflation;
	@FindBy(id = "exclude-inflation")
	WebElement excludeInflation;
	@FindBy(id = "retirement-annual-income")
	WebElement retirementAnnualIncome;
	@FindBy(id = "pre-retirement-roi")
	WebElement preRetirementRoi;
	@FindBy(id = "post-retirement-roi")
	WebElement postRetirementRoi;
	@FindBy(xpath = "//button[text()='Save changes']")
	WebElement saveChanges;
	@FindBy(xpath="//button[text()='Cancel']") WebElement cancel;

	public void fillRequiredData(Double curAge, Double retAge, Double curIncome, Double curTotalSavings, Double curAnnualSavings, Double savIncrRate) {
	
		
		
		currentAge.sendKeys(String.valueOf(curAge));
		retirementAge.sendKeys(String.valueOf(retAge));
		currentIncome.sendKeys(String.valueOf(curIncome));
		currentTotalSavings.sendKeys(String.valueOf(curTotalSavings));
		currentAnnualSavings.sendKeys(String.valueOf(curAnnualSavings));
		savingsIncreaseRate.sendKeys(String.valueOf(savIncrRate));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		calculate.click();
		
	}

	

	

	
	
	

	
}
