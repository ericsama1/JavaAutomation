package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Header;

public class Finish extends Header {
	
	public Finish(WebDriver driver, WebDriverWait driverWait, HashMap<String, Object> settings) {
		super(driver, driverWait, settings);
	}
	
	private By byThanks = By.className("complete-header");
	private By byText = By.className("complete-text");
//	private By byLogo = By.className("pony_express");

	private WebElement thanks = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byThanks));
	private WebElement thanksText = driverWait.until(ExpectedConditions.
			visibilityOfElementLocated(byText));
//	private WebElement logo = driverWait.until(ExpectedConditions.
//			visibilityOfElementLocated(byLogo));
	
	// Gets
	
	public String getThanks() {
		return thanks.getText();
	}
	
	public String getThanksText() {
		return thanksText.getText();
	}
	
}
