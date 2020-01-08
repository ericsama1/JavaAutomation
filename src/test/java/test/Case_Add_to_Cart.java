package test;

import org.junit.Test;

import java.util.HashMap;

import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;


public class Case_Add_to_Cart extends BaseTest {
	LoginData data = new LoginData();
	
	public Case_Add_to_Cart() {
		super.setup();
	}
	
	/**
	 * Test para agregar un elemento a carrito
	 */
	@Test
	public void add_an_item() {
		create_folder(get_name());
		login(settings);
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_item_to_cart(1);
	}
	
	@Test
	public void add_all_items() {
		create_folder(get_name());
		login(settings);
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_all_item_to_cart();
	}
	
	private void login(HashMap<String, Object> settings) {
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_user(), data.get_password());
	}

	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Case_Login.driver.close();
		Category.shutdown();
	}
	
	
}
