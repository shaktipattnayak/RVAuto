package com.raptor.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.ViewVolunteerPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class ViewVolunteerTest extends TestBase{
	String ExpectedText="First Name";
	
	@Test(priority=1,enabled=true, groups = {"smoke"})
	public void refreshViewVolunteerPage(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ViewVolunteerPage viewvolunteer = home.gotoViewVolunteer();
		viewvolunteer.refreshViewVolunteerPage();
	}
	
	@Test(priority=2,enabled=true, groups = {"smoke"})
	public void signOutVolunteerTest(){
		
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	ViewVolunteerPage viewvolunteer = home.gotoViewVolunteer();
	try{
		waitForPageToLoad();
		Assert.assertEquals(viewvolunteer.getViewVolunteerPageAssertText(), ExpectedText);
		System.out.println("In View Volunteer page "+viewvolunteer.getViewVolunteerPageAssertText());
		Application_Logs.debug("In View Volunteer page "+viewvolunteer.getViewVolunteerPageAssertText());
		}catch(Throwable e){
			
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "ViewVolunteerPage");
		}
	viewvolunteer.signOutVolunteer();
	}
}
