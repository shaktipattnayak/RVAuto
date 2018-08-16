package rough;
import org.apache.log4j.Logger;




public class Logging_Example {

	public static void main(String[] args) {
	
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		APPLICATION_LOGS.debug("Hello");
		APPLICATION_LOGS.debug("We are writing in a log file");
		APPLICATION_LOGS.debug("Hello world, I am testing the log files");
	}

}
