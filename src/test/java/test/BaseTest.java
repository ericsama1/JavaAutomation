package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.io.IOException;



public class BaseTest {

	public static final String URL_TECHNETTS = "http://www.saucedemo.com/";
	public static final String WEB_DRIVER_PATH = "lib\\chromedriver.exe";
	public static final String WEB_DRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
//	
//	public static final String USER = "standard_user";
//	public static final String LOCKED_USER = "locked_out_user";
//	public static final String PASSWORD = "secret_sauce";
//	public static final String LOCKED_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
//	public static final String WRONG_USER_PASS = "Epic sadface: Username and password do not match any user in this service";
	
	private static final String LOG_FORMAT = "[%1$tF %1$tT] [%4$-7s] %5$s %n";
	private static final String FORMATER = "java.util.logging.SimpleFormatter.format";
	
	public static WebDriver driver;
	public static WebDriverWait driverWait;
	
	public static Logger log;
	
	public static void setup() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// System.setProperty(WEB_DRIVER_CHROME_DRIVER_PROPERTY, WEB_DRIVER_PATH);
		driver = new ChromeDriver(ops);
		driver.navigate().to(URL_TECHNETTS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driverWait = new WebDriverWait(driver, 30);
		create_log();
	}

	/**
	 * Metodo privado para generar el log
	 */
	private static void create_log(){
	    System.setProperty(FORMATER, LOG_FORMAT);
	    log = Logger.getLogger("prueba");
	    FileHandler path;
		try {
			path = new FileHandler("C:/evidence/p.log");
		    log.addHandler(path);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

	

	
	


