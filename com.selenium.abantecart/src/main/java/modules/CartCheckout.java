package modules;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartCheckout extends HomePage{
	WebDriver driver;

	public CartCheckout(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public void testCurrency() {
		//super.openWebsite(super.getUrl() + "index.php?rt=account/login");
		//super.login("admin", "admin");
		super.openWebsite();
		Actions action = new Actions(driver);
		WebElement element=driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[2]/ul/li/a/span"));
		action.moveToElement(element).click().perform();
		WebElement euro=driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[2]/ul/li/ul/li[1]/a"));
		action.moveToElement(euro).click().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element1=driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[2]/ul/li/a/span"));
		action.moveToElement(element1).click().perform();
		WebElement pound=driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[2]/ul/li/ul/li[2]/a"));
		action.moveToElement(pound).click().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element2=driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[2]/ul/li/a/span"));
		action.moveToElement(element2).click().perform();
		WebElement usDollar=driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[2]/ul/li/ul/li[3]/a"));
		action.moveToElement(usDollar).click().perform();
	}
	
	public void testCheckout(String productName) throws InterruptedException
	  {
		  super.openWebsite();
		  super.searchProductByName(productName);
		  
		  try {
			  driver.findElement(By.xpath("//div[@class='productpagecart call_to_order']/a[1]")).click();
		  }
		  catch(Exception e) {
			  driver.findElement(By.xpath("//div[@class='productpagecart']/a[1]")).click();
		  }
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.id("cart_checkout1")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Thread.sleep(5000);
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	        	FileUtils.copyFile(screenshot, new File("./data/screenshots/" + "order1_"+" "+timestamp+".png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		  
	  }
}