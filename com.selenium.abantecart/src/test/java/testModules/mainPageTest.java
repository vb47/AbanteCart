package testModules;

// Temporary test class, jo bhi test karna he yaha pe karo. 


import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import modules.AbanteCart;
import modules.HomePage;
import modules.UserAccount;
import modules.mainPage;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class mainPageTest {
	WebDriver driver;
	HomePage cart;
	UserAccount account;
	
  @Test
  public void fudduTest() throws CsvValidationException, IOException, InterruptedException{
//	  //Test Cases for Home Page
//	  cart = new HomePage(driver);
//	  //cart.generateProductList();
//	  
//	  cart.searchProductByName("ck one shock for him Deodorant");
//	  
//	  cart.searchProductByName("Paper Towns by John Green");
//	  
//	  Double price1 = cart.getPriceOfProduct("Ruby Shoo Womens Jada T-Bar");
//	  Double price2 = cart.getPriceOfProduct("Lancome Hypnose Doll Lashes Mascara 4-Piece Gift Set");
//	  
//	  System.out.println("Price of  Ruby Shoo Womens Jada T-Bar is $" + price1 + "/-");
//	  System.out.println("Price of Lancome Hypnose Doll Lashes Mascara 4-Piece Gift Set is &" + price2 + "/-");
	  
//	  // User registration testing sample
//	  account = new UserAccount(driver);
//	  List<String> response = account.userRegistration("./data/datasets/accountRegistration.csv");
//	  for(String data: response) {
//		  System.out.println(data);
//	  }
	  
	  // Login and logout testing
	  account = new UserAccount(driver);
	  account.login("Vaibhav", "jaaNahiBatata");
	  Thread.sleep(3000);
	  account.logout();
	  // TODO: DDT on login functionality
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  account.closeWebsite();
  }

}
