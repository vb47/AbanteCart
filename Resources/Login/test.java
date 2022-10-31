package AbanteCart;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import AbanteCart.LoginPage;

public class test {
	WebDriver driver;
	LoginPage myWebsite;
	String path = "C:\\Users\\Administrator\\Documents\\credentials.csv";
	
  @Test
  public void f() throws CsvValidationException, IOException, InterruptedException,ArrayIndexOutOfBoundsException {
	  myWebsite.login(path);
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException{
	  driver = new ChromeDriver();
	  myWebsite = new LoginPage(driver);
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  //Thread.sleep(5000);
	  myWebsite.tearDown();
  }

}
