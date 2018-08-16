package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.VisitorReportPage;
import com.raptor.pages.VolunteerReportsPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class VolunteerReportsTest extends TestBase{
	public String ExpectedText="Volunteer Sign in by Date";
	
	@Test(priority=1, groups = {"smoke"})
	public void Report_WhoIsInTheBuilding_Volunteer() throws InterruptedException{
	
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	waitForPageToLoad();
	VolunteerReportsPage volunteerreports = home.gotoVolunteerReports();
	try{
		waitForPageToLoad();
		Assert.assertEquals(volunteerreports.getVolunteerReportsPageAssertText(), ExpectedText);
		System.out.println(volunteerreports.getVolunteerReportsPageAssertText());
		}catch(Throwable e){
			System.out.println("The assert text not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "VolunteerReportPage");
		}
	volunteerreports.getVolunteerWhoIsInBuildingReport();
	}
	
	
	@DataProvider
	public Object[][] getVolunteerSignInByDateReportData(){
		return TestUtil.getData("reportVolunteerSignInByDate","Test Data", xls);		
		}
	
	@Test(dataProvider="getVolunteerSignInByDateReportData",priority=2, groups = {"smoke"})
	public void VolunteerSignInByDateReport(Hashtable<String,String> data) throws InterruptedException{
		if(!TestUtil.isExecuatable("reportVolunteerSignInByDate", xls)){
			throw new SkipException("Skipping volunteer sign in by date test");
		}
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		VolunteerReportsPage volunteerreports = home.gotoVolunteerReports();
	
		volunteerreports.getVolunteerSignInByDateReport(data.get("StartDate"), data.get("EndDate"));
	}
	
	
}
