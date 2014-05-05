package ru.arkuzmin.diplom.optimization.utils;

import org.apache.log4j.Logger;

/**
 * Логирование в UI.
 * @author ArKuzmin
 *
 */
public class UIManager {
	
	private boolean fullLog;
	
	public UIManager(boolean fullLog) {
		this.fullLog = fullLog;
	}
	
	public void fullLogToConsole(String msg) {
		if (fullLog) {
			logToConsole(msg);
		}
	}
	
	public void logToConsole(String msg) {
		Thread t = new LogThread(msg);
		t.start();
	}
	
	
	class LogThread extends Thread {
		
		private final Logger logger = Logger.getLogger(LogThread.class);
		
		private String msg;
		
		public LogThread(String msg) {
			this.msg = msg;
		}
		
		@Override
		public void run() {
			logger.debug(msg);
		}
	}
}
