package testModules;

import org.testng.annotations.Test;

import modules.HomePage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class HomePageTest {
	WebDriver driver;
	String url = "http://10.44.11.219/abantecart-src-master/abantecart-src-master/public_html/";
	HomePage page;
//  @Test
//  public void checkProductVisibility() {
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
  
  @Test
  public void checkProductByCategory() {
	  page.openWebsite();
	  int temp=0;
	  String[] category1 = page.getProductList(0, 0);
	  for(String data: category1) {
		  if(temp==0) {
			  System.out.println(data);
			  temp=1;
		  }
		  else {
			  temp=0;
		  }
	  }
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
