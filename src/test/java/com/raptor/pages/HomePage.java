package com.raptor.pages;

//Test
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.raptor.base.TestBase;
import com.raptor.util.Constants;
import com.raptor.util.TestUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePage.
 */
public class HomePage extends TestBase {
	
	/** The driver. */
	WebDriver driver;
	
	/** The client_selection_dropdown. */
	//Client Selection Drop down
	@FindBy(xpath=Constants.clientselectiondropdown)
	public WebElement client_selection_dropdown;
	
	/** The visitor. */
	//Visitor Tab
	@FindBy(id="ctl01_I1")
	public WebElement visitor;
	
	/** The signin_visitor. */
	@FindBy(xpath=Constants.signinvisotor)
	public WebElement signin_visitor;
	
	/** The view_visitor. */
	@FindBy(xpath="//li[@id='ctl01_HL2']/a")
	public WebElement view_visitor;
	
	/** The Assert text_viewvisitor. */
	@FindBy(id="IMG1")
	public WebElement AssertText_viewvisitor;
	
	/** The search_visitor. */
	@FindBy(xpath="//li[@id='ctl01_HL3']/a")
	public WebElement search_visitor;
	
	/** The visitor_reports. */
	@FindBy(xpath=Constants.visitorreports)
	public WebElement visitor_reports;
	
	/** The student. */
	//Student Tab
	@FindBy(xpath=Constants.studenttab)
	public WebElement student;
	
	/** The signinstudent. */
	@FindBy(xpath=Constants.signinstudent)
	public WebElement signinstudent;
	
	/** The signoutstudent. */
	@FindBy(xpath=Constants.signoutstudent)
	public WebElement signoutstudent;
	
	/** The searchstudent. */
	@FindBy(xpath=Constants.searchstudent)
	public WebElement searchstudent;
	
	/** The studentreports. */
	@FindBy(xpath=Constants.studentreports)
	public WebElement studentreports;
	
	
	/** The faculty. */
	//Faculty Tab
	@FindBy(xpath=Constants.facultytab)
	public WebElement faculty;
	
	/** The signin faculty. */
	@FindBy(xpath=Constants.signinfaculty)
	public WebElement signinfaculty;
	
	/** The view faculty. */
	@FindBy(xpath=Constants.viewfaculty)
	public WebElement viewfaculty;
	
	/** The search faculty. */
	@FindBy(xpath=Constants.searchfaculty)
	public WebElement searchfaculty;
	
	/** The faculty reports. */
	@FindBy(xpath=Constants.facultyreports)
	public WebElement facultyreports;
	
	/** The volunteer. */
	//Volunteer tab
	@FindBy(xpath=Constants.volunteertab)
	public WebElement volunteer;
	
	@FindBy(xpath="//li[@id='ctl01_HL13']/a")
	public WebElement SignInVolunteer;
	
	@FindBy(xpath="//li[@id='ctl01_HL14']/a")
	public WebElement CreateVolunteer;
	
	@FindBy(xpath="//li[@id='ctl01_HL15']/a")
	public WebElement ViewVolunteer;
	
	@FindBy(xpath="//li[@id='ctl01_HL16']/a")
	public WebElement SearchVolunteer;
	
	@FindBy(xpath="//li[@id='ctl01_HL17']/a")
	public WebElement VolunteerReports;
	/**
	 * Instantiates a new home page.
	 *
	 * @param dr the dr
	 */
	public HomePage(WebDriver dr){
		driver = dr;
	}
	
	
	/**
	 * Select_client.
	 *
	 * @param client_name the client_name
	 * @return the home page
	 */
	//Method to select a client in home page
	public HomePage select_client(String client_name){
		waitForPageToLoad();
		TestUtil.selectOptionByVisibleText(client_selection_dropdown, client_name);
		//client_selection_dropdown.sendKeys(client_name);
		return PageFactory.initElements(driver, HomePage.class);
	}

	
	/**
	 * Goto sign visitor.
	 *
	 * @return the sign in_ visitor page
	 */
	public SignIn_VisitorPage gotoSignVisitor()
	{
		waitForPageToLoad();
		visitor.click();
		TestUtil.delay(1000);
		signin_visitor.click();
		TestUtil.delay(1000);
		return PageFactory.initElements(driver, SignIn_VisitorPage.class);	
	}
	
	//Method to navigate View Visitor page

	/**
	 * Goto view visitor.
	 *
	 * @return the view visitor page
	 * @throws InterruptedException the interrupted exception
	 */
	public ViewVisitorPage gotoViewVisitor() throws InterruptedException{
		waitForPageToLoad();
		visitor.click();
		TestUtil.delay(1000);
		view_visitor.click();
		TestUtil.delay(1000);
		return PageFactory.initElements(driver, ViewVisitorPage.class);
	}
	
	/**
	 * Goto search visitor.
	 *
	 * @return the search_ visitor page
	 */
	//Methods to navigate Search Visitor page
	public Search_VisitorPage gotoSearchVisitor(){
		waitForPageToLoad();
		TestUtil.delay(1000);
		visitor.click();
		TestUtil.delay(2000);
		search_visitor.click();
		Search_VisitorPage searchvisitor= PageFactory.initElements(driver, Search_VisitorPage.class);
		return searchvisitor;
	}
	
	/**
	 * Goto visitor reports.
	 *
	 * @return the visitor report page
	 */
	//Methods to navigate Visitor Reports page
	public VisitorReportPage gotoVisitorReports(){
		waitForPageToLoad();
		TestUtil.delay(1000);
		visitor.click();
		TestUtil.delay(2000);
		visitor_reports.click();
		return PageFactory.initElements(driver, VisitorReportPage.class);
	}
	
	/**
	 * Goto sign in student.
	 *
	 * @return the sign in student page
	 */
	//Methods to navigate Sign In Student page
	public SignInStudentPage gotoSignInStudent(){
		waitForPageToLoad();
		TestUtil.delay(1000);
		student.click();
		TestUtil.delay(4000);
		signinstudent.click();
		return PageFactory.initElements(driver, SignInStudentPage.class);
	}
	
	/**
	 * Goto sign out student.
	 *
	 * @return the sign out student page
	 */
	//Methods to navigate Sign Out Student page
	public SignOutStudentPage gotoSignOutStudent(){
		waitForPageToLoad();
		TestUtil.delay(1000);
		student.click();
		TestUtil.delay(1000);
		signoutstudent.click();
		return PageFactory.initElements(driver, SignOutStudentPage.class);
	}
	
	/**
	 * Goto search student.
	 *
	 * @return the sign in student page
	 */
	//Methods to navigate Search Student page
	public SearchStudentPage gotoSearchStudent(){
		waitForPageToLoad();
		TestUtil.delay(1000);
		student.click();
		TestUtil.delay(1000);
		searchstudent.click();
		return PageFactory.initElements(driver, SearchStudentPage.class);
	}
	
	/**
	 * Goto student reports.
	 *
	 * @return the sign in student page
	 */
	//Methods to navigate Student Reports page
		public StudentReportPage gotoStudentReports(){
			waitForPageToLoad();
			TestUtil.delay(1000);
			student.click();
			TestUtil.delay(1000);
			studentreports.click();
			return PageFactory.initElements(driver, StudentReportPage.class);
		}
		
	
	/**
	 * Goto Sign In faculty.
	 *
	 * @return the sign in_ faculty page
	 */
	public SignIn_FacultyPage gotoSignFaculty(){
		waitForPageToLoad();
		faculty.click();
		TestUtil.delay(1000);
		signinfaculty.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, SignIn_FacultyPage.class);
	}
	
	/**
	 * Goto view faculty.
	 *
	 * @return the view faculty page
	 */
	public ViewFacultyPage gotoViewFaculty(){
		waitForPageToLoad();
		TestUtil.delay(2000);
		faculty.click();
		TestUtil.delay(3000);
		viewfaculty.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, ViewFacultyPage.class);
	}
	
	/**
	 * Goto search faculty.
	 *
	 * @return the search faculty page
	 */
	public SearchFacultyPage gotoSearchFaculty(){
		waitForPageToLoad();
		faculty.click();
		TestUtil.delay(2000);
		searchfaculty.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, SearchFacultyPage.class);
	}
	
	/**
	 * Goto faculty reports.
	 *
	 * @return the faculty reports page
	 */
	public FacultyReportsPage gotoFacultyRepotrs(){
		waitForPageToLoad();
		faculty.click();
		TestUtil.delay(2000);
		facultyreports.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, FacultyReportsPage.class);
	}
	
	/**
	 * Goto volunteer.
	 *
	 * @return the sign in volunteer page
	 */
	public SignInVolunteerPage gotoSignInVolunteer(){
		waitForPageToLoad();
		volunteer.click();
		TestUtil.delay(2000);
		SignInVolunteer.click();
		TestUtil.delay(2000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, SignInVolunteerPage.class);
	}

	
	public CreateVolunteerPage gotoCreateVolunteer(){
		waitForPageToLoad();
		volunteer.click();
		TestUtil.delay(2000);
		CreateVolunteer.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, CreateVolunteerPage.class);
	}
	
	public ViewVolunteerPage gotoViewVolunteer(){
		waitForPageToLoad();
		volunteer.click();
		TestUtil.delay(1000);
		ViewVolunteer.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, ViewVolunteerPage.class);
	}
	
	public SearchVolunteerPage gotoSearchVolunteer(){
		waitForPageToLoad();
		volunteer.click();
		TestUtil.delay(1000);
		SearchVolunteer.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, SearchVolunteerPage.class);
	}
	
	public VolunteerReportsPage gotoVolunteerReports(){
		waitForPageToLoad();
		volunteer.click();
		TestUtil.delay(1000);
		VolunteerReports.click();
		TestUtil.delay(1000);
		waitForPageToLoad();
		return PageFactory.initElements(driver, VolunteerReportsPage.class);
	}
}
