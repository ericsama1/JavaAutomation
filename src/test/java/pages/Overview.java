package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.apache.log4j.Logger;
import pages.Header;

public class Overview extends Header{

	public Overview(WebDriver driver, WebDriverWait driverWait, Logger log, String folder) {
		super(driver, driverWait, log, folder);
	}
	
	private By byItems = By.className("cart_item");
	private By byItemName = By.className("inventory_item_name");
	private By byItemQuantity = By.className("summary_quantity");
	private By byItemDescription = By.className("inventory_item_desc");
	private By byItemPrice = By.className("inventory_item_price");
	private By byPaymentSource = By.xpath("//div[@class='summary_value_label'][1]");
	private By byShippingInfo = By.xpath("//div[@class='summary_value_label'][2]");
	private By bySubtotal = By.className("summary_subtotal_label");
	private By byTax = By.className("summary_tax_label");
	private By byTotal = By.className("summary_total_label");
	private By byCancel = By.className("cart_cancel_link btn_secondary");
	private By byFinish = By.className("btn_action cart_button");
	
	private List<WebElement> items = driverWait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(byItems));
	private WebElement paymentSource = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byPaymentSource));
	private WebElement shippingInfo = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byShippingInfo));
	private WebElement subTotal = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(bySubtotal));
	private WebElement tax = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byTax));
	private WebElement total= driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byTotal));
	private WebElement cancelButton = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byCancel));
	private WebElement finishButton = driverWait.until(ExpectedConditions
			.visibilityOfElementLocated(byFinish));
	
	/**
	 * Method to click on the cancel button
	 */
	public void clickCancel() {
		cancelButton.click();
		log.info("Se hace click sobre el botón cancel");
	}
	
	/**
	 * Method to click on the finish button
	 */
	public void clickFinish() {
		finishButton.click();
		log.info("Se hace click sobre el botón finish");
	}
	
	// Gets
	
	/**
	 * Method to get an item's name
	 * @param position Postion of the element to get the name
	 * @return name of the item
	 */
	public String getItemName(int position) {
		WebElement item = items.get(position);
		return item.findElement(byItemName).getText();
	}
	
	/**
	 * Method to get an item's quantity
	 * @param position Position of the element to get the quantity
	 * @return Quantity of the item
	 */
	public String getItemQuantity(int position) {
		WebElement item = items.get(position);
		return item.findElement(byItemQuantity).getText();
	}
	
	/**
	 * Method to get an item's description
	 * @param position Position of the element to get the description
	 * @return Description of the item
	 */
	public String getItemDescription(int position) {
		WebElement item = items.get(position);
		return item.findElement(byItemDescription).getText();
	}
	
	/**
	 * Method to get an item's price
	 * @param position Position of the element to get the price
	 * @return Price of the item
	 */
	public String getItemPrice(int position) {
		WebElement item = items.get(position);
		return item.findElement(byItemPrice).getText();
	}
	
	/**
	 * Method to get the payment source
	 * @return payment source
	 */
	public String getPaymentSource() {
		return paymentSource.getText();
	}
	
	/**
	 * Method to get the shipping info
	 * @return Shipping info
	 */
	public String getShippingInfo() {
		return shippingInfo.getText();
	}
	
	/**
	 * Method to get the subtotal 
	 * @return Subtotal
	 */
	public String getSubTotal() {
		return subTotal.getText();
	}
	
	/**
	 * Method to get the tax
	 * @return Tax
	 */
	public String getTax() {
		return tax.getText();
	}
	
	/**
	 * Method to get the total
	 * @return Total
	 */
	public String getTotal() {
		return total.getText();
	}
	
	/**
	 * Method to get the list of items
	 * @return number the items in the list
	 */
	public int getListSize() {
		return items.size();
	}
	
}
