package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SignOutStudentPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SignOutStudentTest extends TestBase{
	public String ExpectedText= "Parent/Guardian Information";
	
	@DataProvider
	public Object[][] getSignOutStudentData(){
		return TestUtil.getData("signOutStudentManually","Test Data", xls);		
		}
	
	@Test(dataProvider="getSignOutStudentData",enabled=true,groups = {"smoke"})
	public void signOutStudentManuallyTest(Hashtable<String,String> data){
		if(!TestUtil.isExecuatable("signOutStudentManually", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the test");
		}
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignOutStudentPage SOS = home.gotoSignOutStudent();
		try{
			waitForPageToLoad();
			Assert.assertEquals(SOS.getSignOutStudentPageAssertText(), ExpectedText);
			System.out.println(SOS.getSignOutStudentPageAssertText()+" Assert Text");
			}catch(Throwable e){
				System.out.println("The Student Information text not Found");
				ErrorUtil.addVerificationFailure(e);
				TestUtil.captureScreenShot(driver, "StudentSignOutPage");
			}
		Application_Logs.debug("In Sign Out Student Page");
		SOS.signOutStudentManually(
				data.get("Std_FirstName"), 
				data.get("Std_LastName"),
				data.get("Std_IDNumber"), 
				data.get("Std_Reason"),
				data.get("Par_FirstName"), 
				data.get("Par_LastName"),
				data.get("Par_DOB"), 
				data.get("Par_License"));
	}
	
}
