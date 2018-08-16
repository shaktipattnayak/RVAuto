package rough;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.raptor.util.ErrorUtil;

public class SampleTest {
	@Test
	public void loginTest(){
		try
		{
			System.out.println("In Sample Login Test");
		Assert.assertEquals("A", "A");
		}catch(Exception e){
			Assert.fail();
			ErrorUtil.addVerificationFailure(e);
		}
	}
	
	@Test
	public void logoutTest(){
		try
		{
			System.out.println("In Sample Logout Test");
		Assert.assertEquals("A", "A");
		}catch(Exception e){
			Assert.fail();
			ErrorUtil.addVerificationFailure(e);
		}
	}
}
