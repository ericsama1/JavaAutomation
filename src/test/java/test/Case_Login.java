package test;

import org.junit.Test;
import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;


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
		create_folder(get_name());
		log.info("Inicio de prueba de login");
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_user(), data.get_password());
		log.info("Se finaliza el test de login");
		Home home = new Home(driver, driverWait, settings);
	}
	
	/**
	 * Test de usuario bloqueado
	 */
	@Test
	public void lockedLogin() {
		create_folder(get_name());
		log.info("Inicio de prueba de login de un usuario bloqueado");
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_lockedUser(), data.get_password());
		loginPage.checkMessage(data.get_lockedMessage());
		log.info("Se finaliza el test de usuario bloqueado");
	}
	
	/**
	 * Test de contraseña incorrecto
	 */
	@Test
	public void wrongPassword() {
		create_folder(get_name());
		log.info("Inicio de prueba de login con contraseña incorrecta");
		Login loginPage = new Login(driver, driverWait, settings);
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
