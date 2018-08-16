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
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class VisitorReportTest extends TestBase{
	public String ExpectedText="Visitor Sign in By Building";
	
	@Test(priority=1, groups = {"smoke"})
	public void Report_WhoIsInTheBuilding_Visitor() throws InterruptedException{
	if(!TestUtil.isExecuatable("Report_WhoIsInTheBuilding_Visitor", xls)){
			throw new SkipException("Skipping the Visitor_WhoIsInTheBuilding test");
	}
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	waitForPageToLoad();
	VisitorReportPage whoisinreports = home.gotoVisitorReports();
	try{
		waitForPageToLoad();
		Assert.assertEquals(whoisinreports.getVisitorReportPageAssertText(), ExpectedText);
		System.out.println(whoisinreports.getVisitorReportPageAssertText());
		}catch(Throwable e){
			System.out.println("The Visitor Sign in By Building text not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "VisitorReportPage");
		}
	
	whoisinreports.Report_WhoIsInBuilding();
	}

	//@Test(priority=2)
	@Test(dataProvider="getReport_SexOffenderLogedData",priority=2, groups = {"smoke"})
	public void Report_SexOffenderLogged_Visitor(Hashtable<String,String> data) throws InterruptedException{
		if(!TestUtil.isExecuatable("Report_SexOffenderLogged_Visitor", xls)){
			throw new SkipException("Skipping the Sex Offender Logged test");
		}
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		VisitorReportPage sexoffenderlogged = home.gotoVisitorReports();
		//sexoffenderlogged.Report_SexOffenderLoged();
		sexoffenderlogged.Report_SexOffenderLoged(data.get("StartDate"), data.get("EndDate"), data.get("SortBy"));
	}
	
	@DataProvider
	public Object[][] getReport_SexOffenderLogedData(){
		return TestUtil.getData("Report_SexOffenderLogged_Visitor","Test Data", xls);		
		}
}