package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

public class Actions {
	
	private static final String LOGFORMAT= "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
	private static final String EXTENSION = ".log";
	private static final String LOGNAME = "logger";

	/**
	 * Method to create a new folder on the path
	 * @param path String of the folder to create
	 */
	public void createFolder(String path) {
		Path evidence_path = Paths.get(path);
		if (!Files.exists(evidence_path)) {
			File file = new File(path);
			file.mkdir();
		}
	}
	
	/**
	 * Private method to initialize the logger
	 */
	public static Logger create_log(String evidence_path){
		Logger log = Logger.getLogger(Logger.class.getName());
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern(LOGFORMAT);
		create_log_file(log, layout, evidence_path);
		create_log_console(log, layout);
		return log;
	}

	/**
	 * Method to setup the console log
	 * @param layout PatternLayout with the format to write in the log
	 */
	private static void create_log_console(Logger log, PatternLayout layout) {
		ConsoleAppender console_appender;
		console_appender = new ConsoleAppender(layout);
		log.addAppender(console_appender);
	}
	
	/**
	 * Method to create a log file in the evidence folder
	 * @param layout PatternLayout with the format to write in the log
	 * @param evidence_path Evidente folder path
	 */
	private static void create_log_file(Logger log, PatternLayout layout, String evidence_path) {
		String full_name = LOGNAME + EXTENSION;
		FileAppender file_appender;
		try {
			file_appender = new FileAppender(
					layout, String.format("%s%s", evidence_path, full_name), false);
			log.addAppender(file_appender);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
