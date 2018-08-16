package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentReportPage.
 */
public class StudentReportPage extends TestBase {

	/** The driver. */
	public WebDriver driver;
	
	/** The Active student. */
	@FindBy(id="ctl01_MainContent_panMenu_nbReports_ITTC1i0_ctl00_btnText")
	WebElement ActiveStudent;
	
	/** The Building_ active student report. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlBuilding_I")
	WebElement Building_ActiveStudentReport;
	
	/** The Sort by_ active student report. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlSortBy_B-1Img")
	WebElement SortBy_ActiveStudentReport;
	
	/** The Sort by first name_ active student report. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlSortBy_DDD_L_LBI1T0")
	WebElement SortByFirstName_ActiveStudentReport;
	
	/** The Sort direction_ active student report. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlSortDirection_B-1Img")
	WebElement SortDirection_ActiveStudentReport;
	
	/** The Sort direction descending_ active student report. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_ddlSortDirection_DDD_L_LBI1T0")
	WebElement SortDirectionDescending_ActiveStudentReport;
	
	/** The Submit btn_ active student report. */
	@FindBy(id="ctl01_MainContent_ReportCriteria_bntRefresh_CD")
	WebElement SubmitBtn_ActiveStudentReport;
	
	/** The Assert text_studentreport. */
	@FindBy(xpath="//a[@id='ctl01_MainContent_panMenu_nbReports_ITTC0i0_ctl00_btnText']/span")
	WebElement AssertText_studentreport;
	
	
	
	/**
	 * Instantiates a new student report page.
	 *
	 * @param dr the dr
	 */
	public StudentReportPage(WebDriver dr){
		driver=dr;
	}
	
	/**
	 * Gets the avtive student report.
	 *
	 * @return the avtive student report
	 */
	public void getAvtiveStudentReport(){
		ActiveStudent.click();
		waitForPageToLoad();
		//Building_ActiveStudentReport.sendKeys(Building_Name);
		SortBy_ActiveStudentReport.click();
		SortByFirstName_ActiveStudentReport.click();
		SortDirection_ActiveStudentReport.click();
		SortDirectionDescending_ActiveStudentReport.click();
		SubmitBtn_ActiveStudentReport.click();
		TestUtil.delay(5000);
	}
	
	/**
	 * Gets the student report page assert text.
	 *
	 * @return the student report page assert text
	 */
	public String getStudentReportPageAssertText(){
		String ActualText=AssertText_studentreport.getText();
		return ActualText;
	}
}
