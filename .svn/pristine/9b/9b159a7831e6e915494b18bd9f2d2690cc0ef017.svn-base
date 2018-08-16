package com.raptor.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.raptor.base.TestBase;
import com.raptor.pages.HomePage;
import com.raptor.pages.ViewVisitorPage;
import com.raptor.util.ErrorUtil;
import com.raptor.util.TestUtil;

public class View_Visitor_Test extends TestBase{
	@Test(enabled=true, groups = {"smoke"})
	public void signOutVisitor() throws InterruptedException{
		if(!TestUtil.isExecuatable("signOutVisitor", xls)){
			throw new SkipException("Skipping the signOutVisitor test");
		}
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		waitForPageToLoad();
		ViewVisitorPage viewvisitor = home.gotoViewVisitor();
		try{
			waitForPageToLoad();
			Assert.assertEquals(viewvisitor.isSignOutButtonDisplayed(),true);
			System.out.println("Sign Out button found In View Visitor Page");
			}catch(Throwable e){
				System.out.println("The Sign Out button not found");
				ErrorUtil.addVerificationFailure(e);
				TestUtil.captureScreenShot(driver, "ViewVisitorPage");
			}
		viewvisitor.signout_Visitor();
	}
}
