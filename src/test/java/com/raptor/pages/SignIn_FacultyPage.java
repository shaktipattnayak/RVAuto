package com.raptor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class SignIn_FacultyPage extends TestBase{
	public WebDriver driver;
	boolean QuickFindModalPopup=false;
	boolean FirstSuggestedFaculty=false;
	boolean FacultyAlreadyLoggedIn=false;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/div/table[1]/tbody/tr[1]/td/span")
	WebElement AssertText_facultysignin;
	
	@FindBy(id="ctl01_MainContent_txtQuickFind")
	WebElement QuickFindTextBox;
	
	@FindBy(id="ctl01_MainContent_btnFind")
	WebElement FindBtn;
	
	@FindBy(id="ctl01_MainContent_btnSubmit")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font[1]/b")
	WebElement QuickFindModelPopup;
	
	@FindBy(xpath="//div[@id='divScroll']/table/tbody/tr[2]/td[1]")
	WebElement FirstSuggestFaculty;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/img")
	WebElement QuickFindCloseIcon;
	
	@FindBy(id="ctl01_MainContent_flcFaculty_delaydatein")
	WebElement SignInDate;
	
	@FindBy(id="ctl01_MainContent_flcFaculty_delaytimein")
	WebElement SignInTime;
	
	@FindBy(id="ctl01_MainContent_flcFaculty_delaydateout")
	WebElement SignOutDate;
	
	@FindBy(id="ctl01_MainContent_flcFaculty_delaytimeout")
	WebElement SignOutTime;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlAlertModal']/table/tbody/tr[1]/td/table/tbody/tr/td[2]")
	WebElement FacultyAlreadyExistModalPopup;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlAlertModal']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/img")
	WebElement AlertModelCloseIcon;
	
	@FindBy(id="ctl01_MainContent_btnDelayedEntry")
	WebElement DelayedEntryBtn;
	
	public SignIn_FacultyPage(WebDriver dr){
		driver=dr;
	}
	
	
	public void signInFaculty(String facultyID){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(5000);
		QuickFindTextBox.sendKeys(facultyID);
		TestUtil.delay(5000);
		QuickFindTextBox.sendKeys(Keys.ENTER);
		//TestUtil.delay(5000);
		//FindBtn.click();
		TestUtil.delay(5000);
		QuickFindModalPopup=QuickFindModelPopup.isDisplayed();
		
		if(QuickFindModalPopup==true){
			System.out.println("Quick Find Modal Popup found");
			Application_Logs.debug("Quick Find Modal Popup found");
			FirstSuggestedFaculty=FirstSuggestFaculty.isDisplayed();
			if(FirstSuggestedFaculty=true){
				FirstSuggestFaculty.click();
				TestUtil.delay(2000);
				SubmitBtn.click();
				TestUtil.delay(3000);
				FacultyAlreadyLoggedIn=FacultyAlreadyExistModalPopup.isDisplayed();
				if(FacultyAlreadyLoggedIn==true){
					Application_Logs.debug("Faculty already Signed In");
					AlertModelCloseIcon.click();
				}
				System.out.println("Faculty Signed In Successfully");
			}
			if(!FacultyAlreadyLoggedIn==true||FirstSuggestedFaculty==true){
				QuickFindCloseIcon.click();
			}	
		}
		else{
			TestUtil.delay(2000);
			SubmitBtn.click();
			System.out.println("Submit button clicked");
			Application_Logs.debug("Faculty Sign In Submit button clicked");
			TestUtil.delay(3000);
			FacultyAlreadyLoggedIn=FacultyAlreadyExistModalPopup.isDisplayed();
			if(FacultyAlreadyLoggedIn==true){
				Application_Logs.debug("Faculty already Signed In");
				System.out.println("The Alert Modal pop up "+ FacultyAlreadyLoggedIn);
				AlertModelCloseIcon.click();
			}
		}
	}
	
	public void facultyDelayedEntry(
			String FacultyID,
			String SignIN_Date, 
			String SignIn_Time, 
			String SignOut_Date,
			String SignOut_Time){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(5000);
		DelayedEntryBtn.click();
		TestUtil.delay(2000);
		QuickFindTextBox.sendKeys(FacultyID);
		TestUtil.delay(5000);
		QuickFindTextBox.sendKeys(Keys.ENTER);
		TestUtil.delay(5000);
		QuickFindModalPopup=QuickFindModelPopup.isDisplayed();
		
		if(QuickFindModalPopup==true){
			System.out.println("Quick Find Modal Popup found");
			FirstSuggestedFaculty=FirstSuggestFaculty.isDisplayed();
			if(FirstSuggestedFaculty=true){
				FirstSuggestFaculty.click();
				TestUtil.delay(2000);
				SignInDate.clear();
				SignInDate.sendKeys(SignIN_Date);
				SignInTime.sendKeys(SignIn_Time);
				SignOutDate.clear();
				SignOutDate.sendKeys(SignOut_Date);
				SignOutTime.sendKeys(SignOut_Time);
				SubmitBtn.click();
			}
			System.out.println("No Suggested Faculty Record Found");
			QuickFindCloseIcon.click();
		}
		else{
			TestUtil.delay(2000);
			SignInDate.clear();
			SignInDate.sendKeys(SignIN_Date);
			SignInTime.sendKeys(SignIn_Time);
			
			SignOutDate.clear();
			SignOutDate.sendKeys(SignOut_Date);
			SignOutTime.sendKeys(SignOut_Time);
			SubmitBtn.click();
		}
	}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
	public String getSignInFacultyPageAssertText(){
		String ActualText=AssertText_facultysignin.getText();
		return ActualText;
	}
}
