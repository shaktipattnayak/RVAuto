package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FacultyReportsPage.
 */
public class FacultyReportsPage extends TestBase {

	/** The driver. */
	public WebDriver driver;
	
	/** The Assert text_faculyreports. */
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC0i0_ctl00_btnText']/span")
	WebElement AssertText_faculyreports;
	
	/** The Report_ faculty sign in by date. */
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC0i0_ctl00_btnText']/span")
	WebElement Report_FacultySignInByDate;
	
	/** The Preset dropdown icon. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlPreset_B-1Img")
	WebElement PresetDropdownIcon;
	
	/** The Preset dropdown value_ this month. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlPreset_DDD_L_LBI4T0")
	WebElement PresetDropdownValue_ThisMonth;
	
	/** The Faculty sign in by date btn. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_bntRefresh_CD")
	WebElement FacultySignInByDateBtn;
	
	/**
	 * Instantiates a new faculty reports page.
	 *
	 * @param dr the dr
	 */
	public FacultyReportsPage(WebDriver dr){
		driver=dr;
	}
	
	/**
	 * Gets the faculty sign in by date_ report.
	 *
	 * @return the faculty sign in by date_ report
	 */
	public void getFacultySignInByDate_Report(){
		Report_FacultySignInByDate.click();
		waitForPageToLoad();
		TestUtil.delay(2000);
		PresetDropdownIcon.click();
		PresetDropdownValue_ThisMonth.click();
		waitForPageToLoad();
		TestUtil.delay(2000);
		FacultySignInByDateBtn.click();
		TestUtil.delay(2000);
	}
	
	/**
	 * Gets the faculty report page assert text.
	 *
	 * @return the faculty report page assert text
	 */
	public String getFacultyReportPageAssertText(){
		String ActualText=AssertText_faculyreports.getText();
		return ActualText;
	}
}
