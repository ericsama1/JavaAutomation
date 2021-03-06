package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import utils.Actions;
import data.Products;

import pages.Header;

public class Cart extends Header{
	private Actions actions = new Actions();
	private Products products = new Products();

	public Cart(WebDriver driver, WebDriverWait driverWait, 
			    HashMap<String, Object> settings) {
		super(driver, driverWait, settings);
	}
	
	private By byCartItem = By.className("cart_item");
	private By byItemQuantity = By.className("cart_quantity");
	private By byItemName = By.className("inventory_item_name");
	private By byItemDescription = By.className("inventory_item_desc");
	private By byItemPrice = By.className("inventory_item_price");
	private By byItemRemove = By.xpath(
			"//button[@class='btn_secondary cart_button']");
	private By byItemLink = By.xpath("//a");
	private By byContinueButton = By.xpath("//a[@class='btn_secondary']");
	private By byCheckout = By.xpath("//a[contains(@class,'checkout_button')]");
	
	private WebElement continueShopping = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byContinueButton));
	private WebElement checkoutButton = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byCheckout));
	
	
	/**
	 * Method to remove an item from the cart
	 * @param position Position of the element to remove
	 */
	public void removeItem(int position) {
		List<WebElement> items = driver.findElements(byCartItem);
		WebElement element = items.get(position);
		String name = element.findElement(byItemName).getText();
		WebElement remove = element.findElement(byItemRemove);
		remove.click();
		log.info(String.format("Se quita el elemento %s de la lista", name));
		// Take a screenshot after remove an item from the list
		takeScreenshot(driver);
	}
	
	/**
	 * Method to remove all items from the cart
	 */
	public void removeAllItems() {
		List<WebElement> items = driver.findElements(byCartItem);
		for (WebElement element: items) {
			WebElement remove = element.findElement(byItemRemove);
			String name = element.findElement(byItemName).getText();
			remove.click();
			log.info(String.format("Se quita el elemento %s de la lista", name));
			takeScreenshot(driver);
		}
	}
	
	/**
	 * Method to do a click on the item
	 * @param position Position of the element to click
	 */
	public void clickItem(int position) {
		List<WebElement> items = driver.findElements(byCartItem);
		WebElement element = items.get(position);
		String name = element.findElement(byItemName).getText();
		WebElement link = element.findElement(byItemLink);
		link.click();
		log.info(String.format("Se hace un click sobre el elemento %s", name));
	}
	
	/**
	 * Method to do a click on the continue button
	 */
	public void clickContinue() {
		continueShopping.click();
		log.info("Se hace click sobre el botón 'Continue Shopping'");
	}
	
	/**
	 * Method to do a click on the checkout button
	 */
	public void clickCheckout() {
		checkoutButton.click();
		log.info("Se hace click sobre el botón 'Checkout'");
	}
	
	public void checkProduct() {
		List<WebElement> items = driver.findElements(byCartItem);
		// Check product description and price per product
		for (WebElement element: items) {
			// Get product info
			String name = element.findElement(byItemName).getText();
			String description = element.findElement(byItemDescription)
					.getText();
			String price = element.findElement(byItemPrice).getText();
			// Compare product info with setted product
			actions.compare_text(products.getDescription(name), description, log);
			actions.compare_text(products.getPrice(name).replace("$", ""), price, log);
		}
	}
	
	// Gets

	/**
	 * Method to get the name of an item from the cart
	 * @param position Position of the element to get the name
	 * @return Name of the searched element
	 */
	public String getName(int position) {
		List<WebElement> items = driver.findElements(byCartItem);
		WebElement element = items.get(position);
		return element.findElement(byItemName).getText();
	}
	
	/**
	 * Method to get the quantity of an item from the cart
	 * @param position Position of the element to get the quantity
	 * @return Quantity of the searched element
	 */
	public String getQuantity(int position) {
		List<WebElement> items = driver.findElements(byCartItem);
		WebElement element = items.get(position);
		return element.findElement(byItemQuantity).getText();
	}
	
	/**
	 * Method to get the description of the item in the cart
	 * @param position Position of the element to get the description
	 * @return Description of the item
	 */
	public String getDesciption(int position) {
		List<WebElement> items = driver.findElements(byCartItem);
		WebElement element = items.get(position);
		return element.findElement(byItemDescription).getText();
	}
	
	/**
	 * Method to get the quantity of the element on the cart's list
	 * @return list size
	 */
	public int getListQuantity() {
		try {
			List<WebElement> items = driver.findElements(byCartItem);
			return items.size();
		} catch (NoSuchElementException e) {
			return 0;
		}
	}
}
