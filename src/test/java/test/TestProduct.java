package test;

import org.junit.Test;

import org.apache.log4j.Category;
import org.junit.After;

import data.LoginData;
import data.Products;

import pages.Login;
import pages.Home;
import pages.ProductPage;

import utils.Actions;


public class TestProduct extends BaseTest {
	private LoginData data = new LoginData();
	private Actions actions = new Actions();
	private Products products = new Products();
	
	public TestProduct() {
		super.setup();
	}
	
	@Test
	public void product_AddProduct() {
		setUp(get_name());
		ProductPage productPage = new ProductPage(driver, driverWait, settings);
		productPage.clickAddToCart();
		assert productPage.getCounter() == 1;
	}
	
	@Test
	public void product_RemoveProduct() {
		setUp(get_name());
		ProductPage productPage = new ProductPage(driver, driverWait, settings);
		productPage.clickAddToCart();
		productPage.clickRemove();
		assert productPage.getCounter() == 0;
	}
	
	@Test
	public void product_VerifyProductInfo() {
		setUp(get_name());
		ProductPage productPage = new ProductPage(driver, driverWait, settings);
		String name = productPage.get_product_name();
		String description = productPage.get_product_description();
		String price = productPage.get_product_price();
		actions.compare_text(products.getDescription(name), description);
		actions.compare_text(products.getPrice(name), price);
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
	
	/**
	 * Setup 
	 * @param name Path of evidence
	 */
	private void setUp(String name) {
		create_folder(name);
		login();
		selectFirstProduct();
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		Test_Login.driver.close();
		Category.shutdown();
	}
}
