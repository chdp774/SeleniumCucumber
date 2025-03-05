package com.nestle.framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nestle.framework.Util.CommonFunctions;

public class M2FE_AccountCreation_Page extends CommonFunctions{
//	private WebDriver driver;
//	
	public M2FE_AccountCreation_Page(WebDriver driver) {
		super(driver);
		//jsDriver = (JavascriptExecutor)driver;
		//ngWebDriver = new NgWebDriver(jsDriver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		//ngWebDriver.waitForAngularRequestsToFinish();
	}
	
	public void accountCreation(String mail, String fName, String lName, String phone, String practition_DD, String license, String persnal_DD,
			String address1, String city, String state_DD, String zip, String referal_DD) {
		
		enter_text(mailID_txt, mail);
		enter_text(firstName_txt, fName);
		enter_text(lastName_txt, lName);
		enter_text(phone_txt, phone);
		DD_visiableText(practitioner_DD, practition_DD);
		enter_text(licenseNumber_txt, license);
		DD_visiableText(personalUse_DD, persnal_DD);
		enter_text(address1_txt, address1);
		enter_text(city_txt, city);
		DD_visiableText(state_txt, state_DD);
		enter_text(zip_txt, zip);
		DD_visiableText(referral_DD, referal_DD);
		waitFor(1);
		click(consent_btn);
		waitFor(1);
		click(tc_btn);
		waitFor(1);
		click(agree_btn);
		waitFor(1);
		click(applyNow_btn);
	}
	
	@FindBy(xpath = "//input[@name='Email']") 
	private WebElement mailID_txt;
	
	@FindBy(xpath = "//input[@name='First_Name']") 
	private WebElement firstName_txt;
	
	@FindBy(xpath = "//input[@name='Last_Name']") 
	private WebElement lastName_txt; 
	
	@FindBy(xpath = "//input[@name='Phone']")	
	private WebElement phone_txt;
	
	@FindBy(xpath = "//select[@name='Practitioner_Type']") 
	private WebElement practitioner_DD;
	
	@FindBy(xpath = "//input[@name='License_Number']")	
	private WebElement licenseNumber_txt;
	
	@FindBy(xpath = "//select[@name='Personal_Use']")	
	private WebElement personalUse_DD;
	
	@FindBy(xpath = "//input[@name='Street_Address_1']")
	private WebElement address1_txt;
	
	@FindBy(xpath = "//input[@name='City']")
	private WebElement city_txt;
	
	@FindBy(xpath = "//select[@name='State']")
	private WebElement state_txt;
	
	@FindBy(xpath = "//input[@name='Zip']")
	private WebElement zip_txt;
	
	@FindBy(xpath = "//select[@name='Referral_Code']")
	private WebElement referral_DD;
	
	@FindBy(xpath = "//input[@name='prac-acc-agree-tc']")
	private WebElement tc_btn;
	
	@FindBy(xpath = "//a[@id='iagree']")
	private WebElement agree_btn;
	
	@FindBy(xpath = "//button[contains(text(),'Consent')]")
	private WebElement consent_btn;
	
	@FindBy(xpath = "//input[@value='Apply Now']")
	private WebElement applyNow_btn;
}
