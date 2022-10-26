package abantecart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import abantecart.pages.*;
public class cartBaseClassTest {
	WebDriver driver;
	cartBaseClass cartbaseclass ;
	
	
  @Test
  public void f() throws InterruptedException {  
	  
	 //cartbaseclass.addProductThroughCategory();
	 //cartbaseclass.addProductToWishlist();
	 //cartbaseclass.removeProductFromWishlist(); 
	 //cartbaseclass.addProductFromSpecials();
	 //cartbaseclass.addProductFromWishlist();
	 // cartbaseclass.addProductThroughSearch();
	  cartbaseclass.callToOrderProduct();
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException{
	  WebDriver driver = new ChromeDriver();
	  cartbaseclass = new cartBaseClass(driver);
  }

  @AfterTest
  public void afterTest() {
	  cartbaseclass.tearDown();
  }

}
