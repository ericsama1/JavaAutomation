package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import java.util.List;

import pages.Header;

public class Cart extends Header{

	public Cart(WebDriver driver, WebDriverWait driverWait, Logger log, String folder) {
		super(driver, driverWait, log, folder);
	}
	
	private By byCartItem = By.className("cart_item");
	private By byItemQuantity = By.className("cart_quantity");
	private By byItemDescription = By.className("inventory_item_desc");
	private By byItemRemove = By.className("btn_secondary cart_button");
	private By byItemLink = By.xpath("//a");
	private By byContinueButton = By.xpath("//a[@class='btn_secondary']");
	private By byCheckout = By.xpath("//a[contains(@class,'checkout_button')]");
	
	private List<WebElement> items = driverWait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(byCartItem));
	private WebElement continueShopping = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byContinueButton));
	private WebElement checkoutButton = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byCheckout));
	
	
	/**
	 * Method to remove an item from the cart
	 * @param position Position of the element to remove
	 */
	public void removeItem(int position) {
		WebElement element = items.get(position);
		WebElement remove = element.findElement(byItemRemove);
		remove.click();
		// Update the list of the element after remove an element
		items = driver.findElements(byCartItem);
	}
	
	/**
	 * Method to do a click on the item
	 * @param position Position of the element to click
	 */
	public void clickItem(int position) {
		WebElement element = items.get(position);
		WebElement link = element.findElement(byItemLink);
		link.click();
	}
	
	/**
	 * Method to do a click on the continue button
	 */
	public void clickContinue() {
		continueShopping.click();
	}
	
	/**
	 * Method to do a click on the checkout button
	 */
	public void clickCheckout() {
		checkoutButton.click();
	}
	
	// Gets
	
	/**
	 * Method to get the quantity of an item from the cart
	 * @param position Position of the element to get the quantity
	 * @return Quantity of the searched element
	 */
	public String getQuantity(int position) {
		WebElement element = items.get(position);
		return element.findElement(byItemQuantity).getText();
	}
	
	/**
	 * Method to get the description of the item in the cart
	 * @param position Position of the element to get the description
	 * @return Description of the item
	 */
	public String getDesciption(int position) {
		WebElement element = items.get(position);
		return element.findElement(byItemDescription).getText();
	}
}