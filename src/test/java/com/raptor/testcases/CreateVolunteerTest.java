package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.CreateVolunteerPage;
import com.raptor.pages.HomePage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class CreateVolunteerTest extends TestBase {
	String ExpectedText="Volunteer Information";
	
	@DataProvider
	public Object[][] getCreateVolunteerData(){
	return TestUtil.getData("createVolunteerTest","Test Data", xls);		
	}
	
	@Test(dataProvider="getCreateVolunteerData",priority=1,enabled=true)
	public void signInVolunteerTest(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("createVolunteerTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Create Volunteer Test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	CreateVolunteerPage createvolunteer = home.gotoCreateVolunteer();
	waitForPageToLoad();
	try{
		Assert.assertEquals(createvolunteer.getCreateVolunteerPageAssertText(),ExpectedText);
		System.out.println("In Create Volunteer page "+createvolunteer.getCreateVolunteerPageAssertText());
		}catch(Throwable e){
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "CreateVolunteerPage");
		}
	createvolunteer.createVolunteerManually(
			data.get("VolFirstName"), 
			data.get("VolLastName"), 
			data.get("VolDOB"), 
			data.get("Vol_LIC_NO"), 
			data.get("Vol_Address"), 
			data.get("Vol_City"),
			data.get("Vol_ZIP"), 
			data.get("Vol_Home"), 
			data.get("Vol_Work"), 
			data.get("Vol_Mobile"),
			data.get("Vol_Gender"),
			data.get("Vol_Email"),
			data.get("Vol_ExpDate"));
	}
}
