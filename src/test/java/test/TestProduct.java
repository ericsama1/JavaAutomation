package test;

import org.junit.Test;

import org.apache.log4j.Category;
import org.junit.After;
import data.LoginData;

import pages.Login;
import pages.Home;
import pages.Product;


public class TestProduct extends BaseTest {
	LoginData data = new LoginData();
	
	public TestProduct() {
		super.setup();
	}
	
	@Test
	public void product_AddProduct() {
		create_folder(get_name());
		login();
		selectFirstProduct();
		Product product = new Product(driver, driverWait, settings);
		product.clickAddToCart();
		assert product.getCounter() == 1;
	}
	
	@Test
	public void product_RemoveProduct() {
		create_folder(get_name());
		login();
		selectFirstProduct();
		Product product = new Product(driver, driverWait, settings);
		product.clickAddToCart();
		product.clickRemove();
	}
	
	/**
	 * Method to select the first item on the list
	 */
	private void selectFirstProduct() {
		Home home = new Home(driver, driverWait, settings);
		home.click_product_name(0);
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
