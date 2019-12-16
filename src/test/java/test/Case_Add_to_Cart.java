package test;

import org.junit.Test;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;


public class Case_Add_to_Cart extends BaseTest {
	LoginData data = new LoginData();
	
	public Case_Add_to_Cart() {
		super.setup();
		Login loginPage = new Login(driver, driverWait, log);
		loginPage.login(data.get_user(), data.get_password());
	}
	
	/**
	 * Test para agregar un elemento a carrito
	 */
	@Test
	public void add_an_item() {
		Home homepage = new Home(driver, driverWait, log);
		homepage.add_item_to_cart(1);
	}
	
	@Test
	public void add_all_items() {
		Home homepage = new Home(driver, driverWait, log);
		homepage.add_all_item_to_cart();
	}
	
	@After
	public void tearDown() {
		Case_Login.driver.close();
	}
	
}
