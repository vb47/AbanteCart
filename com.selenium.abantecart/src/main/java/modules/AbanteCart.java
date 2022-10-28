package modules;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	protected Integer ImplicitWaitTime = 5;
	
	@FindBy(xpath="//*[@id=\"customer_menu_top\"]/li/a")
	protected WebElement loginElement;
	
	@FindBy(xpath="//*[@id=\"main_menu_top\"]/li[3]/a")
	protected WebElement cart;
	
	@FindBy(xpath="//*[@id=\"main_menu_top\"]/li[4]/a")
	protected WebElement checkout;
	
	public AbanteCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AbanteCart(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
		PageFactory.initElements(driver, this);
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
	
	/*
	 * Method: getCartDetails
	 * Return: 2D array with 3 columns - Product Name, Product Price and Quantity.
	 * Description: This method returns the cart details.
	 */
	public String[][] getCartDetails() {
		String[][] cartList;
		
		this.openWebsite();
		cart.click();
		
		int rowCount = driver.findElements(By.xpath("//table/tbody/tr/td[@class='name']/a")).size();
		cartList = new String[rowCount][3];
		List<WebElement> quantity = driver.findElements(By.xpath("//input[contains(@id, 'cart_quantity')]"));
		for(int i=1; i<=rowCount; i++) {
			cartList[i-1][0] = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a")).getText();
			cartList[i-1][1] = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/table/tbody/tr["+(i+1)+"]/td[4]")).getText();
			cartList[i-1][2] = quantity.get(i-1).getAttribute("value");
		}
		
		return cartList;
	}
	
	
	
}
