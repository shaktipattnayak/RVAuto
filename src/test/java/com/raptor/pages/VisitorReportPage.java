package com.raptor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;

public class VisitorReportPage extends TestBase{
	@FindBy(xpath="//*[@id='ctl01_MainContent_panMenu_nbReports_GHC1']/span")
	WebElement VisitorReportList;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_panMenu_nbReports_ITTC1i5_ctl00_btnText']/span")
	WebElement WhoIsInTheBuilding;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_ReportCriteria_ddlBuilding_I']")
	WebElement SelectBuildingDropdown;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_bntRefresh_CD")
	WebElement Submit_WhoIsInBuilding;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_panMenu_nbReports_ITTC1i1_ctl00_btnText']/span")
	WebElement SexOffenderLoged;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_txtStartDate_I")
	WebElement Sex_Offender_Logged_StartDate;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_txtEndDate_I")
	WebElement Sex_Offender_Logged_EndDate;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlSortBy_I")
	WebElement Sex_Offender_Logged_SortBy;
	
	@FindBy(id="ctl01_MainContent_ReportCriteria_bntRefresh_CD")
	WebElement Sex_Offender_Logged_Submit_Btn;
	
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC0i0_ctl00_btnText']/span")
	public WebElement AssertText_visitorreport;
	
	public void Report_WhoIsInBuilding() throws InterruptedException{

		Actions act = new Actions(driver);
		WhoIsInTheBuilding.click();
		act.doubleClick(VisitorReportList);
		Submit_WhoIsInBuilding.click();
		Thread.sleep(2000);
	}
	
		public void Report_SexOffenderLoged(String StartDate,String EndDate,String SortBy) throws InterruptedException{

		Actions act = new Actions(driver);
		SexOffenderLoged.click();
		act.doubleClick(VisitorReportList);
		Sex_Offender_Logged_StartDate.clear();
		Sex_Offender_Logged_StartDate.sendKeys(StartDate);
		Sex_Offender_Logged_EndDate.clear();
		Sex_Offender_Logged_EndDate.sendKeys(EndDate);
		//Sex_Offender_Logged_SortBy.clear();
		Sex_Offender_Logged_SortBy.sendKeys(SortBy);
		Sex_Offender_Logged_Submit_Btn.click();
		Thread.sleep(2000);
	}
	
	public String getVisitorReportPageAssertText(){
		String ActualText=AssertText_visitorreport.getText();
		return ActualText;
	}
}
