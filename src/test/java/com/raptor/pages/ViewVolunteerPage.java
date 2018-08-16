package com.raptor.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.TestUtil;

public class ViewVolunteerPage extends TestBase{
	
	public ViewVolunteerPage(WebDriver dr){
		//driver=driver;
		driver=dr;
	}
	
	WebDriver driver;
	
	public boolean VolunteerSignOutLink=false;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/table[2]/tbody/tr/td[3]")
	WebElement AssertText_viewvolunteer;
	
	@FindBy(xpath="//div[@id='ctl01_MainContent_UpdatePanel']/table[1]/tbody/tr/td[2]/a[1]/img")
	public WebElement RefreshBtn;
	
	@FindBy(id="ctl01_MainContent_RptQueue_ctl01_btnSignOut")
	WebElement FirstEntry_SignOutLink;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_UpdatePanel']/table[2]/tbody/tr")
	WebElement getCountOF;
	
	
	
	public void refreshViewVolunteerPage(){
		
		
		
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(3000);
		RefreshBtn.click();
		waitForPageToLoad();
		Application_Logs.debug("Refresh the View Volunteer Page");
		System.out.println("Refresh the View Volunteer Page");
	}
	
	public void signOutVolunteer(){
		List <WebElement> count = driver.findElements(By.xpath("//*[@id='ctl01_MainContent_UpdatePanel']/table[2]/tbody/tr"));
		 
		if(count.size()>1){
			FirstEntry_SignOutLink.click();
			Application_Logs.debug("Volunteer Signed Out Successfully");
			System.out.println("Volunteer Signed Out Successfully");
			}
			else{
				Application_Logs.debug("No Volunteers has Signed In");
				System.out.println("No Volunteers has Signed In");
			}
	}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
		waitForPageToLoad();
	}
	
	public String getViewVolunteerPageAssertText(){
		String ActualText=AssertText_viewvolunteer.getText();
		return ActualText;
	}
}
