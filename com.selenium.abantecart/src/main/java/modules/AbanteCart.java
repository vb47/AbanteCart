package modules;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;

/*
 * Class: AbanteCart
 * Description: Parent Class to handle basic operations for AbanteCart Website.
 * Parameters: 	driver - WebDriver object to inherit driver capabilities.
 * 				url (optional): locally hosted url.
 */
public class AbanteCart {
	WebDriver driver;
	String url = "https://demo.abantecart.com/";
	Integer numberOfItemsInCart;
	String itemsInCart[];
	Double totalAmount;
	Integer ImplicitWaitTime = 5;
	
	public AbanteCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public AbanteCart(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}
	
	// Essential getters and setters
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getNumberOfItemsInCart() {
		return numberOfItemsInCart;
	}
	public String[] getItemsInCart() {
		return itemsInCart;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	
	/*
	 * Method: openWebsite
	 * Description: Opens website using default url using WebDriver.
	 */
	public void openWebsite() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.ImplicitWaitTime));
	}
	
	/*
	 * Method: openWebsite
	 * Parameters: url
	 * Description: Opens website using default url using WebDriver.
	 */
	public void openWebsite(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.ImplicitWaitTime));
	}
	
	/*
	 * Method: closeWebsite
	 * Description: closes the current website handled by WebDriver.
	 */
	public void closeWebsite() {
		driver.close();
	}
	
	// TODO: Add Basic Cart functionality as per UML diagram (Version 3)
	
	
	
}
