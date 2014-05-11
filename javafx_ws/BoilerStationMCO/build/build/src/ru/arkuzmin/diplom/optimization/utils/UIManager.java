package ru.arkuzmin.diplom.optimization.utils;

import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

import org.apache.log4j.Logger;

/**
 * Логирование в UI.
 * @author ArKuzmin
 *
 */
public class UIManager {
	
	private boolean fullLog;
	
	private TextArea logArea;
	private ProgressIndicator progress;
	
	private UILogThread uiTread;
	private UIProgressThread uiProgress;
	
	public UIManager(boolean fullLog) {
		this.fullLog = fullLog;
	}
	
	public double currProgress() {
		if (progress != null) {
			return progress.getProgress();
		} else {
			return 0;
		}
	}
	
	public void initLogArea(TextArea logArea) {
		this.logArea = logArea;
	}
	
	public void initProgress(ProgressIndicator progress) {
		this.progress = progress;
	}
	
	public void setProgress(double value) {
		if (progress == null) {
			return;
		}
		if (uiProgress == null) {
			uiProgress = new UIProgressThread(progress);
			uiProgress.setProgress(value);
			uiProgress.start();
		} else {
			uiProgress.setProgress(value);
		}
	}
	
	public void fullLogToUI(String msg) {
		if (logArea == null) {
			return;
		}
		if (fullLog) {
			logToUI(msg);
		}
	}
	
	public void allDone() {
		loggingDone();
		progressDone();
	}
	
	public void loggingDone() {
		if (uiTread != null && uiTread.isAlive()) {
			uiTread.done();
		}
	}
	
	public void progressDone() {
		if (uiProgress != null && uiProgress.isAlive()) {
			uiProgress.done();
		}
	}
	
	public void logToUI(String msg) {
		if (logArea == null) {
			return;
		}
		if (uiTread == null) {
			uiTread = new UILogThread(logArea);
			uiTread.addMsg(msg);
			uiTread.start();
		} else {
			uiTread.addMsg(msg);
		}
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
	
	/**
	 * Отображение прогресса в интерфейсе.
	 * @author ArKuzmin
	 *
	 */
	class UIProgressThread extends Thread {
		
		private boolean done = false;
		private double value;
		private ProgressIndicator progress;
		
		public UIProgressThread(ProgressIndicator progress) {
			this.progress = progress;
		}
		
		public void setProgress(double value) {
			this.value = value;
		}
		
		public void done() {
			this.done = true;
		}
		
		@Override
		public void run() {
			while (!done) {
				synchronized (progress) {
					progress.setProgress(value);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (progress.getProgress() != 1) {
				synchronized (progress) {
					progress.setProgress(1);
				}
			}
		}
	}
	
	/**
	 * Осуществляет логирование в интерфейс.
	 * @author ArKuzmin
	 *
	 */
	class UILogThread extends Thread {
		
		private TextArea logArea;
		private Queue<String> queue;
		
		private boolean done = false;
		
		public void addMsg(String msg) {
			synchronized (queue) {
				this.queue.add(msg);
			}
		}
		
		public UILogThread(TextArea logArea) {
			this.logArea = logArea;
			this.queue = new LinkedList<String>();
		}
		
		public void done() {
			this.done = true;
		}
		
		@Override
		public void run() {
			while (!done) {
				if (logArea != null && !queue.isEmpty()) {
					synchronized (logArea) {
						String msg = queue.poll();
						if (msg != null) {
							logArea.appendText(msg + "\n");
							try {
								sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			if (logArea != null && !queue.isEmpty()) {
				synchronized (logArea) {
					while (!queue.isEmpty()) {
						String msg = queue.poll();
						if (msg != null) {
							logArea.appendText(msg + "\n");
							try {
								sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
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
