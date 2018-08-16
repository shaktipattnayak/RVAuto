package com.raptor.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.SignIn_VisitorPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class SexOffenderAlertTest extends TestBase{
	String expectedText="IS THIS A MATCH?";
	
	
	@DataProvider
	public Object[][] getOffenderData(){
		return TestUtil.getData("sexOffenderAlertTest","Offender Test", xls);
		}
	@Test(dataProvider="getOffenderData",enabled=true)
	public void signInVisitorManually(Hashtable<String,String> data) throws InterruptedException{
		String rNum = null;
		Application_Logs.debug(" :Verifying if the sexOffenderAlertTest test is executable");
		if(!TestUtil.isExecuatable("sexOffenderAlertTest", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the test");
		}
		try
		{
		Application_Logs.debug(" :Started Signing In A Offender Information By Manual Enrty");
		//System.out.println("Signin visitor starts");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignIn_VisitorPage sv = home.gotoSignVisitor();
		sv.signin_visitor_manually(data.get("FirstName"),data.get("LastName"),data.get("DOB"));
		rNum = data.get("RowNum");
		waitForPageToLoad();
		if(driver.getPageSource().contains(expectedText)){
			
			//Assert.assertEquals(driver.getPageSource().contains(expectedText), expectedText);
			Assert.assertTrue(driver.getPageSource().contains(expectedText));
			System.out.println("The Alert Page is displayed for the offender : "+data.get("FirstName")+" "+data.get("LastName")+" "+data.get("DOB"));
			Application_Logs.debug("The Alert Page is displayed for the offender : "+data.get("FirstName")+" "+data.get("LastName")+" "+data.get("DOB"));
			xls.setCellData("Offender Test", "RESULT", Integer.parseInt(rNum), "PASS");
			
			}else{
			System.out.println("The Alert Page is not displayed for the offender : "+data.get("FirstName")+" "+data.get("LastName")+" "+data.get("DOB"));
			System.out.println();
			Application_Logs.debug("The Alert Page is not displayed for the offender : "+data.get("FirstName")+" "+data.get("LastName")+" "+data.get("DOB"));
			xls.setCellData("Offender Test", "RESULT", Integer.parseInt(rNum), "FAIL");
			Assert.fail();
		}
		}catch(Exception e){
			//Assert.fail();
			/*xls.setCellData("Offender Test", "RESULT", Integer.parseInt(rNum), "FAIL");
			System.out.println("The Alert Page is not displayed for the offender : "+data.get("FirstName")+" "+data.get("LastName")+" "+data.get("DOB"));
			System.out.println();
			Application_Logs.debug("The Alert Page is not displayed for the offender : "+data.get("FirstName")+" "+data.get("LastName")+" "+data.get("DOB"));
			xls.setCellData("Offender Test", "RESULT", Integer.parseInt(rNum), "FAIL");*/
			ErrorUtil.addVerificationFailure(e);
			//e.printStackTrace();
			
		}
		
	}
	
	
	
}
