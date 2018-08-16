package rough;

import java.util.Hashtable;

import com.raptor.util.TestUtil;
import com.raptor.util.Xls_Reader;

public class ReadData {


	public static void main(String[] args) {
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("Project", "Raptor");
		/*System.out.println(table.get("Project"));
		System.out.println(table.get("Project1"));*/
		Xls_Reader xls = new Xls_Reader("D://Project//Raptor//Raptor_Automation//Jar Files//Test Cases.xlsx");
		//TestUtil.getData("signInVisitorManually", xls);
		//TestUtil.getData("DemoTEst", xls);
		//TestUtil.getOffenderData("sexOffenderAlertTest", "Offender Test", xls);
		TestUtil.getData("advancedSearch_Visitor","Test Data", xls);
		System.out.println();
	}

}
