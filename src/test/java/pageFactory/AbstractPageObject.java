package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;


public class AbstractPageObject {
	
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	protected Logger log;


	public AbstractPageObject(WebDriver driver, WebDriverWait driverWait, Logger log){
	this.driver = driver;
	this.driverWait = driverWait;
	this.log = log;
	PageFactory.initElements(driver, this);
	}
	
	//----------------- TIEMPO DE ESPERA -------------------//
	
	public static void sleep() {
	    try {
	        Thread.sleep(4000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    };
	}

}
