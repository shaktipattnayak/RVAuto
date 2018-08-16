package com.raptor.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.StudentReportPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class StudentReportTest extends TestBase{
	public String ExpectedText ="Student Sign in by Date";

	@Test(priority=1,groups = {"smoke"})
	public void getAvtiveStudentReportTest() throws InterruptedException{	
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		waitForPageToLoad();
		StudentReportPage studentreport = home.gotoStudentReports();
		try{
			waitForPageToLoad();
			Assert.assertEquals(studentreport.getStudentReportPageAssertText(), ExpectedText);
			System.out.println("Assertion text "+ studentreport.getStudentReportPageAssertText());
			}catch(Throwable e){
				ErrorUtil.addVerificationFailure(e);
				TestUtil.captureScreenShot(driver, "StudentReportPage");
			}
		studentreport.getAvtiveStudentReport();
	}
}
