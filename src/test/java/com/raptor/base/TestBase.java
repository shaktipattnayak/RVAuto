package com.raptor.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.raptor.pages.HomePage;
import com.raptor.pages.LoginPage;
import com.raptor.util.AppZip;
import com.raptor.util.DeleteFolder;
import com.raptor.util.ErrorUtil;
import com.raptor.util.PropertyReader;
import com.raptor.util.SendAttachmentInEmail;
import com.raptor.util.TestUtil;
import com.raptor.util.Xls_Reader;

public class TestBase {
	public static Logger Application_Logs=null;
	public static Properties Config=null;
	public static WebDriver driver=null;
	public static HomePage home=null;
	public static boolean isLoggedIn = false;
	public static String uName =null; 
	public static String pwd =null;
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Test-Cases.xlsx");

	
	public void initConfiguration() throws FileNotFoundException{
		if (Config==null){
		Application_Logs = Logger.getLogger("devpinoyLogger");
		Config= new Properties();
		try{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		Config.load(fs);
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	}
	
	public void initDriver() throws IOException{
	 	//This will delete the folder where the reports are generated.
		File ReportPath;
	 	ReportPath= new File("C:\\Raptor\\Reports");
	 	DeleteFolder.deleteDir(ReportPath);
		//Initialize the driver
		if (driver==null){
		if(Config.getProperty("browser").equals("FF")){
			driver=new FirefoxDriver();
		}
		else if(Config.getProperty("browser").equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			}
		else if(Config.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			}
		
		PropertyReader propread = new PropertyReader();
	
		String UrlToLoad = propread.getBaseURL();
		System.out.println("URL being used is" + UrlToLoad);
		driver.get(UrlToLoad);
		//driver.get(Config.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		}
		
	}
	
	public void waitForPageToLoad(){
		TestUtil testutil = new TestUtil();
		testutil.waitForLoad(driver);
	}
	
	@BeforeTest(alwaysRun = true)
	public void login() throws IOException
	{
		System.out.println("Driver init starts");
		initConfiguration();
		initDriver();
		Application_Logs.debug(" :Initiated the driver and config file");
		System.out.println("Driver init ends");
		System.out.println("Login starts");
		Application_Logs.debug(" :Started Login to the application");
		uName=Config.getProperty("username");
		pwd=Config.getProperty("password");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);;
		lp.login(uName,pwd);	
		try{
			//Assert.assertEquals(driver.getTitle(), Constants.titleloginpage);
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id='menu']/div/font/b")).isDisplayed());
			}catch(Throwable e){
				System.out.println("Wrong page title found");
				ErrorUtil.addVerificationFailure(e);
			}
		Application_Logs.debug(" :Login Successfully");
		System.out.println("Login ends");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		System.out.println("Start Selecting Client");
		home.select_client(Config.getProperty("Client"));
		System.out.println("End Selecting Client");
		Application_Logs.debug(" :Selected the Client");
	}
		
	
	public HomePage gotoHomePage(){
		if(home==null){
		home = PageFactory.initElements(driver, HomePage.class);
		}
		return home;
	}
	
	@AfterTest(alwaysRun = true)
	public void logOut(){
		waitForPageToLoad();
		System.out.println("Logout starts");
		driver.findElement(By.xpath("//*[@id='ctl01_Logout']/img")).click();
		System.out.println("Logout ends");
	}
	
	@AfterSuite(alwaysRun = true)
	public void quitDriver() throws InterruptedException{
		driver.quit();
		System.out.println("Driver Quit");
	}
	
}
