package com.raptor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.raptor.util.Constants;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(xpath=Constants.username)
	public WebElement username;
	
	
	@FindBy(xpath=Constants.fakepassword)
	public WebElement fakepassword;
	
	@FindBy(xpath=Constants.password)
	public WebElement password;
	
	@FindBy(xpath=Constants.loginbutton)
	public WebElement login_btn;
	
	public LoginPage(WebDriver dr){
		driver = dr;		
	}
	
	 public HomePage login(String Uname, String Pwd){
		/*try{
		Assert.assertEquals(driver.getTitle(), Constants.titleloginpage);
		}catch(Throwable e){
			System.out.println("Wrong page title found");
			ErrorUtil.addVerificationFailure(e);
		}*/
		username.sendKeys(Uname);
		fakepassword.sendKeys("");
		password.sendKeys(Pwd);
		login_btn.click();	
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		return home;	
	}
	
}
