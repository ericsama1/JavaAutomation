package pageFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.log4j.Logger;

import utils.Gets;


public class AbstractPageObject {
	
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	protected Logger log;
	protected String folder;
	private static String SCROLL_SCRIPT = "arguments[0].scrollIntoView({block:'center'});"; 
	private Gets gets = new Gets();


	public AbstractPageObject(WebDriver driver, WebDriverWait driverWait, Logger log, String folder){
		this.driver = driver;
		this.driverWait = driverWait;
		this.log = log;
		this.folder = folder;
		PageFactory.initElements(driver, this);
		takeScreenshot(driver);
	}
	
	//----------------- TIEMPO DE ESPERA -------------------//
	
	public static void sleep(double seconds) {
	    try {
	        Thread.sleep((long) seconds * 1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    };
	}
	
	/**
	 * Method to take a screenshot and save in the evidence folder
	 * @param driver browser's driver
	 */
	public void takeScreenshot(WebDriver driver) {
		// Take a screenshot
		TakesScreenshot screen = ((TakesScreenshot)driver);
		// Create a file variable with the screenshot
		File screenfile = screen.getScreenshotAs(OutputType.FILE);
		// Create the string where we save the screenshot, with the assigned name
		String file_name = String.format("%s%s.png", folder, gets.get_current_time());
		// Create the empty file where we save the file
		File destFile = new File(file_name);
		try {
			// try to copy the screenshot file to the empty file
			FileUtils.copyFile(screenfile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sleep(1);
	}
	
	
	/**
	 * Method to scroll to an element in the browser
	 * @param driver browser's driver 
	 * @param element Webelement from the webpage
	 */
	public static void scroll_to(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(SCROLL_SCRIPT, element);
	}

}
