package test;

import org.junit.Test;

import org.apache.log4j.Category;
import org.junit.After;
import org.junit.Assert;

import data.LoginData;

import pages.Login;
import pages.Home;
import pages.Cart;


public class TestCart extends BaseTest {
	private LoginData data = new LoginData();
	private Cart cart; 
	
	public TestCart() {
		super.setup();
	}
	
	/**
	 * Test to remove an item from the cart's item list
	 */
	@Test
	public void cart_RemoveProduct() {
		setUp(get_name());
		addAProduct();
		cart.removeItem(0);
		Assert.assertTrue(cart.getListQuantity() == 0);
	}
	
	/**
	 * Test to add all product to the cart, after that remove from the cart's
	 * items list
	 */
	@Test
	public void cart_RemoveAllProducts() {
		setUp(get_name());
		addAllProducts();
		cart.removeAllItems();
		Assert.assertTrue(cart.getListQuantity() == 0);
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
	 * Method to add a product to the cart, from the home page
	 */
	private void addAProduct() {
		Home homepage = new Home(driver, driverWait, settings);
		homepage.add_item_to_cart(0);
		homepage.clickCart();
		cart = new Cart(driver, driverWait, settings);
	}
	
	private void addAllProducts() {
		Home home = new Home(driver, driverWait, settings);
		home.add_all_item_to_cart();
		home.clickCart();
		cart = new Cart(driver, driverWait, settings);
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
