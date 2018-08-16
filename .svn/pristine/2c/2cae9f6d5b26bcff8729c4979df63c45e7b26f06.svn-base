package rough;

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

import com.raptor.pages.LoginPage;
import com.raptor.util.Constants;

public class RunTest {

	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException  {
		Properties config = new Properties();
		FileInputStream fs = new FileInputStream(Constants.Config_File_Path);
		try {
			config.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		APPLICATION_LOGS.debug(" :Started login test");
		
		WebDriver driver =null;
		if(config.getProperty("browser").equals("FF"))
			driver=new FirefoxDriver();
		else if(config.getProperty("browser").equals("IE"))
			driver=new InternetExplorerDriver();
		else if(config.getProperty("browser").equals("Chrome"))
			driver=new ChromeDriver();
		
		driver.get("http://staging.raptorware.com/vsoft/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		LoginPage lp =  PageFactory.initElements(driver, LoginPage.class);
		lp.login("sprasanna@raptortech.com", "raptor");
		/*//SignIn_VisitorPage signinvisitor = lp.login("sprasanna@raptortech.com", "raptor");
		SignIn_VisitorPage sv =null;
		//HomePage home = lp.login("sprasanna@raptortech.com", "raptor");
		APPLICATION_LOGS.debug(" :Logged in successfuly");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.select_client("vsofttestclient");
		//home.select_client("vsofttestclient");
		APPLICATION_LOGS.debug(" :Client changed successfuly");
		//SignIn_VisitorPage signinvisitorpage =home.gotoSignVisitor();
		APPLICATION_LOGS.debug(" :Logged in successfuly");
		
		//signinvisitorpage.Change_Building("fola academy 1");
		//APPLICATION_LOGS.debug(" :Building changed successfuly");
		home.gotoSignVisitor();
		sv.signin_visitor_manually("Shakti", "AutoTest1", "01/01/1990");
		sv.visitor_Signin_By_QuickFind("visitor");
		ViewVisitorPage viewvisitor = PageFactory.initElements(driver, ViewVisitorPage.class);
		//viewvisitor.gotoViewVisitor();
		APPLICATION_LOGS.debug(" :Visitor Signed In Successfully");
		viewvisitor.gotoViewVisitor();
		viewvisitor.signout_Student();
		home.gotoSearchVisitor();
		home.gotoVisitorReports();
		*/
		driver.findElement(By.xpath("//*[@id='ctl01_Logout']/img")).click();
	}

}