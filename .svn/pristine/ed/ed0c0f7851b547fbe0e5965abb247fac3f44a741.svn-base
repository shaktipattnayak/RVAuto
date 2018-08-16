package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SearchFacultyPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SearchFacultyTest extends TestBase {
	/** The Expected text. */
	String ExpectedText="Search Term";
	

	/**
	 * Gets the basic search student data.
	 *
	 * @return the basic search student data
	 */
	@DataProvider
	public Object[][] getBasicSearchFacultyData(){
	return TestUtil.getData("basicSearchFaculty", "Test Data", xls);
	}
	
	/**
	 * Basic search_ student.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getBasicSearchFacultyData",priority=1,enabled=true, groups = {"smoke"})
	public void basicSearch_Faculty(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("basicSearchFaculty", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Basic Search Student test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SearchFacultyPage searchfaculty = home.gotoSearchFaculty();
	waitForPageToLoad();
		try{
		Assert.assertEquals(searchfaculty.getSearchFacultyPageAssertText(), ExpectedText);
		System.out.println("In Search Student page"+searchfaculty.getSearchFacultyPageAssertText());
		}catch(Throwable e){
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "SearchStudentPage");
		}
	
		searchfaculty.basicFacultySearch(data.get("FacultyID"), data.get("SearchStartDate"), data.get("SearchEndDate"));
	}
	
	/**
	 * Gets the advanced search student data.
	 *
	 * @return the advanced search student data
	 */
	@DataProvider
	public Object[][] getAdvancedSearchFacultyData(){
	return TestUtil.getData("advancedSearchFaculty", "Test Data", xls);
	}
	
	/**
	 * Advanced search_ student.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getAdvancedSearchFacultyData",priority=2,enabled=true, groups = {"smoke"})
	public void advancedSearch_Faculty(Hashtable<String,String>data) throws InterruptedException{
			
		if(!TestUtil.isExecuatable("advancedSearchFaculty", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Basic Search Student test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SearchFacultyPage searchfaculty = home.gotoSearchFaculty();
	waitForPageToLoad();
	searchfaculty.advancedFacultySearch(
			data.get("AdvSearchTerm"), 
			data.get("AdvSearchCriteria"),
			data.get("AdvSearchTextBox"),
			data.get("AdvSortBy"),
			data.get("AdvSortOrder"),
			data.get("AdvStartDate"),
			data.get("AdvEndDate"));
	}
}
