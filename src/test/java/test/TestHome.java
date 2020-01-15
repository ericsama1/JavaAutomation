package test;

import org.junit.Test;

import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;
import pages.ProductPage;


public class TestHome extends BaseTest {
	LoginData data = new LoginData();
	private Home home;
	
	public TestHome() {
		super.setup();
	}
	
	/**
	 * Test of click on an item on the list
	 */
	@Test
	public void home_ClickAProduct() {
		setUp(get_name());
		home.click_product_name(0);
		@SuppressWarnings("unused")
		ProductPage prod = new ProductPage(driver, driverWait, settings);
	}
	
	/**
	 * Test of click on all items on the list
	 */
	@Test
	public void home_ClickAllProducts() {
		setUp(get_name());
		int listSize = home.getListSize();
		for (int i = 0; i < listSize; i++) {
			home.click_product_name(i);
			ProductPage prod = new ProductPage(driver, driverWait, settings);
			prod.clickBackButton();
			home = new Home(driver, driverWait, settings);
		}
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
		home = new Home(driver, driverWait, settings);
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Test_Login.driver.close();
		Category.shutdown();
	}
}
