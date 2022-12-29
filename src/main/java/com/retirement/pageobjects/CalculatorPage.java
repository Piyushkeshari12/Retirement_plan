package com.retirement.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

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
	@FindBy(xpath="//button[text()='Cancel']") 
	WebElement cancel;
	@FindBy(xpath="//div[@class='dsg-alert-box-danger']/span/following-sibling::p[text()='Please fill out all required fields']") 
	WebElement errorPrompt;
	@FindBy(xpath="//input[@id='current-age']/following-sibling::span[text()='Input required']") 
	WebElement currentAgeError;	
	@FindBy(xpath="//input[@id='retirement-age']/following-sibling::span[text()='Input required']") 
	WebElement retAgeError;
	@FindBy(xpath="//input[@id='current-income']/following-sibling::span[text()='Input required']") 
	WebElement currentIncomeError;
	@FindBy(xpath="//input[@id='current-total-savings']/following-sibling::span[text()='Input required']") 
	WebElement currentTotSavError;
	@FindBy(xpath="//input[@id='current-annual-savings']/following-sibling::span[text()='Input required']") 
	WebElement currentAnnuSavError;
	@FindBy(xpath="//input[@id='savings-increase-rate']/following-sibling::span[text()='Input required']") 
	WebElement savingsIncrRateError;
		
	
	
	public final String Input_CA = "Current Age";
	public final String Input_RA = "Retirement Age";
	public final String Input_CAI = "Current annual income";
	public final String Input_SAI = "Spouse's annual income";
	public final String Input_CRS = "Current retirement savings ";
	public final String Input_CRC = "Current retirement contribution ";
	public final String Input_ARCI = "Annual retirement contribution increase";
	public final String Input_SSI = "Social Security Income";
	public final String Input_RS = "Relationship status";
	public final String Input_SSO = "Social Security Override";
	public final String Input_0I = "Additional/other income";
	public final String Input_NYRNL = "Number of years retirement needs to last";
	public final String Input_PRIII = "Post-retirement income increase with inflation";
	public final String Input_PFAID = "Percent of final annual income desired";
	public final String Input_PREIR = "Pre-retirement investment return";
	public final String Input_POSTIR = "Post-retirement investment return";
	public final String Input_Null = "";
	
	
	public void fillRequiredData(Object curAge, Object retAge, Object curIncome, Object curTotalSavings, Object curAnnualSavings, Object savIncrRate) throws InterruptedException {
		System.out.println("Current Age: " + curAge);
		currentAge.sendKeys(String.valueOf(curAge));
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("retAge: " + retAge);
		retirementAge.sendKeys(String.valueOf(retAge));
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("curIncome: " + curIncome);
		currentIncome.click();
		currentIncome.sendKeys(String.valueOf(curIncome));
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("curTotalSavings: " + curTotalSavings);
		currentTotalSavings.click();
		currentTotalSavings.sendKeys(String.valueOf(curTotalSavings));
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("curAnnualSavings: " + curAnnualSavings);
		currentAnnualSavings.click();
		currentAnnualSavings.sendKeys(String.valueOf(curAnnualSavings));
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("savIncrRate: " + savIncrRate);
		savingsIncreaseRate.sendKeys(String.valueOf(savIncrRate));
//		TimeUnit.SECONDS.sleep(5);
		calculate.click();
		
	}

	public void verifyHeaderMeaasage() {
		Assert.assertFalse(errorPrompt.isDisplayed(),"ErrorPrompt not found");
		Assert.assertTrue(errorPrompt!=null, "ErrorPrompt is null");
		
	}
	
	public void verifyErrorMessages() {
		if(Input_CA.equals(Input_Null)) {
			Assert.assertTrue(currentAgeError.isDisplayed(),"currentAgeError Message not displayed");
		}
		else if(Input_RA.equals(Input_Null)) {
			Assert.assertTrue(retAgeError.isDisplayed(),"retAgeError Message not displayed");
		}
		else if(Input_CAI.equals(Input_Null)) {
			Assert.assertTrue(currentIncomeError.isDisplayed(),"currentIncomeError Message not displayed");
		}
		else if(Input_CRS.equals(Input_Null)) {
			Assert.assertTrue(currentTotSavError.isDisplayed(),"currentTotSavError Message not displayed");
		}
		else if(Input_CRC.equals(Input_Null)) {
			Assert.assertTrue(currentAnnuSavError.isDisplayed(),"currentAnnuSavError Message not displayed");
		}
		else if(Input_ARCI.equals(Input_Null)) {
			Assert.assertTrue(savingsIncrRateError.isDisplayed(),"savingsIncrRateError Message not displayed");
		}

	}

	

	
	
	

	
}
