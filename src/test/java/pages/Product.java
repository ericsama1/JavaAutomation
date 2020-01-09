package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Header;


public class Product extends Header {

	public Product(WebDriver driver, WebDriverWait driverWait, HashMap<String, Object> settings) {
		super(driver, driverWait, settings);
	}
	
	private By byProductName = By.className("inventory_details_name");
	private By byProductDescription = By.className("inventory_details_desc");
	private By byProductPrice = By.className("inventory_details_price");
	private By byAddToCart = By.xpath("//button[@class= 'btn_primary btn_inventory']");
	private By byBackButton = By.className("inventory_details_back_button");
	
	private WebElement productName = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byProductName));
	private WebElement productDescription = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byProductDescription));
	private WebElement productPrice = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byProductPrice));
	private WebElement addToCart = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byAddToCart));
	private WebElement backButton = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byBackButton));
	
	/**
	 * Method to click the back button
	 */
	public void clickBackButton() {
		backButton.click();
		log.info("Se hace click en el botón back");
	}
	
	/**
	 * Method to click the add to cart button
	 */
	public void clickAddToCart() {
		addToCart.click();
		log.info("Se hace click en el botón Add to Cart");
	}
	
	/**
	 * Method to get the product's name
	 * @return Product's name
	 */
	public String get_product_name() {
		return productName.getText();
	}
	
	/**
	 * Method to get the product's description
	 * @return Product's description
	 */
	public String get_product_description() {
		return productDescription.getText();
	}
	
	/**
	 * Method to get the product's price
	 * @return Product's price
	 */
	public String get_product_price() {
		return productPrice.getText();
	}
}
