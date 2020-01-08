package test;

import org.junit.Test;

import java.util.HashMap;

import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;


public class Test_Add_to_Cart extends BaseTest {
	LoginData data = new LoginData();
	
	public Test_Add_to_Cart() {
		super.setup();
	}
	
	/**
	 * Test of add an item to the cart 
	 */
	@Test
	public void add_an_item() {
		create_folder(get_name());
		login(settings);
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_item_to_cart(0);
	}
	
	/**
	 * test of add all items to the cart 
	 */
	@Test
	public void add_all_items() {
		create_folder(get_name());
		login(settings);
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_all_item_to_cart();
	}
	
	/**
	 * Method to login on the login page
	 * @param settings Hashmap with the settings values
	 */
	private void login(HashMap<String, Object> settings) {
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_user(), data.get_password());
	}

	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Test_Login.driver.close();
		Category.shutdown();
	}
	
	
}
