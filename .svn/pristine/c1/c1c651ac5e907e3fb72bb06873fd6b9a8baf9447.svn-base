package com.raptor.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SignInStudentPage.
 */
public class SignInStudentPage extends TestBase {
	
	/** The driver. */
	public WebDriver driver;
	boolean NoResultFound=false;
	
	/** The tardy alert popup. */
	boolean tardyAlertPopup=false;
	
	/** The quick find popup. */
	boolean quickFindPopup=false;
	
	/** The std_firstname. */
	@FindBy(id="ctl01_MainContent_flcStudent_firstname")
	public WebElement std_firstname;
	
	/** The std_lastname. */
	@FindBy(id="ctl01_MainContent_flcStudent_lastname")
	public WebElement std_lastname;
	
	/** The std_idnumber. */
	@FindBy(id="ctl01_MainContent_flcStudent_idnumber")
	public WebElement std_idnumber;
	
	/** The std_reason_dropdown. */
	@FindBy(id="ctl01_MainContent_flcStudent_reason")
	public WebElement std_reason_dropdown;
	
	/** The std_submit. */
	@FindBy(id="ctl01_MainContent_btnSubmit")
	public WebElement std_submit;

	/** The tardy alert light box. */
	@FindBy(xpath="//div[@id='ctl01_MainContent_pcTardy_PWC-1']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font[1]/b")
	public WebElement tardyAlertLightBox;
	
	/** The detention note. */
	@FindBy(id="ctl01_MainContent_pcTardy_TardyPanelTabs_TM_txtDetentionNotes_I")
	public WebElement detentionNote;
	
	/** The date assigned. */
	@FindBy(id="ctl01_MainContent_pcTardy_TardyPanelTabs_TM_txtDateDHall_I")
	public WebElement dateAssigned;
	
	/** The Quick find test box. */
	@FindBy(id="ctl01_MainContent_txtQuickFind")
	public WebElement  QuickFindTestBox; 
	
	/** The find btn. */
	@FindBy(id="ctl01_MainContent_BtnFind")
	public WebElement  findBtn; 
	
	/** The quick find light box. */
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font[1]/b")
	public WebElement  quickFindLightBox;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/img")
	public WebElement  quickFindLightBoxClose;
	
	/** The suggested value1. */
	@FindBy(xpath="//div[@id='divScroll']/table/tbody/tr[2]/td[1]")
	public WebElement  suggestedValue1;
	
	/** The edit mode off. */
	@FindBy(xpath="//table[@id='ctl01_MainContent_ctl08']/tbody/tr[1]/td/a")
	public WebElement  editModeOff;
	
	/** The print detention slip check box. */
	@FindBy(id="ctl01_MainContent_pcTardy_TardyPanelTabs_TM_chbDHallPrint_S_D")
	public WebElement printDetentionSlipCheckBox;
	
	/** The tardy alert submit btn. */
	@FindBy(id="ctl01_MainContent_pcTardy_TM_btnAddTardy_CD")
	public WebElement tardyAlertSubmitBtn;
	
	/** The delayed entry btn. */
	@FindBy(id="ctl01_MainContent_btnDelayedEntry")
	public WebElement delayedEntryBtn;
	
	/** The sign in date. */
	@FindBy(id="ctl01_MainContent_flcStudent_delaydatein")
	public WebElement signInDate;
	
	/** The sign in time. */
	@FindBy(id="ctl01_MainContent_flcStudent_delaytimein")
	public WebElement signInTime;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/div/table[1]/tbody/tr[1]/td/span")
	WebElement AssertText_SignInStudentPage;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	/**
	 * Instantiates a new sign in student page.
	 *
	 * @param dr the dr
	 */
	public SignInStudentPage(WebDriver dr) {
		driver = dr;
	}

	/**
	 * Sign in_ student_ manually.
	 *
	 * @param std_fname the std_fname
	 * @param std_lname the std_lname
	 * @param std_IDnum the std_ i dnum
	 * @param std_reason the std_reason
	 */
	public void SignIn_Student_Manually(String std_fname,String std_lname, String std_IDnum, String std_reason){
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		std_firstname.sendKeys(std_fname);
		std_lastname.sendKeys(std_lname);
		std_idnumber.sendKeys(std_IDnum);
		Select reason = new Select(std_reason_dropdown);
		reason.selectByVisibleText(std_reason);
		std_submit.click();
		
		
		//WebDriverWait wait = new WebDriverWait(driver,05);
		//WebElement tardyAlertPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='ctl01_MainContent_pcTardy_TardyPanelTabs_AT0T']/span")));
		
		tardyAlertPopup=tardyAlertLightBox.isDisplayed();
		if(tardyAlertPopup!=false)
		{
			detentionNote.sendKeys("TESTING");
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateAssigned.sendKeys(dateFormat.format(date));
		}	
	}
	
	/**
	 * Sign in student by quick find.
	 *
	 * @param std_fname the std_fname
	 * @param std_reason the std_reason
	 * @throws InterruptedException the interrupted exception
	 */
	public void SignInStudentByQuickFind(String std_fname,String std_reason) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		Thread.sleep(5000);
		QuickFindTestBox.sendKeys(std_fname);
		findBtn.click();
		Thread.sleep(5000);
		quickFindPopup=quickFindLightBox.isDisplayed();
		//Thread.sleep(5000);
		if(quickFindPopup=true){
			//wait.until(ExpectedConditions.elementToBeSelected(suggestedValue1));
			TestUtil.delay(5000);
			NoResultFound=suggestedValue1.isDisplayed();
			if(NoResultFound=true){
				suggestedValue1.click();
				Thread.sleep(5000);
				//wait.until(ExpectedConditions.visibilityOf(std_reason_dropdown));
				editModeOff.click();
				Select reason = new Select(std_reason_dropdown);
				reason.selectByVisibleText(std_reason);
				std_submit.click();
			}else{
				
				quickFindLightBoxClose.click();
			}
		}
		else{
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.elementToBeClickable(std_reason_dropdown));
			//wait.until(ExpectedConditions.visibilityOf(std_reason_dropdown));
			//editModeOff.click();
			Select reason = new Select(std_reason_dropdown);
			reason.selectByVisibleText(std_reason);
			std_submit.click();
			Thread.sleep(7000);
		}
		
		tardyAlertPopup=tardyAlertLightBox.isDisplayed();
		if(tardyAlertPopup!=false)
		{
			detentionNote.sendKeys("TESTING");
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateAssigned.sendKeys(dateFormat.format(date));
			//wait.until(ExpectedConditions.visibilityOf(tardyAlertLightBox));
			//Thread.sleep(4000);
			TestUtil.delay(4000);
			printDetentionSlipCheckBox.click();
			tardyAlertSubmitBtn.click();
			System.out.println("tardyAlertSubmitBtn clicked");
		}	
		
	}

	
	
	/**
	 * Student delayed entry manually.
	 *
	 * @param std_fname the std_fname
	 * @param std_lname the std_lname
	 * @param std_IDnum the std_ i dnum
	 * @param std_reason the std_reason
	 * @param signindate the signindate
	 * @param signintime the signintime
	 */
	public void studentDelayedEntryManually
		(String std_fname, String std_lname, String std_IDnum, String std_reason, String signindate,String signintime){
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		delayedEntryBtn.click();
		waitForPageToLoad();
		std_firstname.sendKeys(std_fname);
		std_lastname.sendKeys(std_lname);
		std_idnumber.sendKeys(std_IDnum);
		//TestUtil.selectOptionByValue(std_reason_dropdown, std_reason);
		TestUtil.selectOptionByVisibleText(std_reason_dropdown, std_reason);
		signInDate.sendKeys(signindate);
		//signInTime.click();
		//TestUtil.delay(2000);
		signInTime.sendKeys(signintime);
		TestUtil.delay(5000);
		std_submit.click();
		tardyAlertPopup=tardyAlertLightBox.isDisplayed();
		if(tardyAlertPopup!=false)
		{
			detentionNote.sendKeys("TESTING");
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateAssigned.sendKeys(dateFormat.format(date));
		}	
	}

		public String getSignInStudentPageAssertText(){
			String ActualText=AssertText_SignInStudentPage.getText();
			return ActualText;
		}
		
		public void Change_Building(String Building_Name) {
			waitForPageToLoad();
			TestUtil.selectOptionByVisibleText(select_building,Building_Name );
		}

}
