package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


//import TestUtil.TakeScreenShot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportPractice2 {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	@Test(priority=1)
	public void verifyTitle2(){
		reports=new ExtentReports("D:\\Project\\vSoftAutomation\\Reports\\AdvanceReport.html");
		
		logger= reports.startTest("Verify Title Test");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://raptor6-staging.cloudapp.net/User/Login");
	    logger.log(LogStatus.INFO, "Application is up and running");
		
		String pagetitle=driver.getTitle();
		Assert.assertTrue(pagetitle.contains("Login"));
		logger.log(LogStatus.PASS, "Title Verified");
	}
	
	@Test(priority=2)
	public void verifyURL2(){
		logger= reports.startTest("Verify Login Test");
		driver.findElement(By.id("Username")).sendKeys("raptortrigentqa+shakti_DA@gmail.com ");
		driver.findElement(By.id("Password")).sendKeys("Monday12!");
		driver.findElement(By.xpath("//*[@id='raptorLogin']/div[2]/div/div/div/div/div[1]/form/button")).click();
		logger.log(LogStatus.INFO, "Uer logged In successfully");
		
		Assert.assertEquals(driver.getTitle(), "Dashboard");
		logger.log(LogStatus.PASS, "Dashboard Title verified login Successfull");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String screenshot_path=TakeScreenShot.captureScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL,"Test verification", screenshot_path);
			//logger.log(LogStatus.FAIL, screenshot_path);
		}
		reports.endTest(logger);
		reports.flush();
		
		//driver.get("D:\\Project\\vSoftAutomation\\Reports\\AdvanceReport.html");
		
	}
	@AfterTest
	public void endTest(){
		//reports.endTest(logger);
		//reports.flush();
		
		driver.get("D:\\Project\\vSoftAutomation\\Reports\\AdvanceReport.html");
	}

}
