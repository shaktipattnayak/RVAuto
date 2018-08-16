package com.raptor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewFacultyPage.
 */
public class ViewFacultyPage extends TestBase{
	
	/** The Faculty sign out link. */
	public boolean FacultySignOutLink=false;
	
	/** The Reason_ dialogbox. */
	public boolean Reason_Dialogbox=false;
	
	/** The select_building. */
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	/** The Refresh btn. */
	@FindBy(id="IMG1")
	WebElement RefreshBtn;
	
	/** The First entry_ sign out link. */
	@FindBy(id="ctl01_MainContent_RptQueue_ctl01_btnSignOut")
	WebElement FirstEntry_SignOutLink;
	
	/** The Assert text_viewfaculty. */
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/table[2]/tbody/tr[1]/td[2]")
	WebElement AssertText_viewfaculty;
	
	/** The Reason dialog box. */
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlReasonModal']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font[1]/b")
	WebElement ReasonDialogBox;
	
	/** The Select reason. */
	@FindBy(id="ctl01_MainContent_ddReason")
	WebElement SelectReason;
	
	/** The Reason dialog box sign out btn. */
	@FindBy(id="ctl01_MainContent_btnSignOut")
	WebElement ReasonDialogBoxSignOutBtn;
	
	@FindBy(id="ctl01_MainContent_RptQueue_ctl00_CbxAll")
	WebElement SelectAllChkBox;
	
	@FindBy(xpath="//input[@id='ctl01_MainContent_RptQueue_ctl04_Button1']")
	WebElement SignOutBtn;
	
	/**
	 * Refresh view faculty page.
	 */
	public void refreshViewFacultyPage(){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(5000);
		RefreshBtn.click();
		waitForPageToLoad();
	}
	
	/**
	 * Sign out faculty.
	 *
	 * @param Reason the reason
	 */
	public void signOutFaculty(String Reason){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(2000);
		try{
		FacultySignOutLink=FirstEntry_SignOutLink.isDisplayed();
		if (FacultySignOutLink==true){
			FirstEntry_SignOutLink.click();
			TestUtil.delay(2000);
			Reason_Dialogbox=ReasonDialogBox.isDisplayed();
			if(Reason_Dialogbox==true){
				TestUtil.selectOptionByVisibleText(SelectReason, Reason);
				ReasonDialogBoxSignOutBtn.click();
				Thread.sleep(4000);
			}
			Application_Logs.debug("Faculty Signed Out Successfully");
			System.out.println("Faculty Signed Out Successfully");
		}
		}catch(Exception e){
			Application_Logs.debug("None of the Faculty members has signed in");
			System.out.println("None of the Faculty members has signed in");
		}	
	}
	
	public void signOutAllFaculty(){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(1000);
		SelectAllChkBox.click();
		TestUtil.delay(3000);
		SignOutBtn.click();
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
	
	/**
	 * Gets the view faculty page assert text.
	 *
	 * @return the view faculty page assert text
	 */
	public String getViewFacultyPageAssertText(){
		String ActualText=AssertText_viewfaculty.getText();
		return ActualText;
	}
}
