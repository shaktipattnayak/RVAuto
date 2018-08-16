package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SearchStudentPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Search_StudentTest.
 */
public class Search_StudentTest extends TestBase{
	
	/** The Expected text. */
	String ExpectedText="Search Term";
	

	/**
	 * Gets the basic search student data.
	 *
	 * @return the basic search student data
	 */
	@DataProvider
	public Object[][] getBasicSearchStudentData(){
	return TestUtil.getData("basicSearchStudent", "Test Data", xls);
	}
	
	/**
	 * Basic search_ student.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getBasicSearchStudentData",priority=1,enabled=true, groups = {"smoke"})
	public void basicSearch_Student(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("basicSearchStudent", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Basic Search Student test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SearchStudentPage searchstudent = home.gotoSearchStudent();
	waitForPageToLoad();
		try{
		Assert.assertEquals(searchstudent.getSearchStudentPageAssertText(), ExpectedText);
		System.out.println("In Search Student page"+searchstudent.getSearchStudentPageAssertText());
		}catch(Throwable e){
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "SearchStudentPage");
		}
	
	searchstudent.basicStudentSearch(data.get("StudentName"), data.get("SearchStartDate"), data.get("SearchEndDate"));
	}
	
	/**
	 * Gets the advanced search student data.
	 *
	 * @return the advanced search student data
	 */
	@DataProvider
	public Object[][] getAdvancedSearchStudentData(){
	return TestUtil.getData("advancedSearchStudent", "Test Data", xls);
	}
	
	/**
	 * Advanced search_ student.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getAdvancedSearchStudentData",priority=2,enabled=true, groups = {"smoke"})
	public void advancedSearch_Student(Hashtable<String,String>data) throws InterruptedException{
			
		if(!TestUtil.isExecuatable("advancedSearchStudent", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Advance Search Student test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	SearchStudentPage searchstudent = home.gotoSearchStudent();
	waitForPageToLoad();
	searchstudent.advancedStudentSearch(
			data.get("AdvSearchTerm"), 
			data.get("AdvSearchCriteria"),
			data.get("AdvSearchTextBox"),
			data.get("AdvSortBy"),
			data.get("AdvSortOrder"),
			data.get("AdvStartDate"),
			data.get("AdvEndDate"));
	}
}
