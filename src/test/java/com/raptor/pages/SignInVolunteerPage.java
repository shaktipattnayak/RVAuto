package com.raptor.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class SignInVolunteerPage extends TestBase{
	
	public WebDriver driver;
	boolean QuickFindModalPopup=false;
	boolean FirstSuggestedVolunteer=false;
	
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td")
	public WebElement AssertText_volunteersigninpage;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font[1]/b")
	public WebElement QuickFindDialogBox;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/img")
	public WebElement QuickFindDialogBoxCloseIcon;
	
	@FindBy(xpath="//div[@id='divScroll']/table/tbody/tr[2]/td[1]")
	public WebElement FirstSuggVol;
	
	@FindBy(id="ctl01_MainContent_txtQuickFind")
	public WebElement QuickFindTextBox;
	
	@FindBy(id="ctl01_MainContent_BtnFind")
	public WebElement QuickFindBtn;
	
	@FindBy(id="ctl01_MainContent_tlcVolunteer_functionid")
	public WebElement FunctionDropdown;
	
	@FindBy(id="ctl01_MainContent_tlcVolunteer_affiliationid")
	public WebElement AffiliationDropdown;
	
	@FindBy(id="ctl01_MainContent_tlcVolunteer_organizationid")
	public WebElement OrganizationDropdown;
	
	@FindBy(id="ctl01_MainContent_btnSubmit")
	public WebElement volunteerSubmitbtn;
	
	@FindBy(id="ctl01_MainContent_btnDelayedEntry")
	public WebElement Volunteer_DelayedEntryBtn;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_delaydatein")
	public WebElement Volunteer_SignInDate;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_delaytimein")
	public WebElement Volunteer_SignInTime;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_delaydateout")
	public WebElement Volunteer_SignOutDate;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_delaytimeout")
	public WebElement Volunteer_SignOutTime;
	
	public SignInVolunteerPage(WebDriver dr){
		driver=dr;
	}	
	public void signInVolunteer(String volunteer_name, String function, String affilation, String organization){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(4000);
		QuickFindTextBox.clear();
		QuickFindTextBox.sendKeys(volunteer_name);
		QuickFindBtn.click();
		TestUtil.delay(2000);
		
		QuickFindModalPopup = QuickFindDialogBox.isDisplayed();
		if(QuickFindModalPopup==true){
			TestUtil.delay(2000);
			FirstSuggestedVolunteer=FirstSuggVol.isDisplayed();
			if(QuickFindModalPopup==true){
				FirstSuggVol.click();
				TestUtil.delay(1000);
				TestUtil.selectOptionByVisibleText(FunctionDropdown, function);
				TestUtil.delay(1000);
				TestUtil.selectOptionByVisibleText(AffiliationDropdown, affilation);
				TestUtil.delay(1000);
				TestUtil.selectOptionByVisibleText(OrganizationDropdown, organization);
				volunteerSubmitbtn.click();
				System.out.println("Volunteer Sign In Successfully");
			}
			else{
				QuickFindDialogBoxCloseIcon.click();
			}
		}
		else{
		TestUtil.delay(1000);
		TestUtil.selectOptionByVisibleText(FunctionDropdown, function);
		TestUtil.delay(1000);
		TestUtil.selectOptionByVisibleText(AffiliationDropdown, affilation);
		TestUtil.delay(1000);
		TestUtil.selectOptionByVisibleText(OrganizationDropdown, organization);
		volunteerSubmitbtn.click();
		}
	}
	
	
	public void volunteerDelayedEntry(
			String volunteer_name, 
			String SignInDate, 
			String SignIntime,
			String SignOutDate,
			String SignOutTime,
			String function, 
			String affilation, 
			String organization){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(2000);
		Volunteer_DelayedEntryBtn.click();
		waitForPageToLoad();
		TestUtil.delay(4000);
		QuickFindTextBox.clear();
		QuickFindTextBox.sendKeys(volunteer_name);
		QuickFindBtn.click();
		TestUtil.delay(2000);
		Volunteer_SignInDate.clear();
		Volunteer_SignInDate.sendKeys(SignInDate);
		TestUtil.delay(2000);
		//((JavascriptExecutor)driver).executeScript("$('#ctl01_MainContent_flcVolunteer_delaytimein').unmask()");InputStd
		//Volunteer_SignInTime.click();
		//Volunteer_SignInTime.clic
		//((JavascriptExecutor) driver).executeScript("$('#date').mask('hh:mm')");
		((JavascriptExecutor)driver).executeScript("$('#ctl01_MainContent_flcVolunteer_delaytimein').removeClass()");
		Volunteer_SignOutDate.clear();
		Volunteer_SignOutDate.sendKeys(SignOutDate);
		TestUtil.delay(1000);
		Volunteer_SignOutTime.sendKeys(SignOutTime);
		TestUtil.delay(2000);
		TestUtil.selectOptionByVisibleText(FunctionDropdown, function);
		TestUtil.delay(1000);
		TestUtil.selectOptionByVisibleText(AffiliationDropdown, affilation);
		TestUtil.delay(1000);
		TestUtil.selectOptionByVisibleText(OrganizationDropdown, organization);
		TestUtil.delay(1000);
		volunteerSubmitbtn.click();
		Volunteer_SignOutTime.sendKeys(SignOutTime);
	}
	
	
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
	public String getSignInVolunteerPageAssertText(){
		String ActualText=AssertText_volunteersigninpage.getText();
		return ActualText;
	}
	
}



