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

// TODO: Auto-generated Javadoc
/**
 * The Class Visitor_SignIn_Test.
 */
public class Visitor_SignIn_Test extends TestBase{
	String ExpectedText = "Visitor Information";
	
	/**
	 * Gets the sign in visitor data.
	 *
	 * @return the sign in visitor data
	 */
	@DataProvider
	public Object[][] getSignInVisitorData(){
		return TestUtil.getData("signInVisitorManually","Test Data", xls);		
		}
	
	/**
	 * Sign in visitor manually.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getSignInVisitorData",priority=1, enabled=true, groups = {"smoke"})
	public void signInVisitorManually(Hashtable<String,String> data) throws InterruptedException{
		
			Application_Logs.debug(" :Verifying if the  signInVisitorManually  test is executable");
		if(!TestUtil.isExecuatable("signInVisitorManually", xls)||data.get("RunMode").equals("N")){
			throw new SkipException("Skipping the test");
		}
		try
		{
		Application_Logs.debug(" :Started Signing In visitor By Manual Enrty");
		System.out.println("Signin visitor starts");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignIn_VisitorPage sv = home.gotoSignVisitor();
		try{
			waitForPageToLoad();
			Assert.assertEquals(sv.getSignInVisitorAssertText(),ExpectedText);
			System.out.println("Assert found"+sv.getSignInVisitorAssertText());
			}catch(Throwable e){
				System.out.println("The Visitor Information text not found");
				ErrorUtil.addVerificationFailure(e);
				TestUtil.captureScreenShot(driver, "VisitorSignInPage");
			}
		sv.signin_visitor_manually(data.get("FirstName"),data.get("LastName"),data.get("DOB"));
		System.out.println("Signin visitor ends by manuall enrty");
		}catch(Exception e){
			Assert.fail();
			//e.printStackTrace();
			ErrorUtil.addVerificationFailure(e);
		}
	}
	
	/**
	 * Gets the sign in visitor quick find data.
	 *
	 * @return the sign in visitor quick find data
	 */
	@DataProvider
	public Object[][] getSignInVisitorQuickFindData(){
		return TestUtil.getData("signInVisitorByQuickFind","Test Data", xls);		
		}
	
	/**
	 * Sign in visitor by quick find.
	 *
	 * @param data the data
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(dataProvider="getSignInVisitorQuickFindData",priority=2, enabled=true,groups = {"smoke"})
	public void signInVisitorByQuickFind(Hashtable<String,String> data) throws InterruptedException{
			
			Application_Logs.debug(" :Verifying if the signInVisitorByQuickFind test is executable");
			if(!TestUtil.isExecuatable("signInVisitorByQuickFind", xls)||data.get("RunMode").equals("N")){
				throw new SkipException("Skipping the test");//method for isExecutable
		}
		try
			{
		Application_Logs.debug(" :Started Signing In visitor By Quick Find");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignIn_VisitorPage sv = home.gotoSignVisitor();
		waitForPageToLoad();
		sv.visitor_Signin_By_QuickFind(data.get("QuickFindName"));
		}catch(Exception e){
			Assert.fail();
			//e.printStackTrace();
			ErrorUtil.addVerificationFailure(e);
		}
	}
}
