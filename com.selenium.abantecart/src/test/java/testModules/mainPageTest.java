package testModules;

// Temporary test class, jo bhi test karna he yaha pe karo. 


import org.testng.annotations.Test;

import modules.AbanteCart;
import modules.mainPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class mainPageTest {
	WebDriver driver;
	AbanteCart cart;
	
  @Test
  public void fudduTest(){
	  cart = new AbanteCart(driver);
	  cart.openWebsite();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  cart.closeWebsite();
  }

}
