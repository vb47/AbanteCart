package testModules;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import modules.UserAccount;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class UserAccountTest {
	WebDriver driver;
	UserAccount account;
//  @Test(priority=1)
//  public void TestRegistraton() throws CsvValidationException, IOException, InterruptedException {
//	  List<String> response = account.userRegistration("./data/datasets/accountRegistration.csv");
//	  for(String data: response) {
//		  System.out.println(data); // TODO: add logs using Log4j.
//	  }
//  }
  
  @Test(dataProvider = "getdatafromcsvfile")
  public void testLoginLogout(String username, String password) throws InterruptedException {
	  account.login(username, password);
	  account.logout();
	  Thread.sleep(3000);
  }
  
  @DataProvider(name="getdatafromcsvfile")
  public Object[][] dp() throws IOException, CsvException {
      String[][] rec;
      CSVReader csvRead= new CSVReader(new FileReader("./data/datasets/LoginCredentials.csv"));
      List<String[]> data = csvRead.readAll();
        rec = new String[data.size()][2];
        for (int i=0; i<data.size(); i++)
        {
            rec[i] = data.get(i);
        }
        return rec;    
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  account = new UserAccount(driver);
	  account.openWebsite("http://10.44.11.219/abantecart-src-master/abantecart-src-master/public_html/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
