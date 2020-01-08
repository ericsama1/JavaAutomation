package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Header;

public class Checkout extends Header {

	public Checkout(WebDriver driver, WebDriverWait driverWait, HashMap<String, Object> settings) {
		super(driver, driverWait, settings);
	}
	
	private By byFirstName = By.id("first-name");
	private By byLastName = By.id("last-name");
	private By byPostalCode = By.id("postal-code");
	private By byCancel = By.xpath("//a[contains(text(),'CANCEL')]");
	private By byContinue = By.xpath("//input[contains(text(),'CONTINUE')]");
	
	private WebElement firstName = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byFirstName));
	private WebElement lastName = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byLastName));
	private WebElement postalCode = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byPostalCode));
	private WebElement cancelButton = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byCancel));
	private WebElement continueButton = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byContinue));
	
	/**
	 * Method to write a name in the first name's input
	 * @param name Name to write in the input
	 */
	public void writeFirstName(String name) {
		firstName.sendKeys(name);
		log.info(String.format("Se ingresa el nombre %s en el input de first name", name));
		takeScreenshot(driver);
	}
	
	/**
	 * Method to write a name in the last name's input
	 * @param name Name to write
	 */
	public void writeLastName(String name) {
		lastName.sendKeys(name);
		log.info(String.format("Se ingresa el apellido %s en el input de last name", name));
		takeScreenshot(driver);
	}
	
	/**
	 * Method to write a code in the postal code's input
	 * @param code Code to write in the input
	 */
	public void writePostalCode(String code) {
		postalCode.sendKeys(code);
		log.info(String.format("Se ingresa el código postal %s en el input de postal code", code));
		takeScreenshot(driver);
	}
	
	/**
	 * Method to do a click on the cancel button	
	 */
	public void clickCancel() {
		cancelButton.click();
		log.info("Se hace click sobre el botón cancelar");
	}
	
	/**
	 * Method to do a click on the confirm button
	 */
	public void clickContinue() {
		continueButton.click();
		log.info("Se hace click sobre el botón continuar");
	}
}
