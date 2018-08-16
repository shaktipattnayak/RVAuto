package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.raptor.base.TestBase;
import com.raptor.util.Constants;
import com.raptor.util.TestUtil;

public class ViewVisitorPage extends TestBase{
	
	public WebDriver driver;
	boolean SignOutLink=false;
	boolean SignOutButton=false;
	
	@FindBy(xpath=Constants.visitortab)
	public WebElement visitor;
	
	@FindBy(xpath=Constants.viewvisitor)
	public WebElement view_visitor;
	
	@FindBy(id="ctl01_MainContent_BuildingDropDown_ddBuilding")
	public WebElement select_building;
	
	@FindBy(id="ctl01_MainContent_SignOutChecked")
	public WebElement signoutbtn;
	
	public final String part1="//*[@id='ctl01_MainContent_upRepeater']/table/tbody/tr[0";
	public final String part2="]/td[3]";
	@FindBy(xpath=part1+"i"+part2)
	public WebElement visitorfirstName;
	
	
	@FindBy(xpath="//a[@id='ctl01_MainContent_RptQueue_ctl01_btnSignOut']")
	public WebElement visitorsignout;
	
	public ViewVisitorPage(WebDriver dr){
		driver = dr;
	}
	
	public void signout_Visitor(){
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		if(isSignInEntryAvailable()==true){
		visitorsignout.click();
		}
	}
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
	}
	
	public boolean isSignInEntryAvailable(){
		SignOutLink=visitorsignout.isDisplayed();
		if(SignOutLink==true){
			return true;
		}
		return SignOutLink;
	}
	
	public boolean isSignOutButtonDisplayed(){
		SignOutButton=signoutbtn.isDisplayed();
		if(SignOutButton==true){
			return true;
		}
		return SignOutButton;
	}
	
}
