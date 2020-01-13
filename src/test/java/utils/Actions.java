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
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class Actions {
	
	private static final String LOGFORMAT= "%d{yyyy-MM-dd HH:mm:ss} %-5p %-20C{1}:%L - %m%n";
	private static final String EXTENSION = ".log";
	private static final String LOGNAME = "logger";

	/**
	 * Method to create a new folder on the path
	 * @param path String of the folder to create
	 */
	public void createFolder(String path) {
		// Set the evidence path
		Path evidence_path = Paths.get(path);
		// If the folder don't exist, then make the folder
		if (!Files.exists(evidence_path)) {
			File file = new File(path);
			// Make the folder
			file.mkdir();
		}
	}
	
	/**
	 * Private method to initialize the logger
	 * @return Return the created log file
	 */
	public static Logger create_log(String evidence_path){
		// Create logger variable
		Logger log = Logger.getLogger(Logger.class.getName());
		// Create a layout 
		PatternLayout layout = new PatternLayout();
		// Set the layout format
		layout.setConversionPattern(LOGFORMAT);
		// Create log file on the evidence path
		create_log_file(log, layout, evidence_path);
		// Show the log on the console
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
	
	/**
	 * Method to compare two text. If the text contains expected text
	 * @param expected_text
	 * @param text
	 */
	public void compare_text(String expected_text, String text, Logger log) {
		try {
			// Compare if the text contains expected text
			Assert.assertTrue(text.contains(expected_text));
			log.info("El texto esperado y el texto mostrados, son iguales");
		} catch (AssertionError e) {
			// If the text don't contains the expected text, then write on the log an error,
			// and test fail
			log.error(String.format("Texto esperado: %s, Texto mostrado: %s", expected_text, text));
			Assert.fail(e.toString());
		}
	}
	
	/**
	 * Method to compare an element's text contains the expected text
	 * @param expected_text Expected text
	 * @param element WebElement to get the text to compare
	 */
	public void compare_text(String expected_text, WebElement element, Logger log) {
		String text = element.getText();
		compare_text(expected_text, text, log);
	}
}
