package test;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import utils.SetProperties;
import utils.Actions;
import utils.Gets;


public class BaseTest {

//	public static final String WEB_DRIVER_PATH = "lib\\chromedriver.exe";
//	public static final String WEB_DRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public static WebDriver driver;
	public static WebDriverWait driverWait;
	
	public static Logger log = Logger.getLogger(Logger.class.getName());
	private static Actions action = new Actions();
	private static Gets get = new Gets();
	
	public static HashMap<String, Object> settings = new HashMap<String, Object>();
	
	private static SetProperties properties = new SetProperties();
	
	// Private constants
	
	private static final String FIREFOX = "Firefox";
	private static final String URL = "url";
	private static final String BROWSER = "browser";
	private static final String SCREENSHOT = "screenshot";
	private static final String LOG = "log";
	private static final String FOLDER = "folder";
	private static final String EVIDENCE = "evidence";
	
	public void setup() {
		String url = properties.getProperty(URL);
		String browser = properties.getProperty(BROWSER);
		if (browser.equals(FIREFOX)) {
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
		settingScreenshot();
	}
	
	/**
	 * Method to set if you want to take screenshot or not
	 */
	private static void settingScreenshot() {
		String getScreenshot = properties.getProperty(SCREENSHOT);
		boolean screenshot;
		if (getScreenshot.equals("true")) {
			screenshot = true;
		} else {
			screenshot = false;
		}
		settings.put(SCREENSHOT, screenshot);		
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
	public static void create_folder(String folder_name) {
		String evidence_path = String.format(
			 "%s%s/%s/%s/", 
			 properties.getProperty(EVIDENCE),
			 get.get_current_date(),
			 folder_name,
			 get.get_current_time()
		);
		action.createFolder(evidence_path);
		log = Actions.create_log(evidence_path);
		settings.put(FOLDER, evidence_path);
		settings.put(LOG, log);
	}
}

