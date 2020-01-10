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
	
	public TestHome() {
		super.setup();
	}
	
	/**
	 * Test of click on an item on the list
	 */
	@Test
	public void home_ClickAProduct() {
		create_folder(get_name());
		login();
		Home homepage = new Home(driver, driverWait, settings);
		homepage.click_product_name(0);
		@SuppressWarnings("unused")
		ProductPage prod = new ProductPage(driver, driverWait, settings);
	}
	
	/**
	 * Test of click on all items on the list
	 */
	@Test
	public void home_ClickAllProducts() {
		create_folder(get_name());
		login();
		Home homepage = new Home(driver, driverWait, settings);
		int listSize = homepage.getListSize();
		for (int i = 0; i < listSize; i++) {
			homepage.click_product_name(i);
			ProductPage prod = new ProductPage(driver, driverWait, settings);
			prod.clickBackButton();
			homepage = new Home(driver, driverWait, settings);
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
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Test_Login.driver.close();
		Category.shutdown();
	}
}
