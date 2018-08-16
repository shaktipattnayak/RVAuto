package com.raptor.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.FacultyReportsPage;
import com.raptor.pages.HomePage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FacultyReportsTest.
 */
public class FacultyReportsTest extends TestBase{
	
	/** The Expected text. */
	public String ExpectedText ="Faculty Sign in by Date";
	
	
	/**
	 * Faculty sign in by date report test.
	 */
	@Test(priority=1,enabled=true, groups = {"smoke"})
	public void FacultySignInByDateReportTest(){
					
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	FacultyReportsPage facultyreorts = home.gotoFacultyRepotrs();
	waitForPageToLoad();
		try{
		Assert.assertEquals(facultyreorts.getFacultyReportPageAssertText(), ExpectedText);
		System.out.println("In Search Student page"+facultyreorts.getFacultyReportPageAssertText());
		}catch(Throwable e){
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "FacultyReportPage");
		}
		facultyreorts.getFacultySignInByDate_Report();
	}
}
