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
	private Home home;
	
	public TestCart() {
		super.setup();
	}
	
	/**
	 * Test to show the list from the cart page
	 */
	@Test
	public void cart_ProductsList() {
		setUp(get_name());
		addAllProducts();
	}
	
	/**
	 * Test to show the cart page when we don't add any product to 
	 * the cart
	 */
	@Test
	public void cart_EmptyCart() {
		setUp(get_name());
		home = new Home(driver, driverWait, settings);
		home.clickCart();
		cart = new Cart(driver, driverWait, settings);
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
	 * Test to add all product to the cart, after that remove 
	 * from the cart's items list
	 */
	@Test
	public void cart_RemoveAllProducts() {
		setUp(get_name());
		addAllProducts();
		cart.removeAllItems();
		Assert.assertTrue(cart.getListQuantity() == 0);
	}
	
	/**
	 * Test to check the continue shopping button behavior
	 */
	@Test
	public void cart_ContinueButton() {
		setUp(get_name());
		home = new Home(driver, driverWait, settings);
		home.clickCart();
		cart = new Cart(driver, driverWait, settings);
		cart.clickContinue();
		home = new Home(driver, driverWait, settings);
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
		home = new Home(driver, driverWait, settings);
		home.add_item_to_cart(0);
		home.clickCart();
		cart = new Cart(driver, driverWait, settings);
	}
	
	/**
	 * Method to add all product to the cart, from the home
	 * page
	 */
	private void addAllProducts() {
		home = new Home(driver, driverWait, settings);
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
