package testModules;

// Temporary test class, jo bhi test karna he yaha pe karo. 


import org.testng.annotations.Test;

import modules.AbanteCart;
import modules.HomePage;
import modules.mainPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class mainPageTest {
	WebDriver driver;
	AbanteCart cart;
	HomePage page;
	
  @Test
  public void fudduTest(){
	  page = new HomePage(driver);
	  page.generateProductList();
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
	  
  }

}
