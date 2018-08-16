package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class Search_VisitorPage extends TestBase{
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_PageControl_txtBasSearchTerm']")
	WebElement Basic_SearchTerm;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_PageControl_txtBasStartDate']")
	WebElement Basic_Search_StartDate;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_PageControl_txtBasEndDate']")
	WebElement Basic_Search_EndDate;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_PageControl_btnBasSearch']")
	WebElement Basic_Search_Btn;

	@FindBy(xpath="//*[@id='ctl01_MainContent_PageControl_btnClear']")
	WebElement Basic_Search_Clear_Btn;
	
	@FindBy(xpath="//li/a[@id='ctl01_MainContent_PageControl_T1T']")
	WebElement AdvSearchTab;
	
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvSearchField")
	WebElement AdvSearchTerm;
	
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvCriteria")
	WebElement AdvSearchCriteria;
	
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvSearchTerm")
	WebElement AdvSearchTextBox;
	
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvSortBy")
	WebElement AdvSortBy;
	
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvSortOrder")
	WebElement AdvSortOrder;
	
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvStartDate")
	WebElement AdvStartDate;
	
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvEndDate")
	WebElement AdvEndDate;
	
	@FindBy(id="ctl01_MainContent_PageControl_btnAdvSubmit")
	WebElement AdvSearchBtn;
	
	@FindBy(id="ctl01_MainContent_PageControl_btnClear2")
	WebElement AdvClearBtn;
	
	@FindBy(id="ctl01_MainContent_PageControl_lblBasSearchTerm")
	public WebElement AssertText_Searchvisitor;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	public Search_VisitorPage(WebDriver dr){
		driver = dr;
	}
	
	public void basicVisitorSearch(String VisitorName, String SearchStartDate) throws InterruptedException {
		TestUtil.delay(1000);
		Basic_SearchTerm.sendKeys(VisitorName);
		Basic_Search_StartDate.clear();
		Basic_Search_StartDate.sendKeys(SearchStartDate);
		Basic_Search_Btn.click();
		TestUtil.delay(1000);
		
	}
	
	public void advancedVisitorSearch(
			String Adv_SearchTerm, 
			String Adv_SearchCriteria,
			String Adv_SearchTextBox,
			String Adv_SortBy,
			String Adv_SortOrder,
			String Adv_StartDate,
			String Adv_EndDate)throws InterruptedException{

		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		AdvSearchTab.click();
		Select search_term = new Select(AdvSearchTerm);
		search_term.selectByVisibleText(Adv_SearchTerm);
		
		Select search_criteria = new Select(AdvSearchCriteria);
		search_criteria.selectByVisibleText(Adv_SearchCriteria);
		
		AdvSearchTextBox.sendKeys(Adv_SearchTextBox);
		
		Select sort_by = new Select(AdvSortBy);
		sort_by.selectByVisibleText(Adv_SortBy);
	
		Select sort_order = new Select(AdvSortOrder);
		sort_order.selectByVisibleText(Adv_SortOrder);
		
		AdvStartDate.clear();
		AdvStartDate.sendKeys(Adv_StartDate);
		
		AdvEndDate.clear();
		AdvEndDate.sendKeys(Adv_EndDate);
		
		AdvSearchBtn.click();
		TestUtil.delay(1000);
	}
	
	public String getSearchVisitorPageAssertText(){
		String SearchAssert= AssertText_Searchvisitor.getText();
		return SearchAssert;
	}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
}
