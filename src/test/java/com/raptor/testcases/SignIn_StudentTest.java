package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SignInStudentPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SignIn_StudentTest extends TestBase {
	public String ExpectedText="Student Information";
	public String ExpectedDelayedEntryPageText="Sign In Date";
	@DataProvider
	public Object[][] getSignInStudentData(){
		return TestUtil.getData("signInStudentManually","Test Data", xls);		
		}
	
	@Test(dataProvider="getSignInStudentData",enabled=true, groups = {"smoke"})
	public void signInStudentManuallyTest(Hashtable<String,String> data){
		if(!TestUtil.isExecuatable("signInStudentManually", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the test");
		}
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		waitForPageToLoad();
		SignInStudentPage SIS = home.gotoSignInStudent();
		try{
			waitForPageToLoad();
			Assert.assertEquals(SIS.getSignInStudentPageAssertText(), ExpectedText);
			System.out.println(SIS.getSignInStudentPageAssertText()+" Assert Text");
			}catch(Throwable e){
				System.out.println("The Student Information text not Found");
				ErrorUtil.addVerificationFailure(e);
				TestUtil.captureScreenShot(driver, "StudentSignInPage");
			}
		Application_Logs.debug("In Sign In Student Page");
		SIS.SignIn_Student_Manually(data.get("FirstName"), data.get("LastName"),data.get("IDNumber"), data.get("Reason"));
	}
	
	@DataProvider
	public Object[][] getSignInStudentDataForQuickFind(){
		return TestUtil.getData("signInStudentByQuickFindTest","Test Data", xls);		
		}
	
	@Test(dataProvider="getSignInStudentDataForQuickFind",enabled=true, groups = {"smoke"})
	public void signInStudentByQuickFindTest(Hashtable<String,String> data) throws InterruptedException{
		if(!TestUtil.isExecuatable("signInStudentByQuickFindTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the test");
		}
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		waitForPageToLoad();
		SignInStudentPage SIS = home.gotoSignInStudent();
		Application_Logs.debug("In Sign In Student Page");
		SIS.SignInStudentByQuickFind(data.get("FirstName"),data.get("Reason"));
	}
	
	
	@DataProvider
	public Object[][] getstudentDelayedEntryData(){
		return TestUtil.getData("studentDelayedEntryManuallyTest","Test Data", xls);		
		}
	
	@Test(dataProvider="getstudentDelayedEntryData",enabled=true)
	public void studentDelayedEntryManuallyTest(Hashtable<String,String> data){
		if(!TestUtil.isExecuatable("studentDelayedEntryManuallyTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the test");
		}
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		waitForPageToLoad();
		SignInStudentPage SIS = home.gotoSignInStudent();
		waitForPageToLoad();
		Application_Logs.debug("In Sign In Student Page");
		SIS.studentDelayedEntryManually
				(data.get("FirstName"), 
				data.get("LastName"),
				data.get("IDNumber"), 
				data.get("Reason"), 
				data.get("SignInDate"),
				data.get("SignInTime"));
	}
}
