package viewproduct;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;
import viewproduct.page;

public class Testpage {
	WebDriver driver;
	String url = "https://demo.abantecart.com/";
  @Test
  public void f() {
	  page product =new page(driver);
	  
	  product.generateProductList();
//	  // Search a product in the page
//	  String[] productList = product.getProductList(0, 0);
//	  System.out.println("Getting product list at Home Page: ");
//	  for(String item: productList)
//		  System.out.println(item);
//	  
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: APPAREL & ACCESSORIES ---");
//	  for(int i=1; i<=2; i++) {
//		  String[] productList1 = product.getProductList(1, i);
//		  for(String item: productList1)
//			  System.out.println(item);
//	  }
//
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: MAKEUP ---");
//	  for(int i=1; i<=6; i++) {
//	  String[] productList1 = product.getProductList(2, i);
//	  for(String item: productList1)
//		  System.out.println(item);
//	  }
//	  
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: SKINCARE ---");
//	  for(int i=1; i<=5; i++) {
//		  String[] productList1 = product.getProductList(3, i);
//		  for(String item: productList1)
//			  System.out.println(item); 
//	  }
//	  
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: FRAGNANCE ---");
//	  for(int i=1; i<=2; i++) {
//		  String[] productList1 = product.getProductList(4, i);
//		  for(String item: productList1)
//			  System.out.println(item); 
//	  }
//	  
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: MEN ---");
//	  for(int i=1; i<=4; i++) {
//		  String[] productList1 = product.getProductList(5, i);
//		  for(String item: productList1)
//			  System.out.println(item); 
//	  }
//	  
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: HAIR CARE ---");
//	  for(int i=1; i<=2; i++) {
//		  String[] productList1 = product.getProductList(6, i);
//		  for(String item: productList1)
//			  System.out.println(item); 
//	  }
//	  
//	  // Search a product in the page
//	  System.out.println("--- CATEGORY: BOOKS ---");
//	  for(int i=1; i<=2; i++) {
//		  String[] productList1 = product.getProductList(7, i);
//		  for(String item: productList1)
//			  System.out.println(item); 
//	  }
//	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
