package test;

import org.junit.Test;

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
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_item_to_cart(0);
		assert homepage.getCounter() == 1;
	}
	
	/**
	 * test of add all items to the cart 
	 */
	@Test
	public void add_all_items() {
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_all_item_to_cart();
		assert homepage.getCounter() == homepage.getListSize();
	}
	
	/**
	 * Test of remove an item from the cart from the home page
	 */
	@Test
	public void remove_item() {
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_item_to_cart(0);
		homepage.remove_item(0);
	}
	
	/**
	 * Method to login on the login page
	 * @param settings Hash map with the settings values
	 */
	private void login() {
		Login loginPage = new Login(driver, driverWait, settings);
		loginPage.login(data.get_user(), data.get_password());
	}
	
	/**
	 * Setup 
	 * @param name Path of evidence
	 */
	private void setUp(String name) {
		create_folder(name);
		login();
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Test_Login.driver.close();
		Category.shutdown();
	}
	
	
}
