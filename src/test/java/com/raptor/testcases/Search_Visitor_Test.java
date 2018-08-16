package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.Search_VisitorPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class Search_Visitor_Test extends TestBase {
	
	String ExpectedText="Search Term";
	
	@Test(dataProvider="getBasicSearchVisitorData",priority=1,enabled=true, groups = {"smoke"})
	public void basicSearch_Visitor(Hashtable<String,String>data) throws InterruptedException{
		
			if(!TestUtil.isExecuatable("basicSearch_Visitor", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Basic Search Visitor test");
			}
			
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	Search_VisitorPage searchvisitor = home.gotoSearchVisitor();
	try{
		waitForPageToLoad();
		Assert.assertEquals(searchvisitor.getSearchVisitorPageAssertText(), ExpectedText);
		System.out.println("In Search Visitor page"+searchvisitor.getSearchVisitorPageAssertText());
		}catch(Throwable e){
			System.out.println("The Search Term not Found");
			ErrorUtil.addVerificationFailure(e);
			TestUtil.captureScreenShot(driver, "SearchVisitorPage");
		}
	
	searchvisitor.basicVisitorSearch(data.get("VisitorName"), data.get("SearchStartDate"));
	}
	
		@DataProvider
		public Object[][] getBasicSearchVisitorData(){
		return TestUtil.getData("basicSearch_Visitor","Test Data", xls);		
		}

	@Test(dataProvider="getAdvancedSearchVisitorData",priority=2,enabled=true)
	public void advancedSearch_Visitor(Hashtable<String,String>data) throws InterruptedException{
		if(!TestUtil.isExecuatable("advancedSearch_Visitor", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the Advanced Search Visitor test");
			}
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	Search_VisitorPage advsearchvisitor = home.gotoSearchVisitor();
	//advsearchvisitor.advancedVisitorSearch();
	waitForPageToLoad();
	advsearchvisitor.advancedVisitorSearch(data.get("AdvSearchTerm"), 
			data.get("AdvSearchCriteria"), 
			data.get("AdvSearchTextBox"), 
			data.get("AdvSortBy"),
			data.get("AdvSortOrder"),
			data.get("AdvStartDate"),
			data.get("AdvEndDate"));
	}
	
	@DataProvider
	public Object[][] getAdvancedSearchVisitorData(){
	return TestUtil.getData("advancedSearch_Visitor","Test Data", xls);		
	}
}