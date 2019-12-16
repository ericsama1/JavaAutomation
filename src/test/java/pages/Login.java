package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;
import pageFactory.AbstractPageObject;


public class Login extends AbstractPageObject {

	public Login(WebDriver driver, WebDriverWait driverWait, Logger log) {
		super(driver, driverWait, log);
	}
	
	private By byUserInput = By.id("user-name");
	private By byPasswordInput = By.id("password");
	private By byLoginButton = By.xpath("//input[@value='LOGIN']");
	private By byMessage = By.xpath("//h3[@data-test='error']");
	
	private WebElement userInput = driver.findElement(byUserInput);
	private WebElement passwordInput = driver.findElement(byPasswordInput);
	private WebElement loginButton = driver.findElement(byLoginButton);	
	
	/**
	 * Metodo para escribir el usuario en el input de usuario.
	 * @param user Nombre del usuario.
	 */
	public void writeUser(String user) {
		userInput.clear();
		userInput.sendKeys(user);
		log.info(String.format("Se ingresa el usuario %s", user));
	}
	
	/**
	 * Metodo para escribir la contraseña del usuario.
	 * @param password Contraseña del usuario.
	 */
	public void writePassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
		log.info(String.format("Se ingresa la contraseña del usuario"));
	}
	
	/**
	 * Metodo para clickear sobre el boton de login.
	 */
	public void clickLogin() {
		loginButton.click();
		log.info(String.format("Se hace click en el botón de login"));
	}
	
	/**
	 * Metodo para realizar el proceso de login
	 * @param user Nombre del usuario.
	 * @param password Contraseña del usuario.
	 */
	public void login(String user, String password) {
		writeUser(user);
		writePassword(password);
		clickLogin();
	}
	
	/**
	 * Metodo para comprobar que el texto del mensaje de error es el correcto
	 * @param exceptedMessage texto esperado
	 */
	public void checkMessage(String exceptedMessage) {
		WebElement message = driver.findElement(byMessage);
		String text = message.getText();
		assert text.equals(exceptedMessage): String.format("Mensaje esperado: %s, Mensaje obtenido: %s", 
															exceptedMessage, text);
		log.info(String.format("El mensaje de usuario bloqueado es el correcto"));
	}
	
}
