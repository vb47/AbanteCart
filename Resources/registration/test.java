package projectpom;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class Test123{
	private WebDriver driver;
	page p;
	@BeforeTest 
	public void setup()
	{
	
	driver = new ChromeDriver();
	//driver.get("http://abantecart-src-master/abantecart-src-master/public_html/index.php?rt=account/login");
	p= new page(driver);
	//System.out.println("Hi");
	}
	@Test
	public void test() throws IOException ,InterruptedException,
	 CsvValidationException
	{
	 p.userRegistration("C:\\Users\\Administrator\\Desktop\\account.csv");

	}
	
 @AfterTest
  public void afterTest() {
	 driver.quit();
  }
}
