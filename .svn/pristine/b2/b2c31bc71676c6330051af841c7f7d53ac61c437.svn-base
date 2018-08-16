package com.raptor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class VolunteerReportsPage extends TestBase {
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC0i0_ctl00_btnText']/span")
	public WebElement Volunteer_SignInByDate;
	
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC0i0_ctl00_btnText']/span")
	public WebElement AssertText_volunteerreports;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_txtStartDate_I")
	public WebElement StartDate;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_txtEndDate_I")
	public WebElement EndDate;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_ReportCriteria_bntRefresh_CD']/span")
	public WebElement Submit;
	
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC1i20_ctl00_btnText']/span")
	public WebElement Volunteer_WhoIsInBuilding;
	
	public void getVolunteerSignInByDateReport(String StartDt, String EndDt){
		Volunteer_SignInByDate.click();
		StartDate.sendKeys(StartDt);
		EndDate.sendKeys(EndDt);
		Submit.click();
		TestUtil.delay(2000);
	}
	
	public void getVolunteerWhoIsInBuildingReport(){
		Volunteer_WhoIsInBuilding.click();
		Submit.click();
	}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
	public String getVolunteerReportsPageAssertText(){
		String ActualText=AssertText_volunteerreports.getText();
		return ActualText;
	}
}
