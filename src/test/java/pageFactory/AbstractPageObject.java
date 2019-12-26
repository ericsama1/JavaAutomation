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
import java.util.logging.Logger;

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
	 * Metodo para realizar un screenshot y guardarlo en la carpeta definida
	 * @param driver Driver del navegador
	 * @param path Path de la carpeta en donde se guarda las imagines
	 */
	public void takeScreenshot(WebDriver driver) {
		// Se realiza la captura de pantalla
		TakesScreenshot screen = ((TakesScreenshot)driver);
		// Se guarda en una variable la iamgen
		File screenfile = screen.getScreenshotAs(OutputType.FILE);
		// Se crea el string de la ubicacion que se va a guradar la imagen
		String file_name = String.format("%s%s.png", folder, gets.get_current_time());
		// Se crea un archivo vacio en la ubicacion
		File destFile = new File(file_name);
		try {
			// Se intenta copiar la imagen guardada en memoria a un archivo en el disco
			FileUtils.copyFile(screenfile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sleep(1);
	}
	
	
	/**
	 * Metodo para realizar un scroll hacia un elemento de la pagina
	 * @param driver Driver del navegador 
	 * @param element Elemento ubicado en el DOM de la pagina
	 */
	public static void scroll_to(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(SCROLL_SCRIPT, element);
	}

}
