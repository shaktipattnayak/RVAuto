package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SignOutStudentPage.
 */
public class SignOutStudentPage extends TestBase{

	/** The driver. */
	public WebDriver driver;
	
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
	
	/** The par_firstname. */
	@FindBy(id="ctl01_MainContent_flcParent_firstname")
	public WebElement par_firstname;
	
	/** The par_lastname. */
	@FindBy(id="ctl01_MainContent_flcParent_lastname")
	public WebElement par_lastname;
	
	/** The par_ dob. */
	@FindBy(id="ctl01_MainContent_flcParent_dateofbirth")
	public WebElement par_DOB;
	
	/** The par_license. */
	@FindBy(id="ctl01_MainContent_flcParent_licensenumber")
	public WebElement par_license;
	
	/** The std_submit. */
	@FindBy(id="ctl01_MainContent_btnSubmit")
	public WebElement std_submit;

	@FindBy(xpath="//div[@id='ctl01_MainContent_Panel2']/table[2]/tbody/tr[1]/td/span")
	public WebElement AssertText_SignOutStudentPage;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	/**
	 * Instantiates a new sign out student page.
	 *
	 * @param dr the dr
	 */
	public SignOutStudentPage(WebDriver dr) {
		driver = dr;
	}
	

	/**
	 * Sign out student manually.
	 *
	 * @param Std_fname the std_fname
	 * @param Std_lname the std_lname
	 */
	public void signOutStudentManually(
			String std_fname,
			String std_lname,
			String std_idnum,
			String std_Reason,
			String par_fname,
			String par_lname,
			String par_dob,
			String par_License
			){
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		std_firstname.sendKeys(std_fname);
		std_lastname.sendKeys(std_lname);
		std_idnumber.sendKeys(std_idnum);
		TestUtil.selectOptionByVisibleText(std_reason_dropdown, std_Reason);
		
		par_firstname.sendKeys(par_fname);
		par_lastname.sendKeys(par_lname);
		par_DOB.sendKeys(par_dob);
		par_license.sendKeys(par_License);
		
		std_submit.click();
		
	}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}

	
	public String getSignOutStudentPageAssertText(){
		String ActualText=AssertText_SignOutStudentPage.getText();
		return ActualText;
	}
}
