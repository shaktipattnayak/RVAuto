package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SignInVolunteerPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SignInVolunteerTest extends TestBase {

	String ExpectedText = "Task Information";
	
	@DataProvider
	public Object[][] getsignInVolunteerData(){
	return TestUtil.getData("signInVolunteerTest","Test Data", xls);		
	}
	
	@Test(dataProvider="getsignInVolunteerData",priority=1,enabled=true, groups = {"smoke"})
	public void signInVolunteerTest(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("signInVolunteerTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Sign In Volunteer Test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SignInVolunteerPage signinvolunteer = home.gotoSignInVolunteer();
	waitForPageToLoad();
	try{
		Assert.assertEquals(signinvolunteer.getSignInVolunteerPageAssertText(),ExpectedText);
		System.out.println("In Sign In Volunteer page "+signinvolunteer.getSignInVolunteerPageAssertText());
		}catch(Throwable e){
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "SignInVolunteerPage");
		}
	signinvolunteer.signInVolunteer(data.get("VolunteerName"), data.get("Function"), data.get("Affilation"), data.get("Organization"));
	}
	
	@DataProvider
	public Object[][] getVolunteerDelayedEntryData(){
	return TestUtil.getData("volunteerDelayedEntryTest","Test Data", xls);		
	}
	
	@Test(dataProvider="getVolunteerDelayedEntryData",priority=1,enabled=true)
	public void volunteerDelayedEntryTest(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("volunteerDelayedEntryTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Sign In Faculty Test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SignInVolunteerPage signinvolunteer = home.gotoSignInVolunteer();
	signinvolunteer.volunteerDelayedEntry(
			data.get("VolunteerName"), 
			data.get("SignInDate"), 
			data.get("SignInTime"),  
			data.get("SignOutDate"), 
			data.get("SignOutTime"), 
			data.get("Function"), 
			data.get("Affilation"), 
			data.get("Organization"));
	}
}
