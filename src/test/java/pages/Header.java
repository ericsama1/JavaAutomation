package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.AbstractPageObject;

public class Header extends AbstractPageObject{

	public Header(WebDriver driver, WebDriverWait driverWait, HashMap<String, Object> settings) {
		super(driver, driverWait, settings);
	}
	
	private By byMenuButton = By.xpath("//button[text()='Open Menu']");
	private By byCartButton = By.xpath("//*[@data-icon='shopping-cart']");
	private By byAllItems = By.id("inventory_sidebar_link");
	private By byAbout = By.id("about_sidebar_link");
	private By byLogout = By.id("logout_sidebar_link");
	private By byReset = By.id("reset_sidebar_link");
	private By byCounter = By.className("fa-layers-counter shopping_cart_badge");
	
	private WebElement menuButton = driver.findElement(byMenuButton);
	private WebElement cartButton = driver.findElement(byCartButton);
	private WebElement allItemsButton = driver.findElement(byAllItems);
	private WebElement about = driver.findElement(byAbout);
	private WebElement logout = driver.findElement(byLogout);
	private WebElement reset = driver.findElement(byReset);
	
	
	/**
	 * Method to do a click on the menu button
	 */
	public void clickMenu() {
		menuButton.click();
		log.info("Se hace click sobre el botón del menu");
	}
	
	/**
	 * Method to do a click on the car button
	 */
	public void clickCat() {
		cartButton.click();
		log.info("Se hace click sobre el botón del carrito");
	}
	
	/**
	 * Method to do a click on the All Items button
	 */
	public void clickAllItems() {
		allItemsButton.click();
		log.info("Se hace click sobre el botón de All Items");
	}
	
	/**
	 * Method to do a click on the About button
	 */
	public void clickAbout() {
		about.click();
		log.info("Se hace click sobre el botón de About");
	}
	
	/**
	 * Method to do a click on the Logout button
	 */
	public void clickLogout() {
		logout.click();
		log.info("Se hace click sobre el botón de Logout");
	}

	/**
	 * Method to do a click on the Reset button
	 */
	public void clickReset() {
		reset.click();
		log.info("Se hace click sobre el botón de Reset");
	}
	
	public int getCounter() {
		WebElement counter = driver.findElement(byCounter);
		return Integer.parseInt(counter.getText());
	}
}
