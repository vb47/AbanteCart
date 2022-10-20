package test_ng.abanteCart;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class checkout {
	WebDriver driver;
	String urlString="http://localhost/abantecart-src-master/public_html/";
	
	@BeforeTest
	public void beforeTest()
	{
		driver=new ChromeDriver();
		driver.get(urlString);

	}

	@Test(priority = 1)
	  public void login()
	  {
		driver.findElement(By.xpath("//*[@id=\'customer_menu_top\']/li/a")).click();
		driver.findElement(By.id("loginFrm_loginname")).sendKeys("heena_gadhinglaj");
		driver.findElement(By.id("loginFrm_password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	  }
	@Test(priority=2)
	public void currency()
	{
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
  
	  @Test(priority = 3)
	  public void checkout()
	  {
		  driver.findElement(By.xpath("//*[@id=\"block_frame_featured_1769\"]/div/div[1]/div[2]/div[3]/a/i")).click();
		  driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fa-fw']")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.id("cart_checkout1")).click(); // checkout btn1
	//	  driver.findElement(By.id("cart_checkout2")).click(); //checkout btn2
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
//		  driver.findElement(By.xpath("//*[@id=\"PayFrm\"]/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/label/div")).click(); //Local Delivery
//		  driver.findElement(By.xpath("//*[@id=\"PayFrm\"]/div[2]/div/table/tbody/tr[4]/td[1]/label/div")).click(); //Flat Shipping Rate
//		  driver.findElement(By.id("checkout_btn")).click();
		  
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	        	FileUtils.copyFile(screenshot, new File("C:\\\\Users\\\\Administrator\\\\Pictures\\\\projectScreenshots\\" + "order1"+" "+timestamp+".png"));
//	            FileUtils.copyFile(screenshot, new File("C:\\Users\\Administrator\\Pictures\\projectScreenshots\\order.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		  
	  }
  
	  @AfterTest
		public void afterTest()
		{
			driver.quit();
		}
}
