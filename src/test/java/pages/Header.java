package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.apache.log4j.Logger;
import pageFactory.AbstractPageObject;

import org.openqa.selenium.By;

public class Header extends AbstractPageObject{

	public Header(WebDriver driver, WebDriverWait driverWait, Logger log, String folder) {
		super(driver, driverWait, log, folder);
	}
	
	private By byMenuButton = By.xpath("//button[text()='Open Menu']");
	private By byCartButton = By.xpath("//*[@data-icon='shopping-cart']");
	
	private WebElement menuButton = driver.findElement(byMenuButton);
	private WebElement cartButton = driver.findElement(byCartButton);
	
	public void clickMenu() {
		menuButton.click();
		log.info("Se hace click sobre el botón del menu");
	}
	
	public void clickCat() {
		cartButton.click();
		log.info("Se hace click sobre el botón del carrito");
	}
}
