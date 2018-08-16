package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SignIn_FacultyPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SignInFacultyTest extends TestBase{
	String ExpectedText="Faculty Information";
	
	@DataProvider
	public Object[][] getsignInFacultyData(){
	return TestUtil.getData("signInFacultyTest","Test Data", xls);		
	}
	
	@Test(dataProvider="getsignInFacultyData",priority=1,enabled=true, groups = {"smoke"})
	public void signInFacultyTest(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("signInFacultyTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Sign In Faculty Test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SignIn_FacultyPage signinfaculty = home.gotoSignFaculty();
	try{
		waitForPageToLoad();
		Assert.assertEquals(signinfaculty.getSignInFacultyPageAssertText(), ExpectedText);
		System.out.println("In Sign In Faculty page "+signinfaculty.getSignInFacultyPageAssertText());
		}catch(Throwable e){
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "SignInFacultyPage");
		}
	signinfaculty.signInFaculty(data.get("FacultyID"));
	}
	
	
	
	@DataProvider
	public Object[][] getFacultyDelayedEntryData(){
	return TestUtil.getData("facultyDelayedEntryTest","Test Data", xls);		
	}
	
	@Test(dataProvider="getFacultyDelayedEntryData",priority=2,enabled=true)
	public void facultyDelayedEntryTest(Hashtable<String,String>data) throws InterruptedException{
		if(!TestUtil.isExecuatable("facultyDelayedEntryTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping Faculty Delayed Entry Test");
			}
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignIn_FacultyPage signinfaculty = home.gotoSignFaculty();
		waitForPageToLoad();
		signinfaculty.facultyDelayedEntry(
				data.get("FacultyID"), 
				data.get("SignInDate"), 
				data.get("SignInTime"),
				data.get("SignOutDate"),
				data.get("SignOutTime"));
	}
}
