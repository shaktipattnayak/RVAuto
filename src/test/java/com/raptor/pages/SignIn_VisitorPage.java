package com.raptor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raptor.base.TestBase;
import com.raptor.util.Constants;
import com.raptor.util.TestUtil;

public class SignIn_VisitorPage extends TestBase{
	boolean QuickFindPopup=false;
	boolean NoResultFound=false;
	public WebDriver driver;

	@FindBy(xpath = Constants.visitortab)
	public WebElement visitor;

	@FindBy(xpath = Constants.signinvisotor)
	public WebElement signin_visitor;

	@FindBy(xpath = Constants.buildingselectdropdown)
	public WebElement select_building;
	
	@FindBy(xpath="//*[@id='ctl01_MainContent_UpdatePanel']/div/table[1]/tbody/tr[1]/td/span")
	public WebElement AssertText_VisitorInformation;
	
	@FindBy(xpath = Constants.visitorfirstname)
	public WebElement visitor_firstname;

	@FindBy(xpath = Constants.visitorlasttname)
	public WebElement visitor_lastname;

	@FindBy(xpath = Constants.visitordob)
	public WebElement visitor_dob;

	@FindBy(xpath = Constants.visitorsubmitbtn)
	public WebElement visitorsubmitbtn;

	@FindBy(xpath = Constants.visitor_quick_find)
	public WebElement visitor_quick_find;

	@FindBy(xpath = Constants.visitor_findbtn)
	public WebElement visitor_findbtn;

	@FindBy(xpath = Constants.quick_find_popup)
	public WebElement quick_find_popup;

	@FindBy(xpath = Constants.select_visitor_from_quick_find_popup)
	public WebElement select_visitor_from_quick_find_popup;

	@FindBy(xpath = "//*[@id='Alert_Header_Text']")
	public WebElement OffenderAlertPage;

	@FindBy(xpath = "//*[@id='Alert_SubHeader']/div/div[3]/div[2]/div")
	public WebElement OffenderMatch_NO_Btn;

	@FindBy(xpath = "//*[@id='ctl01_MainContent_flcVisitor_notes']")
	public WebElement note;

	@FindBy(xpath = "//*[@id='Alert_SubHeader']/div/div[3]/div[2]/div/input")
	public WebElement PrivateAlertMatch_NO_Btn;

	@FindBy(xpath = "//*[@id='Alert_Header_Text']")
	public WebElement PrivateAlertPage;
	
	@FindBy(id="ctl01_MainContent_lblQuickFindNotes")
	public WebElement QuickFindNoResultFound;

	@FindBy(xpath = "//*[@id='ctl01_MainContent_pnlQuickModal']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/img")
	public WebElement QuickFindPopupCloseIcon;
	
	@FindBy(xpath = "//div[@id='Div3']/div/b/font")
	public WebElement isThisAMatch;
	
	public SignIn_VisitorPage(WebDriver dr) {
		driver = dr;
	}

	public void signin_visitor_manually(String Fname,String Lname,String DOB) throws Exception{
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		TestUtil.delay(2000);
		visitor_firstname.sendKeys(Fname);
		visitor_lastname.sendKeys(Lname);
		visitor_dob.clear();
		visitor_dob.sendKeys(DOB);
		note.clear();
		note.sendKeys("TESTING");
		visitorsubmitbtn.click();
		TestUtil.delay(1000);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement OffenderAlertPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Alert_Header_Text']")));
			
			if(OffenderAlertPage!=null)
			{
				OffenderMatch_NO_Btn.click();
				//System.out.println("Offerender Found");
			}
			
			WebElement PrivateAlertPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Alert_Header_Text']")));
			if(PrivateAlertPage!=null){
			PrivateAlertMatch_NO_Btn.click();
			//System.out.println("Private Alert Found");

				}
			}catch(Exception e)
			{
				System.out.println();
				System.out.println("System did not found "+Fname +" "+Lname+ " as an offerender or Private Alert");
				
				System.out.println();
			}
		}

	
	public void visitor_Signin_By_QuickFind(String VisitorName)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,60);
		waitForPageToLoad();
		Change_Building(Config.getProperty("Building"));
		waitForPageToLoad();
		visitor_quick_find.sendKeys(VisitorName);
		visitor_findbtn.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("quick find button Clicked");
		try
		{
			 QuickFindPopup = quick_find_popup.isDisplayed();
		if (QuickFindPopup != false) {
			System.out.println("selecting visitor for quick find");
			NoResultFound=QuickFindNoResultFound.isDisplayed();
			
				if(NoResultFound!=false){
					System.out.println(QuickFindNoResultFound.getText());
					QuickFindPopupCloseIcon.click();
				}
			
			select_visitor_from_quick_find_popup.click();
			note.clear();
			note.sendKeys("TESTING");
			visitorsubmitbtn.click();
			WebElement OffenderAlertPage = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id='Alert_Header_Text']")));
				if (OffenderAlertPage != null) {
					OffenderMatch_NO_Btn.click();
				}
	
				WebElement PrivateAlertPage = wait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.xpath("//*[@id='Alert_Header_Text']")));
	
				if (PrivateAlertPage != null) {
					PrivateAlertMatch_NO_Btn.click();
				}
			}
		else {
			Thread.sleep(5000);
			note.clear();
			note.sendKeys("TESTING");
			visitorsubmitbtn.click();

			WebElement OffenderAlertPage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath("//*[@id='Alert_Header_Text']")));

			if (OffenderAlertPage != null) {
				OffenderMatch_NO_Btn.click();
			}

			WebElement PrivateAlertPage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath("//*[@id='Alert_Header_Text']")));

			if (PrivateAlertPage != null) {
				PrivateAlertMatch_NO_Btn.click();
			}

		}
		
		}catch(Exception e)
			{	
			System.out.println("Not an offerender or Private Alert - Normal Visitor ");
			}
		}
	
	public void Change_Building(String Building_Name) {
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(select_building,Building_Name );
		//select_building.sendKeys(Building_Name);
	}
	
	
	public String getSignInVisitorAssertText(){
		String ActualText=AssertText_VisitorInformation.getText();
		return ActualText;
	}

}
