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
	}
	
	/**
	 * Test para agregar un elemento a carrito
	 */
	@Test
	public void add_an_item() {
		String folder = create_folder(get_name());
		Login loginPage = new Login(driver, driverWait, log, folder);
		loginPage.login(data.get_user(), data.get_password());
		Home homepage = new Home(driver, driverWait, log, folder);
		homepage.add_item_to_cart(1);
	}
	
	@Test
	public void add_all_items() {
		String folder = create_folder(get_name());
		Login loginPage = new Login(driver, driverWait, log, folder);
		loginPage.login(data.get_user(), data.get_password());
		Home homepage = new Home(driver, driverWait, log, folder);
		homepage.add_all_item_to_cart();
	}
	
	@After
	public void tearDown() {
		Case_Login.driver.close();
	}
	
}
