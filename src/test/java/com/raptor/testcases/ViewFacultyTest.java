package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.ViewFacultyPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class ViewFacultyTest extends TestBase{
	String ExpectedText="First Name";

	@DataProvider
	public Object[][] getsignOutFacultyData(){
	return TestUtil.getData("signOutFacultyTest","Test Data", xls);		
	}
	
	@Test(dataProvider="getsignOutFacultyData",priority=2,enabled=true, groups = {"smoke"})
	public void signOutFacultyTest(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("signOutFacultyTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Sign Out Faculty Test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	waitForPageToLoad();
	ViewFacultyPage viewfaculty = home.gotoViewFaculty();
	try{
		waitForPageToLoad();
		Assert.assertEquals(viewfaculty.getViewFacultyPageAssertText(), ExpectedText);
		System.out.println("In View Faculty page "+viewfaculty.getViewFacultyPageAssertText());
		Application_Logs.debug("In View Faculty page "+viewfaculty.getViewFacultyPageAssertText());
		}catch(Throwable e){
			
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "ViewFacultyPage");
		}
	viewfaculty.signOutFaculty(data.get("SignOutReason"));
	waitForPageToLoad();
	
	//viewfaculty.signOutAllFaculty();
	}
	
	@Test(priority=1,enabled=true, groups = {"smoke"})
	public void refreshViewVisitorPage(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ViewFacultyPage viewfaculty = home.gotoViewFaculty();
		viewfaculty.refreshViewFacultyPage();
	}
}
