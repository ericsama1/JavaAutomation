package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import java.io.IOException;

import utils.SetProperties;
import utils.Actions;
import utils.Gets;


public class BaseTest {

	public static final String WEB_DRIVER_PATH = "lib\\chromedriver.exe";
	public static final String WEB_DRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public static WebDriver driver;
	public static WebDriverWait driverWait;
	
	public static Logger log = Logger.getLogger(Logger.class.getName());
	private static String log_format = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
	private static Actions action = new Actions();
	private static Gets get = new Gets();
	
	private static SetProperties properties = new SetProperties();
	
	public void setup() {
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		if (browser.equals("Firefox")) {
			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("--disable-notifications");
			driver = new FirefoxDriver(ops);
		} else {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			// System.setProperty(WEB_DRIVER_CHROME_DRIVER_PROPERTY, WEB_DRIVER_PATH);
			driver = new ChromeDriver(ops);
		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driverWait = new WebDriverWait(driver, 10);
	}
	

	/**
	 * Private method to initialize the logger
	 */
	private static void create_log(String evidence_path){
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern(log_format);
		create_log_file(layout, evidence_path);
		create_log_console(layout);
	}
	
	/**
	 * Method to setup the console log
	 * @param layout PatternLayout with the format to write in the log
	 */
	private static void create_log_console(PatternLayout layout) {
		ConsoleAppender console_appender;
		console_appender = new ConsoleAppender(layout);
		log.addAppender(console_appender);
	}
	
	/**
	 * Method to create a log file in the evidence folder
	 * @param layout PatternLayout with the format to write in the log
	 * @param evidence_path Evidente folder path
	 */
	private static void create_log_file(PatternLayout layout, String evidence_path) {
		String EXTENSION = ".log";
		String log_name = "prueba";
		String full_name = log_name + EXTENSION;
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
	 * Method to obtain the test class's name
	 * @return test class's name 
	 */
	public static String get_name() {
		String name = Thread.currentThread().getStackTrace()[2].getMethodName();
		return name;
	}
	
	/**
	 * Method to setup and create the evidence folder
	 * @param folder_name Folder's name
	 * @return full path of the evidence folder
	 */
	public static String create_folder(String folder_name) {
		String evidence_path = String.format(
			 "%s%s/%s/%s/", 
			 properties.getProperty("evidence"),
			 get.get_current_date(),
			 folder_name,
			 get.get_current_time()
		);
		action.createFolder(evidence_path);
		create_log(evidence_path);
		return evidence_path;
	}
}

