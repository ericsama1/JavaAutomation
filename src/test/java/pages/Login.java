package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageFactory.AbstractPageObject;


public class Login extends AbstractPageObject {

	public Login(WebDriver driver, WebDriverWait driverWait, HashMap<String, Object> settings) {
		super(driver, driverWait, settings);
	}
	
	private By byUserInput = By.id("user-name");
	private By byPasswordInput = By.id("password");
	private By byLoginButton = By.className("btn_action");
	private By byMessage = By.xpath("//h3[@data-test='error']");
	
	private WebElement userInput = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byUserInput));
	private WebElement passwordInput = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byPasswordInput));
	private WebElement loginButton = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byLoginButton));	
	
	/**
	 * Method to write an user on the user input
	 * @param user User's name
	 */
	public void writeUser(String user) {
		scroll_to(driver, userInput);
		userInput.clear();
		userInput.sendKeys(user);
		log.info(String.format("Se ingresa el usuario %s", user));
		takeScreenshot(driver);
	}
	
	/**
	 * Method to write an password on the password input
	 * @param password User's password
	 */
	public void writePassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
		log.info(String.format("Se ingresa la contraseña del usuario"));
		takeScreenshot(driver);
	}
	
	/**
	 * Method to click on the login button
	 */
	public void clickLogin() {
		loginButton.click();
		log.info(String.format("Se hace click en el botón de login"));
	}
	
	/**
	 * Method to do the login
	 * @param user User's name
	 * @param password User's password
	 */
	public void login(String user, String password) {
		writeUser(user);
		writePassword(password);
		clickLogin();
	}
	
	/**
	 * Method to compare the error text with expected message
	 * @param exceptedMessage Expected message
	 */
	public void checkMessage(String exceptedMessage) {
		WebElement message = driver.findElement(byMessage);
		String text = message.getText();
		assert text.equals(exceptedMessage): String.format("Mensaje esperado: %s, Mensaje obtenido: %s", 
															exceptedMessage, text);
		log.info(String.format("El mensaje de usuario bloqueado es el correcto"));
		takeScreenshot(driver);
	}
	
}
