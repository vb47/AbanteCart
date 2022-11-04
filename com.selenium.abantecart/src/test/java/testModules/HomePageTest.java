package testModules;

import org.testng.annotations.Test;

import modules.HomePage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class HomePageTest {
	WebDriver driver;
	String url = "http://10.44.11.219/abantecart-src-master/abantecart-src-master/public_html/";
	HomePage page;
//  @Test
//  public void testProductVisibility() {
//	  
//	  page.openWebsite();
//	  page.searchProductByName("Skinsheen Bronzer Stick");
//	  System.out.println(page.getProductDetails("Skinsheen Bronzer Stick"));
//	  System.out.println("------------------------------------------------");
//	  System.out.println();
//	  
//	  System.out.println(page.getProductDetails("Flash Bronzer Body Gel"));
//	  System.out.println("------------------------------------------------");
//	  System.out.println();
//	  
//	  System.out.println(page.getProductDetails("Instant Extensions Lengthening Mascara"));
//	  System.out.println("------------------------------------------------");
//	  System.out.println();
//  }
  
//  @Test
//  public void testProductByCategory() {
//	  page.openWebsite();
//	  int temp=0;
//	  String[] category1 = page.getProductList(0, 0);
//	  for(String data: category1) {
//		  if(temp==0) {
//			  System.out.println(data);
//			  temp=1;
//		  }
//		  else {
//			  temp=0;
//		  }
//	  }
//	  
//  }
  
//  @Test
//  public void testProductByKeyword() {
//	  page.openWebsite();
//	  page.searchProductByName("Skinsheen Bronzer Stick");
//	  assert(driver.findElement(By.tagName("h1")).getText().contains("Skinsheen Bronzer Stick"));
//	  
//	  
//  }
	
	@Test
	public void f() {
		page.openWebsite();
		page.generateProductList();
	}
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  page = new HomePage(driver);
	  page.setUrl(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
