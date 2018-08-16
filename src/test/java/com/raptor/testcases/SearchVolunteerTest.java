package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SearchVolunteerPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SearchVolunteerTest extends TestBase{
	String ExpectedText="Search Term";
	
	@DataProvider
	public Object[][] getBasicSearchVolunteerData(){
	return TestUtil.getData("basicSearchVolunteer", "Test Data", xls);
	}
	
	@Test(dataProvider="getBasicSearchVolunteerData",priority=1,enabled=true, groups = {"smoke"})
	public void basicSearch_Student(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("basicSearchVolunteer", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Basic Search Volunteer test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SearchVolunteerPage searchvolunteer = home.gotoSearchVolunteer();
	waitForPageToLoad();
		try{
		Assert.assertEquals(searchvolunteer.getSearchStudentPageAssertText(), ExpectedText);
		System.out.println("In Search Volunteer page"+searchvolunteer.getSearchStudentPageAssertText());
		}catch(Throwable e){
			Assert.fail();
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "SearchVolunteerPage");
		}
	
		searchvolunteer.basicVolunteerSearch(data.get("VolunteerName"), data.get("SearchStartDate"), data.get("SearchEndDate"));
	}
	
	
	@DataProvider
	public Object[][] getAdvancedSearchVolunteerData(){
	return TestUtil.getData("advancedSearchVolunteer", "Test Data", xls);
	}
	
	/**
	 * Advanced search_ student.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getAdvancedSearchVolunteerData",priority=2,enabled=true, groups = {"smoke"})
	public void advancedSearch_Student(Hashtable<String,String>data) throws InterruptedException{
			
		if(!TestUtil.isExecuatable("advancedSearchVolunteer", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Advance Search Volunteer test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SearchVolunteerPage searchvolunteer = home.gotoSearchVolunteer();
	waitForPageToLoad();
	searchvolunteer.advancedVolunteerSearch(
			data.get("AdvSearchTerm"), 
			data.get("AdvSearchCriteria"),
			data.get("AdvSearchTextBox"),
			data.get("AdvSortBy"),
			data.get("AdvSortOrder"),
			data.get("AdvStartDate"),
			data.get("AdvEndDate"));
	}
}
