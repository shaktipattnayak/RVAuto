package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchStudentPage.
 */
public class SearchStudentPage extends TestBase{
	
	/** The driver. */
	WebDriver driver;
	
	/** The Assert text_ search student. */
	@FindBy(id="ctl01_MainContent_PageControl_lblBasSearchTerm")
	public WebElement AssertText_SearchStudent;
	
	/** The select_building. */
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	/** The Basic_ search tab. */
	@FindBy(xpath="//li/a[@id='ctl01_MainContent_PageControl_AT0T']")
	public WebElement Basic_SearchTab;
	
	/** The Basic_ search term. */
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
	
	
	
	
	/** The Adv search term. */
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
	
	/** The Adv search tab. */
	@FindBy(xpath="//li/a[@id='ctl01_MainContent_PageControl_T1T']")
	WebElement AdvSearchTab;
	
	/** The Adv start date. */
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvStartDate")
	public WebElement AdvStartDate;
	
	/** The Adv end date. */
	@FindBy(id="ctl01_MainContent_PageControl_txtAdvEndDate")
	public WebElement AdvEndDate;
	
	/** The Adv search btn. */
	@FindBy(id="ctl01_MainContent_PageControl_btnAdvSubmit")
	public WebElement AdvSearchBtn;
	
	/**
	 * Instantiates a new search student page.
	 *
	 * @param dr the dr
	 */
	public SearchStudentPage(WebDriver dr){
		driver=dr;
	}
	
	/**
	 * Basic student search.
	 *
	 * @param StudentName the student name
	 * @param SearchStartDate the search start date
	 * @param SearchEndDate the search end date
	 */
	public void basicStudentSearch(String StudentName, String SearchStartDate, String SearchEndDate){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		Basic_SearchTab.click();
		Basic_SearchTerm.sendKeys(StudentName);
		Basic_Search_StartDate.clear();
		Basic_Search_StartDate.sendKeys(SearchStartDate);
		Basic_Search_EndDate.clear();
		Basic_Search_EndDate.sendKeys(SearchEndDate);
		Basic_Search_Btn.click();
		TestUtil.delay(1000);
	}
	
	/**
	 * Advanced student search.
	 *
	 * @param Adv_SearchTerm the adv_ search term
	 * @param Adv_SearchCriteria the adv_ search criteria
	 * @param Adv_SearchTextBox the adv_ search text box
	 * @param Adv_SortBy the adv_ sort by
	 * @param Adv_SortOrder the adv_ sort order
	 * @param Adv_StartDate the adv_ start date
	 * @param Adv_EndDate the adv_ end date
	 */
	public void advancedStudentSearch(
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
	
	/**
	 * Gets the search student page assert text.
	 *
	 * @return the search student page assert text
	 */
	public String getSearchStudentPageAssertText(){
		String SearchAssert= AssertText_SearchStudent.getText();
		return SearchAssert;
	}
	
	/**
	 * Change_ building.
	 *
	 * @param Building_Name the building_ name
	 */
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
}
