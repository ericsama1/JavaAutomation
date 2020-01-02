package test;

import org.junit.Test;
import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;


public class Case_Login extends BaseTest {
	LoginData data = new LoginData();
	
	public Case_Login() {
		super.setup();
	}
	
	/**
	 * Test de login, camino feliz
	 */
	@Test
	public void login() {
		String folder = create_folder(get_name());
		log.info("Inicio de prueba de login");
		Login loginPage = new Login(driver, driverWait, log, folder);
		loginPage.login(data.get_user(), data.get_password());
		log.info("Se finaliza el test de login");
		loginPage.takeScreenshot(driver);
	}
	
	/**
	 * Test de usuario bloqueado
	 */
	@Test
	public void lockedLogin() {
		String folder = create_folder(get_name());
		log.info("Inicio de prueba de login de un usuario bloqueado");
		Login loginPage = new Login(driver, driverWait, log, folder);
		loginPage.login(data.get_lockedUser(), data.get_password());
		loginPage.checkMessage(data.get_lockedMessage());
		log.info("Se finaliza el test de usuario bloqueado");
	}
	
	/**
	 * Test de contraseña incorrecto
	 */
	@Test
	public void wrongPassword() {
		String folder = create_folder(get_name());
		log.info("Inicio de prueba de login con contraseña incorrecta");
		Login loginPage = new Login(driver, driverWait, log, folder);
		loginPage.login(data.get_user(), "HolaMundo");
		loginPage.checkMessage(data.get_wrongUserPass());
		log.info("Se finaliza el test de contraseña incorrecta");
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Case_Login.driver.close();
		Category.shutdown();
	}
	
}
