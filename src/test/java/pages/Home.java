package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.apache.log4j.Logger;
import pages.Header;

public class Home extends Header{

	public Home(WebDriver driver, WebDriverWait driverWait, Logger log, String folder) {
		super(driver, driverWait, log, folder);
	}

	private By bySelectSort = By.className("product_sort_container");
	private By byProducts = By.className("inventory_item");
	private By byAddToCart = By.xpath("//button[text()='ADD TO CART']");
	
//	private WebElement 
	private Select selectSort = new Select(driver.findElement(bySelectSort));
	private List<WebElement> products = driver.findElements(byProducts);
	
	/**
	 * Method to add an item to the cart
	 * @param position Position of the element to add
	 */
	public void add_item_to_cart(int position) {
		WebElement product = products.get(position);
		WebElement add = product.findElement(byAddToCart);
		add.click();
		log.info(String.format(
				"Se ingresa al carrito, el elemento que se encuentra en la posicion %d",
				position));
	}
	
	/**
	 * Method to add all item to the cart
	 */
	public void add_all_item_to_cart() {
		for (int i = 1; i < products.size(); i++) {
			add_item_to_cart(i);
		}
	}
	
	public void sort_by_name_ascendant() {
		selectSort.selectByVisibleText("Name (A to Z)");
	}
	
	public void sort_by_name_descendant() {
		selectSort.selectByVisibleText("Name (Z to A)");
	}
	
	public void sort_by_price_ascendant() {
		selectSort.selectByVisibleText("Price (low to hight)");
	}
	
	public void sort_by_price_descendant() {
		selectSort.selectByVisibleText("Price (hight to low)");
	}
	
}
