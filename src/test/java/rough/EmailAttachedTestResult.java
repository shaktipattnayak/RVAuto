package rough;


import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.raptor.util.SendAttachmentInEmail;
import com.raptor.util.TestUtil;


public class EmailAttachedTestResult implements ISuiteListener {

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
		System.out.println("Start IsuiteListener for Email Attachment");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("onFinish");
		System.out.println("Ends IsuiteListener for Email Attachment");
		//TestUtil.delay(60000);
		SendAttachmentInEmail.SendAttachmentInEmail1();
		System.out.println("onFinish ends");
		
	}

	

}
