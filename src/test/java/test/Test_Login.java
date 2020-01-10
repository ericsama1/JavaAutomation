package test;

import org.junit.Test;
import org.apache.log4j.Category;
import org.junit.After;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import data.LoginData;

import pages.Login;
import pages.Home;


@Epic("Epica")
@Feature("Feacture")
public class Test_Login extends BaseTest {
	LoginData data = new LoginData();
	
	public Test_Login() {
		super.setup();
	}
	
	/**
	 * Happy path
	 */ 
	@Test
	@Story("story")
	@Description("prueba_login")
	public void login_Login() {
		setUp(get_name());
		log.info("Inicio de prueba de login");
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_user(), data.get_password());
		log.info("Se finaliza el test de login");
		@SuppressWarnings("unused")
		Home home = new Home(driver, driverWait, settings);
	}
	
	/**
	 * Locked user test
	 */
	@Test
	@Story("story")
	@Description("prueba_locked")
	public void login_LockedLogin() {
		setUp(get_name());
		log.info("Inicio de prueba de login de un usuario bloqueado");
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_lockedUser(), data.get_password());
		loginPage.checkMessage(data.get_lockedMessage());
		log.info("Se finaliza el test de usuario bloqueado");
	}
	
	/**
	 * Wrong password test
	 */
	@Test
	@Story("story")
	@Description("prueba_wrong")
	public void login_WrongPassword() {
		setUp(get_name());
		log.info("Inicio de prueba de login con contraseña incorrecta");
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_user(), "HolaMundo");
		loginPage.checkMessage(data.get_wrongUserPass());
		log.info("Se finaliza el test de contraseña incorrecta");
	}

	/**
	 * Setup 
	 * @param name Path of evidence
	 */
	private void setUp(String name) {
		create_folder(name);
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Test_Login.driver.close();
		Category.shutdown();
	}
	
}
