package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.io.IOException;

import utils.SetProperties;
import utils.Actions;
import utils.Gets;


public class BaseTest {

	public static final String WEB_DRIVER_PATH = "lib\\chromedriver.exe";
	public static final String WEB_DRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	private static final String LOG_FORMAT = "[%1$tF %1$tT] [%4$-7s] %5$s %n";
	private static final String FORMATER = "java.util.logging.SimpleFormatter.format";
	
	public static WebDriver driver;
	public static WebDriverWait driverWait;
	
	public static Logger log;
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
	 * Metodo privado para generar el log
	 */
	private static void create_log(String evidence_path){
		String EXTENTION = ".log"; 
	    System.setProperty(FORMATER, LOG_FORMAT);
	    log = Logger.getLogger("prueba");
	    FileHandler path;
	    String log_name = "log";
		try {
			path = new FileHandler(String.format(
					"%s%s%s", evidence_path, log_name, EXTENTION
			));
		    log.addHandler(path);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para obtener el nombre del metodo ejecutado
	 * @return Nombre del metodo 
	 */
	public static String get_name() {
		String name = Thread.currentThread().getStackTrace()[2].getMethodName();
		return name;
	}
	
	public static String create_folder(String folder_name) {
		String evidence_path = String.format(
			 "%s%s/%s/%s", 
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

	

	
	


