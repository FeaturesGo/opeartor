package operator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {
	private static Logger logger = LogManager.getLogger(LoggerDemo.class);
	
	public static void main(String[] args) {
		logger.info("000000000");
		logger.debug("111111111");
		logger.trace("222222222");
		logger.error("333333333");
	}
}
