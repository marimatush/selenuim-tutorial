package log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLoggingConsole {
	private static final Logger log = LogManager.getLogger(Log4jLoggingConsole.class.getName());

	public static void main(String[] args) {
		log.debug("Debug message logged");
		log.error("Error message logged");
		log.fatal("Fatal error logged");
	}

}
