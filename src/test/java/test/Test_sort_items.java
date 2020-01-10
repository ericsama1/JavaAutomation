package test;

import org.junit.Test;

import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;


public class Test_sort_items extends BaseTest {
	LoginData data = new LoginData();
	
	public Test_sort_items() {
		super.setup();
	}
	
	/**
	 * Test of sort method, by ascendant price
	 */
	@Test
	public void home_SortPriceAscendant() {
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.sort_by_price_ascendant();
	}
	
	/**
	 * Test of sort method, by descendant price
	 */
	@Test
	public void home_SortPriceDescendant() {
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.sort_by_price_descendant();
	}
	
	/**
	 * Test of sort method, by ascendant name
	 */
	@Test
	public void home_SortNameAscendant() {
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.sort_by_name_ascendant();
	}
	
	/**
	 * Test of sort method, by descendant name
	 */
	@Test
	public void home_SortNameDescendant() {
		setUp(get_name());
		Home homepage = new Home(driver, driverWait, settings);
		homepage.sort_by_name_descendant();
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
