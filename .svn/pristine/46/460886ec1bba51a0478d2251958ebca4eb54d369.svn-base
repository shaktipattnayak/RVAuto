package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class CreateVolunteerPage extends TestBase {
	public WebDriver driver;
	boolean PrivateAlert=false;
	boolean OffenderAlert=false;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/div/table[1]/tbody/tr[1]/td/span")		
	public WebElement AssertText_createvolunteerpage;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_firstname")
	public WebElement Vol_FirstName;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_lastname")
	public WebElement Vol_LastName;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_dateofbirth")
	public WebElement Vol_DOB;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_licensenumber")
	public WebElement Vol_License_No;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_address")
	public WebElement Vol_Address;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_city")
	public WebElement Vol_City;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_zipcode")
	public WebElement Vol_ZipCode;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_home")
	public WebElement Vol_Home;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_work")
	public WebElement Vol_Work;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_mobile")
	public WebElement Vol_Mobile;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_sex")
	public WebElement Vol_Gender;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_email")
	public WebElement Vol_Email;
	
	@FindBy(id="ctl01_MainContent_flcVolunteer_expirationdate_I")
	public WebElement Vol_ExpDate;
	
	@FindBy(id="ctl01_MainContent_cblTask_0")
	public WebElement TaskInfo_Athletics;
	
	@FindBy(id="ctl01_MainContent_cblTask_1")
	public WebElement TaskInfo_Cafeteria;
	
	@FindBy(id="ctl01_MainContent_cblTask_2")
	public WebElement TaskInfo_Classroom_Helper;
	
	@FindBy(id="ctl01_MainContent_cblTask_7")
	public WebElement TaskInfo_Mentor;
	
	@FindBy(id="ctl01_MainContent_cblTask_12")
	public WebElement TaskInfo_Tutor;
	
	@FindBy(id="ctl01_MainContent_cblaffiliation_0")
	public WebElement AffInfo_Business_Partner;
	
	@FindBy(id="ctl01_MainContent_cblaffiliation_5")
	public WebElement AffInfo_Sibling;
	
	@FindBy(id="ctl01_MainContent_cblaffiliation_6")
	public WebElement AffInfo_Student;
	
	@FindBy(id="ctl01_MainContent_cblaffiliation_4")
	public WebElement AffInfo_Parent;
	
	
	@FindBy(id="ctl01_MainContent_cblaffiliation_4")
	public WebElement OrgInfo_Other;
	
	@FindBy(id="ctl01_MainContent_cblaffiliation_4")
	public WebElement OrgInfo_PTA_PTO;
	
	@FindBy(id="ctl01_MainContent_BtnSubmit")
	public WebElement Vol_SubmitBtn;
	
	public CreateVolunteerPage(WebDriver dr){
		driver=dr;
	}
	
	public void createVolunteerManually(
			String firstname, 
			String lastname, 
			String dob, 
			String license_number,
			String address,
			String city,
			String zipcode,
			String volhome,
			String work,
			String mobile,
			String gender,
			String email,
			String expirationDate){
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(4000);
		
		Vol_FirstName.sendKeys(firstname);
		Vol_LastName.sendKeys(lastname);
		Vol_DOB.sendKeys(dob);
		Vol_License_No.sendKeys(license_number);
		Vol_Address.sendKeys(address);
		Vol_City.sendKeys(city);
		Vol_ZipCode.sendKeys(zipcode);
		Vol_Home.sendKeys(volhome);
		Vol_Work.sendKeys(work);
		Vol_Mobile.sendKeys(mobile);
		TestUtil.selectOptionByVisibleText(Vol_Gender, gender);
		Vol_Email.sendKeys(email);
		Vol_ExpDate.sendKeys(expirationDate);
		TaskInfo_Athletics.click();
		TaskInfo_Cafeteria.click();
		TaskInfo_Classroom_Helper.click();
		TaskInfo_Mentor.click();
		TaskInfo_Tutor.click();
		AffInfo_Business_Partner.click();
		AffInfo_Parent.click();
		AffInfo_Sibling.click();
		AffInfo_Student.click();
		OrgInfo_Other.click();
		OrgInfo_PTA_PTO.click();
		Vol_SubmitBtn.click();
	}
	

	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
	public String getCreateVolunteerPageAssertText(){
		String ActualText=AssertText_createvolunteerpage.getText();
		return ActualText;
	}
}
