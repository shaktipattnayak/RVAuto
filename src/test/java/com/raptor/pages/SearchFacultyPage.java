package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class SearchFacultyPage extends TestBase{
	WebDriver driver;
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(id="ctl01_MainContent_PageControl_lblBasSearchTerm")
	WebElement AssertText_searchfaculty;
	
	@FindBy(xpath="//li/a[@id='ctl01_MainContent_PageControl_T0T']")
	WebElement Basic_SearchTab;
	
	@FindBy(id="ctl01_MainContent_PageControl_txtBasSearchTerm")
	public WebElement Basic_SearchTerm;
	
	/** The Basic_ search_ start date. */
	@FindBy(id="ctl01_MainContent_PageControl_txtBasStartDate")
	public WebElement Basic_Search_StartDate;
	
	/** The Basic_ search_ end date. */
	@FindBy(id="ctl01_MainContent_PageControl_txtBasEndDate")
	public WebElement Basic_Search_EndDate;
	
	/** The Basic_ search_ btn. */
	@FindBy(id="ctl01_MainContent_PageControl_btnBasSearch")
	public WebElement Basic_Search_Btn;
	

	
	/** The Adv search tab. */
	@FindBy(xpath="//li/a[@id='ctl01_MainContent_PageControl_T1T']")
	WebElement AdvSearchTab;
	
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvSearchField")
	public WebElement AdvSearchTerm;
	
	/** The Adv search criteria. */
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvCriteria")
	public WebElement AdvSearchCriteria;
	
	/** The Adv search text box. */
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvSearchTerm")
	public WebElement AdvSearchTextBox;
	
	/** The Adv sort by. */
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvSortBy")
	public WebElement AdvSortBy;
	
	/** The Adv sort order. */
	@FindBy(id="ctl01_MainContent_PageControl_ddAdvSortOrder")
	public WebElement AdvSortOrder;
	

	
	/** The Adv start date. */
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvStartDate")
	public WebElement AdvStartDate;
	
	/** The Adv end date. */
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvEndDate")
	public WebElement AdvEndDate;
	
	/** The Adv search btn. */
	@FindBy(id="ctl01_MainContent_PageControl_btnAdvSubmit")
	public WebElement AdvSearchBtn;
	
	
	public SearchFacultyPage(WebDriver dr){
		driver=dr;
	}
	
	public void basicFacultySearch(String FacultyID, String SearchStartDate, String SearchEndDate){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		//Basic_SearchTab.click();
		Basic_SearchTerm.sendKeys(FacultyID);
		Basic_Search_StartDate.clear();
		Basic_Search_StartDate.sendKeys(SearchStartDate);
		Basic_Search_EndDate.clear();
		Basic_Search_EndDate.sendKeys(SearchEndDate);
		Basic_Search_Btn.click();
		TestUtil.delay(1000);
	}
	
	public void advancedFacultySearch(
			String Adv_SearchTerm, 
			String Adv_SearchCriteria,
			String Adv_SearchTextBox,
			String Adv_SortBy,
			String Adv_SortOrder,
			String Adv_StartDate,
			String Adv_EndDate){
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		AdvSearchTab.click();
		TestUtil.selectOptionByVisibleText(AdvSearchTerm, Adv_SearchTerm);
		TestUtil.selectOptionByVisibleText(AdvSearchCriteria, Adv_SearchCriteria);
		AdvSearchTextBox.sendKeys(Adv_SearchTextBox);
		TestUtil.selectOptionByVisibleText(AdvSortBy, Adv_SortBy);
		TestUtil.selectOptionByVisibleText(AdvSortOrder, Adv_SortOrder);	
		AdvStartDate.clear();
		AdvStartDate.sendKeys(Adv_StartDate);
		AdvEndDate.clear();
		AdvEndDate.sendKeys(Adv_EndDate);
		AdvSearchBtn.click();		
		
	}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
	public String getSearchFacultyPageAssertText(){
		String ActualText=AssertText_searchfaculty.getText();
		return ActualText;
	}

}
